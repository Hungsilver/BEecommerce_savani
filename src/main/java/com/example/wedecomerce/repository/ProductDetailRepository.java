package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.dto.buy_product.ModelDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    List<ProductDetail> findByProductId(Long productId);

    @Query(value = """
            SELECT
                GROUP_CONCAT(DISTINCT vo.value ORDER BY v.name)
            FROM
                product_detail pd
                JOIN product_de_variant_op pdvo ON pd.id = pdvo.product_detail_id
                JOIN variation_option vo ON pdvo.variant_option_id = vo.id
                JOIN variation v ON vo.variation_id = v.id
            where pd.id = ?1
            GROUP BY
                pd.id
            """, nativeQuery = true)
    String getNameModelByPDId(Long productDetailId);
}

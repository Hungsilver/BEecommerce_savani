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

    @Query(value = """
            select vo.value,v.name
                   from product p
                   join product_detail pd on p.id = pd.product_id
                   join product_de_variant_op pdvo on pd.id = pdvo.product_detail_id
                   join variation_option vo on pdvo.variant_option_id = vo.id
                   join variation v on v.id = vo.variation_id
                   where p.id = ?1 and v.is_tier_variation=true
              """, nativeQuery = true)
    List<List<String>> findModelsByProductId(Long productId);

    List<ProductDetail> findByProductId(Long productId);
}

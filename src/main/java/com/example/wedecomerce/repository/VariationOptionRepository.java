package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.VariationOption;
import com.example.wedecomerce.dto.buy_product.VariationReqDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface VariationOptionRepository extends JpaRepository<VariationOption, Long> {
    @Query("""
            select vo.id,vo.value
            from VariationOption vo 
            join Variation v on vo.variation.id= v.id
            join vo.productDetails pd
            join Product p on pd.id = pd.product.id
            where p.id = ?1 and v.isTierVariation= true 
            and v.id = ?2
            """)
    List<?> findByProductId(Long idProduct, Long idVariation);
}

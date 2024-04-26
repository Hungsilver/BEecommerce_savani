package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Variation;
import com.example.wedecomerce.domain.VariationOption;
import com.example.wedecomerce.dto.buy_product.TierVariationsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface VariationRepository extends JpaRepository<Variation, Long> {


    @Query("""
            select v
            from Variation v
            join VariationOption vo on v.id = vo.variation.id
            join vo.productDetails pd
            join Product p on p.id = pd.product.id
            where p.id=1 and v.isTierVariation= true
                        """)
    List<Variation> findByIsTierVariation(Boolean isTierVariation);

    @Query(value = """
            select distinct vo.value
                 from product p
                 join product_detail pd on p.id = pd.product_id
                 join product_de_variant_op pdvo on pd.id = pdvo.product_detail_id
                 join variation_option vo on pdvo.variant_option_id = vo.id
                 join variation v on v.id = vo.variation_id
                 where p.id = ?1 and v.is_tier_variation=true and v.id = ?2
            """, nativeQuery = true)
    List<String> findTierVariation(Long idProduct, Integer idVariation);
}

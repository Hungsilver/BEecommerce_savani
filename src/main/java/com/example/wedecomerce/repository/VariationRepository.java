package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.Variation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariationRepository extends JpaRepository<Variation,Long> {
}

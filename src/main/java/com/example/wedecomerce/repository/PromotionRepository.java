package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}

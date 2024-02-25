package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}

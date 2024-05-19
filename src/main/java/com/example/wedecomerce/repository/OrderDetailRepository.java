package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<Cart,Long> {

}

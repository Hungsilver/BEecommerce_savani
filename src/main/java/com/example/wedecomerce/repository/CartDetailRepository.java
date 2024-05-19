package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Cart;
import com.example.wedecomerce.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail,Long> {

}

package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Cart;
import com.example.wedecomerce.domain.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview,Long> {

}

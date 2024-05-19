package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Cart;
import com.example.wedecomerce.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {

}

package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Authority;
import com.example.wedecomerce.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,String> {
}

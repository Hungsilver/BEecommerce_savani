package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            select p\s
            from Product p\s
            inner join SubCategory sc on p.subCategory.id = sc.id
            inner join Category c on sc.category.id = c.id
            inner join Category cp on c.categoryParent.id = cp.id
            where cp.id = ?1""")
    Page<Product> findByCategoryId(Pageable pageable, Long id);

        @Query(value = """
                select p \s
                from Product p\s 
                inner join SubCategory sc on p.subCategory.id = sc.id
                inner join Category c on sc.category.id = c.id
                inner join Category cp on c.categoryParent.id = cp.id
                where cp.id = ?1
                """)
        List<Product> findListProductByCategoryId(Long id);

    @Query(value = """
            select p\s
            from Product p\s
            inner join SubCategory sc on p.subCategory.id = sc.id
            where sc.id = ?1""")
    Page<Product> findBySubCategoryId(Pageable pageable, Long id);
}

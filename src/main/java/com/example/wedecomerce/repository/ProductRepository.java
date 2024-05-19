package com.example.wedecomerce.repository;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.dto.buy_product.ProductSellerDTO;
import com.example.wedecomerce.dto.home_page.ProductHomeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
            select p.id,p.name,p.image,new Promotion(p.promotion.id,p.promotion.code,p.promotion.name,p.promotion.type,p.promotion.value),new SubCategory(sc.id,sc.name,sc.image) \s
            from Product p\s 
            inner join SubCategory sc on p.subCategory.id = sc.id
            inner join Category c on sc.category.id = c.id
            inner join Category cp on c.categoryParent.id = cp.id
            where cp.id = ?1
            """)
    Page<Product> findListProductByCategoryId(Pageable pageable, Long id);

    @Query(value = """
            select p\s
            from Product p\s
            inner join SubCategory sc on p.subCategory.id = sc.id
            where sc.id = ?1""")
    Page<Product> findBySubCategoryId(Pageable pageable, Long id);

    // get product is featured
    @Query(value = """
            select p.*
            from product p
            inner join sub_category sc on p.sub_category_id = sc.id
            inner join category c on sc.category_id = c.id
            inner join category cp on c.parent_category_id = cp.id
            inner join promotion pro on pro.id = p.promotion_id
            where cp.id =?1 and p.featured = true;
                        """, nativeQuery = true)
    List<Product> findByProductIsFeatured(Long categoryId);

    boolean existsByCode(String code);

    Optional<Product> findByCode(String code);
}

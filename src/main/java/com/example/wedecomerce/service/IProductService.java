package com.example.wedecomerce.service;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.dto.home_page.CategoriesHomeDTO;
import com.example.wedecomerce.dto.buy_product.ProductSellerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    
    Page<Product> getAll(Pageable pageable);

    List<CategoriesHomeDTO> getAllProductByCategories(Integer numberProduct);

    Product add(Product product);

    Product update(Product product, Long idProduct);

    void deleteById(Long idProduct);

    ProductSellerDTO getOne(String code);
}

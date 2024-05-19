package com.example.wedecomerce.service;

import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.dto.buy_product.ProductSellerDTO;
import com.example.wedecomerce.dto.home_page.CategoriesHomeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductDetailService {
    Page<ProductDetail> getAll(Pageable pageable);

    ProductDetail getOne(Long idProductDetail);

    ProductDetail add(ProductDetail product);

    ProductDetail update(ProductDetail product, Long idProduct);

    void deleteById(Long idProductDetail);

}

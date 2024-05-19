package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.repository.ProductDetailRepository;
import com.example.wedecomerce.service.IProductDetailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductDetailServiceImpl implements IProductDetailService {

     private ProductDetailRepository productDetailRepository;

    @Override
    public Page<ProductDetail> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductDetail getOne(Long idProductDetail) {
        return null;
    }

    @Override
    public ProductDetail add(ProductDetail product) {
        return null;
    }

    @Override
    public ProductDetail update(ProductDetail product, Long idProduct) {
        return null;
    }

    @Override
    public void deleteById(Long idProductDetail) {

    }
}

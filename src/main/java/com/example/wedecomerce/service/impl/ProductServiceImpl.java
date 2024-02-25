package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
     ProductRepository productRepository;

    @Override
        public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product add(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long idProduct) {
        return null;
    }

    @Override
    public void deleteById(Long idProduct) {

    }
}

package com.example.wedecomerce.service;

import com.example.wedecomerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IProductService {
   Page<Product> getAll(Pageable pageable);
   Product add(Product product);
   Product update(Product product,Long idProduct);
   void deleteById(Long idProduct);
}

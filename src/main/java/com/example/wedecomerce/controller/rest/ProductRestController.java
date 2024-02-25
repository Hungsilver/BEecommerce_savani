package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.service.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Tag(name = "Products")
public class ProductRestController {
    private final IProductService iProductService;
    
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam Pageable pageable) {
//        Pageable pageable1 = PageRequest.of(0, 10);
        Page<Product> page = iProductService.getAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @PostMapping("")
    public ResponseEntity<?> saveProduct(@RequestBody ) {
        Pageable pageable1 = PageRequest.of(0, 10);
        Page<Product> page = iProductService.getAll(pageable1);
        return ResponseEntity.ok().body(page.getContent());
    }
}

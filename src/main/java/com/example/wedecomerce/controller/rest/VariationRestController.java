package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.Variation;
import com.example.wedecomerce.domain.VariationOption;
import com.example.wedecomerce.dto.buy_product.ProductDetailDTO;
import com.example.wedecomerce.dto.buy_product.ProductSellerDTO;
import com.example.wedecomerce.dto.buy_product.TierVariationsDTO;
import com.example.wedecomerce.repository.ProductDetailRepository;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.repository.VariationOptionRepository;
import com.example.wedecomerce.repository.VariationRepository;
import com.example.wedecomerce.service.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/api/variations")
@Tag(name = "Variations")
@CrossOrigin(origins = "*")
public class VariationRestController {
    private final IProductService productService;
    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final VariationRepository variationRepository;
    private final VariationOptionRepository variationOptionRepository;


    @GetMapping("get/{id}")
    public ResponseEntity<?> getAllVariationLike1(@PathVariable("id") Long id) {
//        ProductSellerDTO productSellerDTO = productService.getOne(id);
        return ResponseEntity.ok().body(null);
    }


    @PostMapping("")
    public ResponseEntity<?> saveProduct() {
        Pageable pageable1 = PageRequest.of(0, 10);
        Page<Product> page = productService.getAll(pageable1);
        return ResponseEntity.ok().body(page.getContent());
    }
}

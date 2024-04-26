package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.controller.rest.errors.BadRequestAlertException;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.dto.buy_product.ProductSellerDTO;
import com.example.wedecomerce.repository.CategoryRepository;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.repository.SubCategoryRepository;
import com.example.wedecomerce.service.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Tag(name = "Products")
public class ProductRestController {
    private final IProductService productService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllProducts(
            @ParameterObject Pageable pageable
//            @RequestParam(name = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
//            @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize,
//            @RequestParam(name = "sort", defaultValue = "ASC", required = false) String sort,
//            @RequestParam(name = "field", required = false) String fieldSort
    ) {
//        Sort.Direction direction = sort.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
//        Sort sortPage = Sort.by();
        Pageable pageableReq = PageRequest.of(0, 10);
        Page<Product> page = productService.getAll(pageableReq);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/products-by-subCategory-id/{id}")
    public ResponseEntity<?> getProductsBySubCategory(@PathVariable("id") Long id, @ParameterObject Pageable pageable) {
        if (id == null) {
            throw new BadRequestAlertException("id SUBCAtegory cannot be null", "product", "idSubcategory");
        }
        if (!subCategoryRepository.existsById(id)) {
            throw new BadRequestAlertException("id SUBCAtegory not exist", "subCategory", "idSubcategory");
        }
        Page<Product> products = productRepository.findBySubCategoryId(pageable, id);
        return ResponseEntity.ok().body(products);
    }


    @PostMapping("")
    public ResponseEntity<?> saveProduct() {
        Pageable pageable1 = PageRequest.of(0, 10);
        Page<Product> page = productService.getAll(pageable1);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/products-by-category")
    public ResponseEntity<?> getProductAllCateHome() {
        List<?> productsByCate = productService.getAllProductByCategories(5); //number product want show
        return ResponseEntity.ok().body(productsByCate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long id) {
        if (id == null) {
            throw new BadRequestAlertException("id product cannot be null", "product", "id");
        }
        if (!productRepository.existsById(id)) {
            throw new BadRequestAlertException("id product not exist", "product", "id");
        }
        ProductSellerDTO product = productService.getOne(id);
        return ResponseEntity.ok().body(product);
    }

}

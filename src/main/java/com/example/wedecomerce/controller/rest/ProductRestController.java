package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.controller.rest.exception.BadRequestAlertException;
import com.example.wedecomerce.controller.rest.exception.NotFoundException;
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
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Tag(name = "Products")
@CrossOrigin(origins = "*")
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
            throw new NotFoundException("id subcate null");
        }
        if (!subCategoryRepository.existsById(id)) {
            throw new NotFoundException("Subcate not exist");
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


    @GetMapping("/{code}")
    public ResponseEntity<?> getProductByCode(@PathVariable(value = "code") String code) {
        if (code == null) {
            throw new NotFoundException("code product null");
        }
        if (!productRepository.existsByCode(code)) {
            throw new NotFoundException("product not exists");
        }
        ProductSellerDTO product = productService.getOne(code);
        return ResponseEntity.ok().body(product);
    }

}

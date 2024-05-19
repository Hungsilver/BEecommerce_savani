package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.dto.home_page.CategoriesHomeDTO;
import com.example.wedecomerce.repository.CategoryRepository;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.service.ICategoriesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@Tag(name = "Categories")
@CrossOrigin(origins = "*")
public class CategoryRestController {
    private final CategoryRepository categoryRepository;
    private final ICategoriesService categoriesService;
    private final ProductRepository productRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllCategories(
//            @ParameterObject Pageable pageable
//            @RequestParam(name = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
//            @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize,
//            @RequestParam(name = "sort", defaultValue = "ASC", required = false) String sort,
//            @RequestParam(name = "field", required = false) String fieldSort
    ) {
//        Sort.Direction direction = sort.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
//        Sort sortPage = Sort.by();
//        Pageable pageableReq = PageRequest.of(0, 10);
//        Page<Category> page = categoryRepository.findAllByCategoryParentIsNull(pageable);
        List<CategoriesHomeDTO> list = categoriesService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("")
    public ResponseEntity<?> saveCategory() {
        return ResponseEntity.ok().body(null);
    }

//    @GetMapping("/product-by-category_home_page")
//    public ResponseEntity<?> listProductByCategory() {
//        List<Product> list = productRepository.();
//        System.out.println(list);
//        return ResponseEntity.ok().body(list);
//    }
}

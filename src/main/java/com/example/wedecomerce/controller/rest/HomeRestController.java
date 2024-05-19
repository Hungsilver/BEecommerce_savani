package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.dto.home_page.CategoriesHomeDTO;
import com.example.wedecomerce.repository.CategoryRepository;
import com.example.wedecomerce.service.ICategoriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/home-page")
@Tag(name = "Home Page")
public class HomeRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ICategoriesService categoriesService;

    @GetMapping("")
    @Operation(summary = "lấy tất cả data category chính và cate phụ và sản phẩm có featured = true")
    private ResponseEntity<?> dataProductsInCategory() {
        List<CategoriesHomeDTO> categoriesHomeDTOs = categoriesService.getAll();
        return ResponseEntity.ok(categoriesHomeDTOs);
    }
}

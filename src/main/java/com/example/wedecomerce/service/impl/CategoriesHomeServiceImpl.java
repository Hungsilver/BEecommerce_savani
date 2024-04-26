package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.SubCategory;
import com.example.wedecomerce.dto.home_page.CategoriesHomeDTO;
import com.example.wedecomerce.dto.home_page.CategoryChildrenHomeDTO;
import com.example.wedecomerce.dto.home_page.ProductHomeDTO;
import com.example.wedecomerce.dto.home_page.SubCategoriesHomeDTO;
import com.example.wedecomerce.repository.CategoryRepository;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.repository.SubCategoryRepository;
import com.example.wedecomerce.service.ICategoriesService;
import com.example.wedecomerce.service.mapper.CategoryMapper;
import com.example.wedecomerce.service.mapper.ProductMapper;
import com.example.wedecomerce.service.mapper.SubCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class CategoriesHomeServiceImpl implements ICategoriesService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoriesHomeDTO> getAll() {
        List<Category> categories = categoryRepository.findAllByCategoryParentIsNull();
        List<CategoriesHomeDTO> dtoList = categories.stream().map(
                cate -> {
                    List<Product> products = productRepository.findByProductIsFeatured(cate.getId());
                    List<ProductHomeDTO> productHomes = ProductMapper.mapListProductToProductHomeDTOs(products);
                    List<CategoryChildrenHomeDTO> categoryChildrenHomeDTOS = CategoryMapper.mapCategoriesToCategoriesChildrenHomeDTO(cate.getCategoriesChild().stream().toList());

                    return CategoriesHomeDTO.builder()
                            .id(cate.getId())
                            .name(cate.getName())
                            .status(cate.getStatus())
                            .thumbnail(cate.getThumbnail())
                            .products(productHomes)
                            .categoriesChildren(categoryChildrenHomeDTOS.subList(0, Math.min(categoryChildrenHomeDTOS.size(), 5)))
                            .build();
                }

        ).collect(Collectors.toList());
        return dtoList;
    }
}

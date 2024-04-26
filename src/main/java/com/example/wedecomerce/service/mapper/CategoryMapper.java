package com.example.wedecomerce.service.mapper;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.SubCategory;
import com.example.wedecomerce.dto.home_page.CategoryChildrenHomeDTO;
import com.example.wedecomerce.dto.home_page.SubCategoriesHomeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryChildrenHomeDTO mapCategoryToCategoryChildrenHomeDTO(Category category) {
        return CategoryChildrenHomeDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .status(category.getStatus())
                .thumbnail(category.getThumbnail())
                .description(category.getDescription())
                .categoryParent(category.getCategoryParent().getId())
                .build();
    }

    public static List<CategoryChildrenHomeDTO> mapCategoriesToCategoriesChildrenHomeDTO(List<Category> categories) {
        return categories.stream().map(item ->
                                               mapCategoryToCategoryChildrenHomeDTO(item)
        ).collect(Collectors.toList());
    }
}

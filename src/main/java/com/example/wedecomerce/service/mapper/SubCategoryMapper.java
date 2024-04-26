package com.example.wedecomerce.service.mapper;

import com.example.wedecomerce.domain.SubCategory;
import com.example.wedecomerce.dto.home_page.SubCategoriesHomeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryMapper {

    public static SubCategoriesHomeDTO mapSubCategoryToSubCategoryHomeDTO(SubCategory subCate) {
        return SubCategoriesHomeDTO.builder()
                .id(subCate.getId())
                .name(subCate.getName())
                .status(subCate.getStatus())
                .thumbnail(subCate.getImage())
                .description(subCate.getDescription())
                .build();
    }

    public static List<SubCategoriesHomeDTO> mapSubCategoriesToSubCategoriesHomeDTO(List<SubCategory> subCates) {
        return subCates.stream().map(item ->
                                             mapSubCategoryToSubCategoryHomeDTO(item)
        ).collect(Collectors.toList());
    }
}

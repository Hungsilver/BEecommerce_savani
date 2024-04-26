package com.example.wedecomerce.service.mapper;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.dto.home_page.ProductHomeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductHomeDTO mapProductToProductHomeDTO(Product product) {
        return ProductHomeDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .thumbnail(product.getImage())
                .status(product.getStatus())
                .promotionId(product.getPromotion().getId())
                .subCategoryId(product.getSubCategory().getId())
                .build();
    }

    public static List<ProductHomeDTO> mapListProductToProductHomeDTOs(List<Product> products) {
        return products.stream()
                .map(item ->
                             mapProductToProductHomeDTO(item)
                ).collect(Collectors.toList());
    }
}

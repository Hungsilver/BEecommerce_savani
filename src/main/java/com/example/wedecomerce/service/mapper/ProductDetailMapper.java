package com.example.wedecomerce.service.mapper;

import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.Promotion;
import com.example.wedecomerce.dto.buy_product.ProductDetailDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDetailMapper {
    public static ProductDetailDTO mapProductDetailToProductDetailDTO(ProductDetail productDetail) {
        BigDecimal price = productDetail.getPrice();
        Integer discount = null;
        Optional<Promotion> promotion = Optional.ofNullable(productDetail.getProduct().getPromotion());
        if (promotion.isPresent()) {
            price = price.subtract((price.multiply(promotion.get().getValue())).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
            discount = promotion.get().getValue().intValue();
        }
        List<String> listName = productDetail.getVariationOptions().stream().map(variation ->
                variation.getValue()
        ).collect(Collectors.toList());
        String nameAttribute = String.join(",", listName);
        return ProductDetailDTO.builder()
                .id(productDetail.getId())
                .name(nameAttribute)
                .price(price)
                .nameProduct(productDetail.getProduct().getName())
                .priceBeforeDiscount(productDetail.getPrice())
                .productId(productDetail.getProduct().getId())
                .showDiscount(discount)
                .featured(productDetail.getFeatured())
                .image(productDetail.getImage())
                .status(productDetail.getStatus())
                .sku(productDetail.getSku())
                .sold(productDetail.getSold())
                .stock(productDetail.getQuantity())
                .build();
    }

}

package com.example.wedecomerce.service.mapper;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.Promotion;
import com.example.wedecomerce.dto.home_page.ProductHomeDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductHomeDTO mapProductToProductHomeDTO(Product product) {
        BigDecimal priceMin = new BigDecimal("0"); //price min in list product detail of Product(giá sau khi đã giảm)
        int sold = 0;
        BigDecimal priceBeforeDiscount = new BigDecimal("0");//giá trước khi được giảm
        Optional<Promotion> promotion = Optional.ofNullable(product.getPromotion());
        BigDecimal discount = promotion.isPresent() ? promotion.get().getValue() : new BigDecimal("0");
        Set<ProductDetail> productDetails = product.getProductDetails();
        // get min price show seller
        if (!productDetails.isEmpty()) {
            priceMin = productDetails.iterator().next().getPrice();
            for (ProductDetail detail : productDetails) {
//                priceMin = Math.min(priceMin, detail.getPrice());
                priceMin = priceMin.compareTo(detail.getPrice()) < 0 ? priceMin : detail.getPrice();
                sold += detail.getSold();
            }
        }

        return ProductHomeDTO.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .thumbnail(product.getImage())
                .status(product.getStatus())
                .price(priceMin.subtract((priceMin.multiply(discount)).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)))
                .sold(sold)
                .priceBeforeDiscount(priceMin)
                .showDiscount(discount.intValue())
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

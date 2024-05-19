package com.example.wedecomerce.dto.orders.response;

import lombok.*;

import java.math.BigDecimal;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailInOrderRes {
    private Long id;
    private String nameModel; // name variation-option
    private String nameProduct;
    private BigDecimal price;
    private Integer quantity;
}

package com.example.wedecomerce.dto.cart;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartDetailResponseDTO {
    private Long id;
    private Long idProductDetail;
    private String nameProduct;
    private String nameModel;
    private BigDecimal price;
    private Integer discount;
    private BigDecimal priceBeforeDiscount;
    private Integer quantity;
    private String image;
    private Instant createdDate;
    private Instant updatedDate;
}

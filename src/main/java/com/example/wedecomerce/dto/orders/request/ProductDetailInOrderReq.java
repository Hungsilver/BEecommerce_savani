package com.example.wedecomerce.dto.orders.request;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDetailInOrderReq {
    private Long idProductDetail;
    private Integer quantity;

    @Override
    public String toString() {
        return "ProductDetailInOrder{" +
                "idProductDetail=" + idProductDetail +
                ", quantity=" + quantity +
                '}';
    }
}

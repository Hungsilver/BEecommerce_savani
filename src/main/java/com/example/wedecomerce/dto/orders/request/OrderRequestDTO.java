package com.example.wedecomerce.dto.orders.request;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDTO {
    private List<ProductDetailInOrderReq> productsInOrder;
    private Long couponId;
    private BigDecimal shippingFee;
    private Long paymentId;
    private String address;
    private String ward;
    private String district;
    private String province;

    @Override
    public String toString() {
        return "OrderShoppingRequestDTO{" +
                "productsInOrder=" + productsInOrder +
                ", couponId=" + couponId +
                ", paymentId=" + paymentId +
                ", shippingFee=" + shippingFee +
                '}';
    }
}

package com.example.wedecomerce.dto.orders.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {
    private Long id;
    private List<ProductDetailInOrderRes> orderDetails;
    private String nameCustomer;
    private String payment;
    private BigDecimal totalOrder;
    private BigDecimal discount;
    private BigDecimal shippingFee;
    private String address;
    private String ward;
    private String district;
    private String province;
    private Instant createdDate;
    private Instant updatedDate;


}

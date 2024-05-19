package com.example.wedecomerce.service.mapper;

import com.example.wedecomerce.domain.OrderDetail;
import com.example.wedecomerce.domain.Orders;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.dto.orders.request.ProductDetailInOrderReq;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static List<OrderDetail> mapOrderDetailRequestsToOrderDetails(List<ProductDetailInOrderReq> productDetailInOrderReqs, Orders ordersSaved) {
//        List<OrderDetail> orderDetails = orderRequestDTO.getProductsInOrder().stream().map(item -> {
//            ProductDetail productDetail = productDetailRepository.findById(item.getIdProductDetail()).orElse(null);
//            return mapProductDetailInOrderReqToOrderDetail(productDetail, ordersSaved)
//        }).collect(Collectors.toList());
        return null;
    }

    public static OrderDetail mapProductDetailInOrderReqToOrderDetail(ProductDetailInOrderReq productDetailInOrderReq, Orders ordersSaved) {
//        OrderDetail.builder()
//                .orders(ordersSaved)
//                .price(item.getPrice())
//                .quantity(item.getQuantity())
//                .productDetail(productDetail)
//                .createDate(Instant.now())
//                .status(1)
//                .updateDate(Instant.now())
//                .build();
        return null;
    }
}

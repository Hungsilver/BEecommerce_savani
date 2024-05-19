package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.*;
import com.example.wedecomerce.dto.orders.request.OrderRequestDTO;
import com.example.wedecomerce.dto.orders.request.ProductDetailInOrderReq;
import com.example.wedecomerce.dto.orders.response.OrderResponseDTO;
import com.example.wedecomerce.dto.orders.response.ProductDetailInOrderRes;
import com.example.wedecomerce.repository.*;
import com.example.wedecomerce.service.IOrderService;
import com.example.wedecomerce.service.IUserService;
import com.example.wedecomerce.service.exception.NotFoundEntityException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductDetailRepository productDetailRepository;
    private final CartDetailRepository cartDetailRepository;
    private final CouponRepository couponRepository;
    private final PromotionRepository promotionRepository;
    private final PaymentRepository paymentRepository;
    private final StatusRepository statusRepository;
    private final IUserService userService;

    @Override
    public OrderResponseDTO orderOnline(OrderRequestDTO orderRequestDTO) {

        User user = userService.getUserCurrentLogin();//get userLogin
        Payment payment = orderRequestDTO.getPaymentId() != null ? paymentRepository.findById(orderRequestDTO.getPaymentId()).orElse(null) : null;
        Coupon coupon = orderRequestDTO.getCouponId() != null ? couponRepository.findById(orderRequestDTO.getCouponId()).orElse(null) : null;
        Status status = statusRepository.findById(1L).orElse(null);

        Orders ordersSaved = Orders.builder()
                .shippingFee(orderRequestDTO.getShippingFee())
                .coupon(coupon)
                .payment(payment)
                .user(user)
                .address(orderRequestDTO.getAddress())
                .ward(orderRequestDTO.getWard())
                .district(orderRequestDTO.getDistrict())
                .province(orderRequestDTO.getWard())
                .status(status)
                .createDate(Instant.now())
                .updateDate(Instant.now())
                .build();

        List<OrderDetail> orderDetails = new ArrayList<>(); // ds orderDetails
        BigDecimal totalOrder = new BigDecimal("0"); // tong tien hoa don

        for (ProductDetailInOrderReq item : orderRequestDTO.getProductsInOrder()) {
            ProductDetail productDetail = productDetailRepository.findById(item.getIdProductDetail()).orElse(null);
//            if (productDetail == null) throw new NotFoundEntityException("Not found product detail ");
            if (productDetail == null) return null;
            Product product = productDetail.getProduct();
            String nameModels = productDetailRepository.getNameModelByPDId(item.getIdProductDetail());
            Promotion promotion = promotionRepository.findById(productDetail.getProduct().getPromotion().getId()).orElse(null);
            BigDecimal price = productDetail.getPrice(); // gia sp
            if (promotion != null) {
                price = price.subtract((price.multiply(promotion.getValue())).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
            }
            totalOrder = totalOrder.add(price.multiply(BigDecimal.valueOf(item.getQuantity())));
            OrderDetail orderDetail = OrderDetail.builder()
                    .orders(ordersSaved)
                    .price(price)
                    .quantity(item.getQuantity())
                    .productDetail(productDetail)
                    .name(product.getName())
                    .nameModels(nameModels)
                    .status(1)
                    .createDate(Instant.now())
                    .updateDate(Instant.now())
                    .build();
            orderDetails.add(orderDetail);
        }

        ordersSaved.setOrderDetails(orderDetails);

        if (coupon != null) { // set total if have a coupon
            totalOrder = totalOrder.subtract((totalOrder.multiply(coupon.getValue())).movePointLeft(2));
        }
        totalOrder = totalOrder.subtract(orderRequestDTO.getShippingFee());
        ordersSaved.setOrderTotal(totalOrder);
        Orders order = orderRepository.save(ordersSaved);

        if (order == null) return null;

        OrderResponseDTO orderResponseDTO = OrderResponseDTO.builder()
                .id(order.getId())
                .totalOrder(order.getOrderTotal())
                .orderDetails(mapProductDetailTO(order.getOrderDetails()))
                .discount(order.getCoupon() != null ? order.getCoupon().getValue() : null)
                .payment(order.getPayment() != null ? order.getPayment().getName() : "Thanh toán khi nhận hàng")
                .shippingFee(order.getShippingFee())
                .address(order.getAddress())
                .ward(order.getWard())
                .district(order.getDistrict())
                .province(order.getWard())
                .nameCustomer(user == null ? "Khách lẻ" : user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName())
                .createdDate(Instant.now())
                .updatedDate(Instant.now())
                .build();

        //update sold ,stock productDetail
        orderRequestDTO.getProductsInOrder().forEach(item -> {
            ProductDetail productDetail = productDetailRepository.findById(item.getIdProductDetail()).orElse(null);
            if (productDetail == null) return;
            productDetail.setSold(productDetail.getSold() + item.getQuantity());
            productDetail.setQuantity(productDetail.getQuantity() - item.getQuantity());
            productDetailRepository.save(productDetail);
        });


        return orderResponseDTO;
    }


    private List<ProductDetailInOrderRes> mapProductDetailTO(List<OrderDetail> orderDetails) {
        return orderDetails.stream().map(item ->
                ProductDetailInOrderRes.builder()
                        .id(item.getProductDetail().getId())
                        .nameProduct(item.getProductDetail().getProduct().getName())
                        .nameModel(item.getNameModels())
                        .price(item.getPrice())
                        .quantity(item.getQuantity())
                        .build()
        ).collect(Collectors.toList());
    }
}

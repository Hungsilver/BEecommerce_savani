package com.example.wedecomerce.service;

import com.example.wedecomerce.dto.orders.request.OrderRequestDTO;
import com.example.wedecomerce.dto.orders.response.OrderResponseDTO;

public interface IOrderService {
    OrderResponseDTO orderOnline(OrderRequestDTO orderRequestDTO);
}

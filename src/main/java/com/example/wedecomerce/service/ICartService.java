package com.example.wedecomerce.service;

import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.dto.buy_product.ProductDetailDTO;
import com.example.wedecomerce.dto.cart.CartDetailResponseDTO;

import java.util.List;

public interface ICartService {

    List<CartDetailResponseDTO> getCart();

    CartDetailResponseDTO updateToCart(Long productDetailId, Integer quantity);

    CartDetailResponseDTO updateCart(Long productDetailId, Integer quantity);
}

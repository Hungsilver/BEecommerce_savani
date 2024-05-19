package com.example.wedecomerce.service.mapper;

import com.example.wedecomerce.domain.Cart;
import com.example.wedecomerce.domain.CartDetail;
import com.example.wedecomerce.dto.buy_product.ProductDetailDTO;
import com.example.wedecomerce.dto.cart.CartDetailResponseDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static List<CartDetailResponseDTO> mapCartToCartResponseDTOs(Cart cart) {
        return cart.getCartDetails().stream().map(CartMapper::mapCartDetailToCartResponseDTO
        ).collect(Collectors.toList());
    }

    public static CartDetailResponseDTO mapCartDetailToCartResponseDTO(CartDetail cartDetail) {
        ProductDetailDTO proDto = ProductDetailMapper.mapProductDetailToProductDetailDTO(cartDetail.getProductDetail());
        return CartDetailResponseDTO.builder()
                .id(cartDetail.getId())
                .idProductDetail(proDto.getId())
                .nameProduct(proDto.getNameProduct())
                .nameModel(proDto.getName())
                .discount(proDto.getShowDiscount())
                .quantity(cartDetail.getQuantity())
                .price(proDto.getPrice())
                .image(proDto.getImage())
                .priceBeforeDiscount(proDto.getPriceBeforeDiscount())
                .createdDate(cartDetail.getCreateDate())
                .updatedDate(cartDetail.getUpdateDate())
                .build();
    }

}

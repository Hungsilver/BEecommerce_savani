package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.Cart;
import com.example.wedecomerce.domain.CartDetail;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.User;
import com.example.wedecomerce.dto.buy_product.ProductDetailDTO;
import com.example.wedecomerce.dto.cart.CartDetailResponseDTO;
import com.example.wedecomerce.repository.*;
import com.example.wedecomerce.security.SecurityUtils;
import com.example.wedecomerce.service.ICartService;
import com.example.wedecomerce.service.IUserService;
import com.example.wedecomerce.service.mapper.CartMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final ProductDetailRepository productDetailRepository;
    private final IUserService userService;

    @Override
    public List<CartDetailResponseDTO> getCart() {
        Cart cart = getCartFromLogin();
        List<CartDetailResponseDTO> listCDetail = CartMapper.mapCartToCartResponseDTOs(cart);
        return listCDetail == null ? Collections.emptyList() : listCDetail;
    }

    @Override
    public CartDetailResponseDTO updateToCart(Long productDetailId, Integer quantity) { //quantity +1 or -1
        Cart cart = getCartFromLogin(); // Lấy giỏ hàng từ phiên đăng nhập
        if (cart == null) return null; // Nếu không có giỏ hàng hoặc phiên đăng nhập không hợp lệ

        Optional<CartDetail> existingCartDetail = cart.getCartDetails().stream()
                .filter(item -> item.getProductDetail().getId().equals(productDetailId))
                .findFirst();

        if (existingCartDetail.isPresent()) {
            // Sản phẩm đã tồn tại trong giỏ hàng
            CartDetail cartDetail = existingCartDetail.get();
            int newQuantity = cartDetail.getQuantity() + quantity; // vi khong cho sua soluong truc tiep nen luon dung
            if (newQuantity > 0) {
                cartDetail.setQuantity(newQuantity);
                cartDetail.setUpdateDate(Instant.now());
                return CartMapper.mapCartDetailToCartResponseDTO(cartDetailRepository.save(cartDetail));
            } else {
                cartDetailRepository.delete(cartDetail);
            }

        } else {
            // Sản phẩm mới
            ProductDetail productDetail = productDetailRepository.findById(productDetailId).orElse(null);
            if (productDetail != null && quantity > 0) {
                CartDetail cartDetail = CartDetail.builder()
                        .cart(cart)
                        .quantity(quantity)
                        .productDetail(productDetail)
                        .createDate(Instant.now())
                        .updateDate(Instant.now())
                        .build();
                return CartMapper.mapCartDetailToCartResponseDTO(cartDetailRepository.save(cartDetail));
            }
        }
        // Không tìm thấy sản phẩm hoặc số lượng không hợp lệ
        return null;
    }


    @Override
    public CartDetailResponseDTO updateCart(Long productDetailId, Integer quantity) {
        Cart cart = getCartFromLogin(); // gio hang login
        if (cart == null) return null; // login sai hoac chua login
        Optional<CartDetail> existingCartDetail = cart.getCartDetails().stream().filter(
                c -> c.getProductDetail().getId().equals(productDetailId)
        ).findFirst();

        return null;
    }


    private Cart getCartFromLogin() {

        User user = userService.getUserCurrentLogin();
        if (user == null) {
            return null; // it loi xay ra
        }
//        Optional<Cart> cart = cartRepository.findByUserId(user.getId());
        if (user.getCart() == null) {
            return cartRepository.save(Cart.builder().createDate(Instant.now()).updateDate(Instant.now()).build());
        }
        return user.getCart();
    }
}

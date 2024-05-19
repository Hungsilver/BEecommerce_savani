package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.common.BaseResponse;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.dto.buy_product.ProductDetailDTO;
import com.example.wedecomerce.dto.cart.CartDetailResponseDTO;
import com.example.wedecomerce.service.ICartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "Cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CartRestController {


    private final ICartService cartService;


    @GetMapping("")
    private ResponseEntity<BaseResponse<List<CartDetailResponseDTO>>> getAll() {
        List<CartDetailResponseDTO> cart = cartService.getCart();
        return ResponseEntity.ok(
                BaseResponse.<List<CartDetailResponseDTO>>builder()
                        .data(cart)
                        .build()
        );
    }

    @GetMapping("/updateCart")
    private ResponseEntity<BaseResponse<CartDetailResponseDTO>> updateToCart(
            @RequestParam("idProductDetail") Long idProductDetail,
            @RequestParam("quantity") Integer quantity
    ) {
        CartDetailResponseDTO cartDetailResponseDTO = cartService.updateToCart(idProductDetail, quantity);
        return ResponseEntity.ok(
                BaseResponse.<CartDetailResponseDTO>builder()
                        .data(cartDetailResponseDTO)
                        .build()
        );
    }

    @PutMapping("")
    private ResponseEntity<?> updateToCart() {
        return null;
    }

    @DeleteMapping("")
    private ResponseEntity<?> deleteToCart() {
        return null;
    }
}

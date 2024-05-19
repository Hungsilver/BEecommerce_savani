package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.common.BaseErrorResponse;
import com.example.wedecomerce.common.BaseResponse;
import com.example.wedecomerce.controller.rest.exception.NotFoundListProductDetailInOrderException;
import com.example.wedecomerce.dto.orders.request.OrderRequestDTO;
import com.example.wedecomerce.dto.orders.response.OrderResponseDTO;
import com.example.wedecomerce.service.IOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pay")
@Tag(name = "Pay")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PayRestController {

    private final IOrderService orderService;


    @GetMapping("")
    private ResponseEntity<BaseErrorResponse> getAll() {
        return ResponseEntity.ok(null);
    }


    @PostMapping("order-online")
    private ResponseEntity<BaseResponse<OrderResponseDTO>> orderOnline(@RequestBody OrderRequestDTO orderRequestDTO) {
        if (orderRequestDTO.getProductsInOrder().size() == 0) {
            throw new NotFoundListProductDetailInOrderException();
        }
        OrderResponseDTO orderResponseDTO = orderService.orderOnline(orderRequestDTO);

        return ResponseEntity.ok(
                BaseResponse.<OrderResponseDTO>builder()
                        .data(orderResponseDTO)
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

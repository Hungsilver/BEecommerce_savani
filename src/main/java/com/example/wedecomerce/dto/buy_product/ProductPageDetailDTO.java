package com.example.wedecomerce.dto.buy_product;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPageDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Double minPrice;

    private Double maxPrice;

    private String description;

    private String status;

    @Size(max = 256)
    private String image;

//    private List<String> images;

    private Long promotionId;

    private Integer sold;

    private Integer quantity;



}

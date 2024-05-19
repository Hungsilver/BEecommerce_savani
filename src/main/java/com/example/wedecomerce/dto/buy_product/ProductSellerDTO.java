package com.example.wedecomerce.dto.buy_product;

import com.example.wedecomerce.config.Constants;
import com.example.wedecomerce.domain.Authority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductSellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private BigDecimal priceMin;

    private BigDecimal priceMax;

    private BigDecimal priceMinBeforeDiscount;

    private BigDecimal priceMaxBeforeDiscount;

    private Integer showDiscount; // %

    private String description;

    private Integer status;

    @Size(max = 256)
    private String image;

    @Size(max = 256)
    private List<String> images;

    private Long promotionId;

    private Integer sold;

    private Integer stock;

//    private ModelDTO models;

    private List<TierVariationsDTO> tierVariations;

    private List<?> models;

}

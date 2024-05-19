package com.example.wedecomerce.dto.home_page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductHomeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String code;

    private String name;

    private String thumbnail;

    private Integer status;

    private Integer showDiscount;

    private BigDecimal price;

    private Integer sold; // luot ban

    private BigDecimal priceBeforeDiscount;

    private Long subCategoryId;
}

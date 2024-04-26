package com.example.wedecomerce.dto;

import com.example.wedecomerce.domain.Promotion;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductHomePageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private String status;

    @Size(max = 256)
    private String image;

    private Promotion promotion;

    private Double priceAfterReduction;

    private Double priceRoot;

    private List<?> colors;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;



}

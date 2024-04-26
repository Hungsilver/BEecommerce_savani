package com.example.wedecomerce.dto.buy_product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VariationReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

}

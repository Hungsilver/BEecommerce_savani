package com.example.wedecomerce.dto.buy_product;

import com.example.wedecomerce.domain.VariationOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TierVariationsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private List<?> options;

//    private String image;

}

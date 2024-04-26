package com.example.wedecomerce.dto.home_page;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.Product;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class CategoriesHomeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String thumbnail;

    private Integer status;

    private String description;

    private List<?> products; // ds spham featured

    private List<?> categoriesChildren;
}

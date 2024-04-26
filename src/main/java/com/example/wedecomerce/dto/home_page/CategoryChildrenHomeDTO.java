package com.example.wedecomerce.dto.home_page;

import com.example.wedecomerce.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryChildrenHomeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String thumbnail;

    private String description;

    private Integer status;

    private Long categoryParent;
}

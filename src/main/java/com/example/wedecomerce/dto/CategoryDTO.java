package com.example.wedecomerce.dto;

import com.example.wedecomerce.domain.Category;
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
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String thumbnail;

    private String description;

    private String status;

    private Category categoryChild;


    private String image;

    private Instant createdDate;

    private Instant lastModifiedDate;
}

package com.example.wedecomerce.dto.buy_product;

import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.VariationOption;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String sku;

    private String name; //name attribute

    private String image;

    private Double price;

    private Integer sold; // số lượng đã bán

    private Integer quantity;

    private Boolean featured; // có là sản phẩm nổi bật hay không

    private Long productId;

    private Integer status = 1;

}

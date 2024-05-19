package com.example.wedecomerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity

@Getter
@Setter
@Builder
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "cart_detail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
//    @JsonIgnoreProperties(value = {"product","variationOptions"})
    @JoinColumn(name = "product_detail_id",referencedColumnName = "id")
    private ProductDetail productDetail;

    @Column(name = "quantity")
    private Integer quantity;


    @CreatedDate
    @Column(name = "create_date")
    private Instant createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private Instant updateDate;

    @Override
    public String toString() {
        return "CartDetail{" +
                "id=" + id +
                ", productDetail=" + productDetail +
                ", quantity=" + quantity +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

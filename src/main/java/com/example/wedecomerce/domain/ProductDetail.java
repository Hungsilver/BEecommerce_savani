package com.example.wedecomerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product_detail")
public class ProductDetail extends AbstractEntity<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sku", length = 30, nullable = false)
    private String sku;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "image", length = 100, nullable = false)
    private String image;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "sold")
    private Integer sold; // số lượng đã bán

    @Column(name = "featured")
    private Boolean featured; // có là sản phẩm nổi bật hay không

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "status")
    private Integer status = 1;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "productDe_variantOp",
            joinColumns = @JoinColumn(name = "product_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "variant_option_id")
    )
    @JsonIgnoreProperties(value = {"product", "variationOption"}, allowSetters = true)
    Set<VariationOption> variationOptions = new HashSet<>();

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate = Instant.now();

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", sold=" + sold +
                ", featured=" + featured +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDetail)) {
            return false;
        }
        return id != null && id.equals(((ProductDetail) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}

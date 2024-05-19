package com.example.wedecomerce.domain;

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

import java.math.BigDecimal;
import java.time.Instant;

@Entity

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private Boolean type;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "min_spend")
    private BigDecimal minSpend;

    @Column(name = "max_spend")
    private BigDecimal maxSpend;

    @Column(name = "quantity_used")
    private Integer quantityUsed;

    @Column(name = "start_date")
    private java.sql.Timestamp startDate;

    @Column(name = "end_date")
    private java.sql.Timestamp endDate;

    @Column(name = "status")
    private Integer status;

    @CreatedDate
    @Column(name = "create_date")
    private Instant createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private Instant updateDate;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", minSpend=" + minSpend +
                ", maxSpend=" + maxSpend +
                ", quantityUsed=" + quantityUsed +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

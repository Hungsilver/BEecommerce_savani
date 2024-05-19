package com.example.wedecomerce.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "ward", length = 100)
    private String ward;

    @Column(name = "district", length = 100)
    private String district;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "zipcode", length = 20)
    private Integer zipcode;

    @Column(name = "status")
    private Integer status = 0;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", ward='" + ward + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", zipcode=" + zipcode +
                ", status=" + status +
                '}';
    }
}

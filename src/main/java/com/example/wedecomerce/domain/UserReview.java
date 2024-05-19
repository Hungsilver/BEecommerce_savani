package com.example.wedecomerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
@Table(name = "user_review")
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @CreatedDate
    @Column(name = "create_date")
    private Instant createDate;

    @Override
    public String toString() {
        return "UserReview{" +
                "id=" + id +
                ", user=" + user +
                ", orderDetail=" + orderDetail +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

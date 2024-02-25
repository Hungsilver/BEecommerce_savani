package com.example.wedecomerce;

import com.example.wedecomerce.domain.Authority;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.Promotion;
import com.example.wedecomerce.domain.User;
import com.example.wedecomerce.repository.AuthorityRepository;
import com.example.wedecomerce.repository.ProductDetailRepository;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.repository.PromotionRepository;
import com.example.wedecomerce.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@SpringBootApplication
public class WedEcomerceApplication {

    //    private final Environment evn;
//
//    public WedEcomerceApplication(Environment evn) {
//        this.evn = evn;
//    }
//
    @Autowired
    public ProductDetailRepository productDetailRepository;

    @Autowired
    public PromotionRepository promotionRepository;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initApplication() {
//        userRepository.save(User.builder()
//                                    .email("hungsilver@gmail.com")
//                                    .password(passwordEncoder.encode("1234"))
//                                    .build());

//            productRepository.save(
//                    Product.builder()
//                            .code("HG029")
//                            .name("Duy chẩm chéo")
//                            .description("Duy is gay")
//                            .build()
//            );
//        promotionRepository.save(
//                Promotion.builder()
//                        .code("1122")
//                        .name("Tết22")
//                        .maxSpend(BigDecimal.valueOf(1000000))
//                        .minSpend(BigDecimal.valueOf(100000))
//                        .type(false)
//                        .value(BigDecimal.valueOf(10))
//                        .status(1)
//                        .build()
//        );
    }

    public static void main(String[] args) {
        SpringApplication.run(WedEcomerceApplication.class, args);

    }

}

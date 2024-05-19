package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.controller.vm.LoginVM;
import com.example.wedecomerce.security.SecurityUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
@Tag(name = "Authentication")
public class AuthenticateController {

    public final JwtEncoder jwtEncoder;

    @Value("${spring.security.authentication.jwt.token-validity-in-seconds:0}")
    private long tokenValidityInSeconds;

    @Value("${spring.security.authentication.jwt.token-validity-in-seconds-for-remember-me:0}")
    private long tokenValidityInSecondsForRememberMe;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthenticateController(JwtEncoder jwtEncoder, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.jwtEncoder = jwtEncoder;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginVM loginVM) {
        log.info("Authent"+ loginVM);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginVM.getLogin(),
                loginVM.getPassword()
        );
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken); //kiểm tra xác thực trùng với dữ liệu trên server
        SecurityContextHolder.getContext().setAuthentication(authentication); //lưu vào SecurityContextHolder để quản lí account xác thực thành công
        String jwt = createToken(authentication, loginVM.isRememberMe());
        System.out.println("accessToken:  " + jwt);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(jwt);
        return new ResponseEntity<>(new JWTToken(
                jwt,
                authentication.getName(),
                getInstantByIsRememberMe(loginVM.isRememberMe()),
                authentication.getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.toSet())
        ), httpHeaders, HttpStatus.OK);
    }


    // kiểm tra lại sau
    @Operation(summary = "Check người dùng đã login chưa")
    @GetMapping("/authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    private String createToken(Authentication authentication, boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));

        Instant now = Instant.now();
        Instant validity = getInstantByIsRememberMe(rememberMe);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(validity)
                .subject(authentication.getName())
                .claim(SecurityUtils.AUTHORITIES_KEY, authorities)
                .build();
        JwsHeader jwsHeader = JwsHeader.with(SecurityUtils.JWT_ALGORITHM).build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
    }

    private Instant getInstantByIsRememberMe(boolean isRememberMe) {
        Instant now = Instant.now();
        if (isRememberMe) {
            return now.plus(this.tokenValidityInSecondsForRememberMe, ChronoUnit.SECONDS);
        }
        return now.plus(this.tokenValidityInSeconds, ChronoUnit.SECONDS);
    }


    static class JWTToken {
        private String accessToken;
        private String fullName;
        private Instant expiration;
        private Set<String> roles;

        public JWTToken(String accessToken, String fullName, Instant expiration, Set<String> roles) {
            this.accessToken = accessToken;
            this.fullName = fullName;
            this.expiration = expiration;
            this.roles = roles;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Instant getExpiration() {
            return expiration;
        }

        public void setExpiration(Instant expiration) {
            this.expiration = expiration;
        }

        public Set<String> getRoles() {
            return roles;
        }

        public void setRoles(Set<String> roles) {
            this.roles = roles;
        }
    }

}

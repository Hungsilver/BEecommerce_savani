package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.domain.Authority;
import com.example.wedecomerce.repository.AuthorityRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/api/authority")
@Tag(name = "Authority")
public class AuthorityRestController {
    private final AuthorityRepository authorityRepository;

    @GetMapping("")
    public ResponseEntity<List<Authority>> getAllAuthorities() {
        Pageable pageable1 = PageRequest.of(0, 10);
        Page<Authority> page = authorityRepository.findAll(pageable1);
        return ResponseEntity.ok().body(page.getContent());
    }

    @PostMapping("")
    public ResponseEntity<Authority> addAuthority(@RequestBody Authority authority) {
        return ResponseEntity.ok().body(authorityRepository.save(authority));
    }
}

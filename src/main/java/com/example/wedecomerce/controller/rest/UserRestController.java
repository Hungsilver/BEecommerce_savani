package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.domain.User;
import com.example.wedecomerce.repository.UserRepository;
import com.example.wedecomerce.service.IUserService;
import com.example.wedecomerce.service.MailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
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

import javax.naming.NameNotFoundException;
import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "User")
public class UserRestController {

    private final UserRepository userRepository;
    private final IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        Pageable pageable1 = PageRequest.of(0, 10);
        Page<User> page = userRepository.findAll(pageable1);
        return ResponseEntity.ok().body(page.getContent());
    }


    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
    }




}

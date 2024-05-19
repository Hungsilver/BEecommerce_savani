package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.config.Constants;
import com.example.wedecomerce.controller.vm.ManagedUserVM;
import com.example.wedecomerce.domain.Authority;
import com.example.wedecomerce.domain.Cart;
import com.example.wedecomerce.domain.User;
import com.example.wedecomerce.repository.AuthorityRepository;
import com.example.wedecomerce.repository.CartRepository;
import com.example.wedecomerce.repository.UserRepository;
import com.example.wedecomerce.security.AuthoritiesConstants;
import com.example.wedecomerce.security.SecurityUtils;
import com.example.wedecomerce.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final CartRepository cartRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User registerUser(ManagedUserVM userVM) {
        Cart cart = Cart.builder()
                .createDate(Instant.now())
                .updateDate(Instant.now())
                .build();
        User user = User.builder()
                .id(null)
                .login(userVM.getLogin())
                .password(passwordEncoder.encode(userVM.getPassword()))
                .email(userVM.getEmail())
                .firstName(userVM.getFirstName())
                .middleName(userVM.getMiddleName())
                .lastName(userVM.getLastName())
                .activated(true)
                .cart(cart)// tao gio hang khi dang ki
//                .createdBy(AuthoritiesConstants.ANONYMOUS)
//                .lastModifiedBy(AuthoritiesConstants.ANONYMOUS)
                .createdDate(Instant.now())
                .lastModifiedDate(Instant.now())
                .authorities(authorityRepository.findById(AuthoritiesConstants.ANONYMOUS).stream().collect(Collectors.toSet()))
                .build();
        return userRepository.save(user);
    }

    @Override
    public User activatedUser(String email) {
        return null;
    }

    @Override
    public User getUserCurrentLogin() {
//        String username = SecurityUtils.getCurrentAuthority().orElse(null);
//        if (username == null) {
//            return null;
//        }
        String username = "hungcustomer"; //demo
        return userRepository.findByLogin(username).orElse(null);
    }

    @Override
    public User createUser(ManagedUserVM userVM) {
        return null;
    }

    @Override
    public User updateUser(ManagedUserVM userVM, Long idUser) {
        return null;
    }

    @Override
    public void deleteUser(String login) {

    }
}

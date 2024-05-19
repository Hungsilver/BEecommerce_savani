package com.example.wedecomerce.service;

import com.example.wedecomerce.controller.vm.ManagedUserVM;
import com.example.wedecomerce.domain.User;
import com.example.wedecomerce.dto.AdminUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> getUsers(Pageable pageable);

    User registerUser(ManagedUserVM userVM);

    User activatedUser(String email);

    User getUserCurrentLogin();

    User createUser(ManagedUserVM userVM);

    User updateUser(ManagedUserVM userVM, Long idUser);

    void deleteUser(String login);
}

package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.controller.rest.errors.InvalidPasswordException;
import com.example.wedecomerce.controller.vm.ManagedUserVM;
import com.example.wedecomerce.domain.User;
import com.example.wedecomerce.repository.UserRepository;
import com.example.wedecomerce.service.IUserService;
import com.example.wedecomerce.service.MailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.server.Cookie;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.Instant;

@RestController
@RequestMapping("/api")
@Tag(name = "Account")
@SessionAttributes({"otp", "account"})
@RequiredArgsConstructor
public class AccountRestController {

    private final UserRepository userRepository;

    private final IUserService userService;

    private final MailService mailService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    private void registerAccount(@Valid @RequestBody ManagedUserVM managedUserVM, HttpSession session) {
        if (isPasswordLengthInvalid(managedUserVM.getPassword())) {
            throw new InvalidPasswordException();
        }
        String otp = mailService.sendOTP(managedUserVM.getEmail());
        session.setAttribute("otp", otp);
        session.setAttribute("account", managedUserVM);
        //time life 1p
        session.setMaxInactiveInterval(60);
    }

    @GetMapping("/verify-otp")
    private ResponseEntity<?> verifyAccount(@RequestParam String otp, HttpSession otpSession) {
        Object otpCodeSession = otpSession.getAttribute("otp");
        Object userSession = otpSession.getAttribute("account");
        if (otpCodeSession == null) {
            return ResponseEntity.badRequest().body("het time hoac trong");
        }
        if (userSession == null) {
            return ResponseEntity.badRequest().body("account null");
        }
        if (!otp.equals(otpCodeSession)) {
            return ResponseEntity.badRequest().body("otp sai ");
        }
        User userSaved = userService.registerUser((ManagedUserVM) userSession);
        if (userSaved == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("khong thanh cong");
        }
        otpSession.removeAttribute("otp");
        otpSession.removeAttribute("account");
        return ResponseEntity.status(HttpStatus.OK).body(userSaved);
    }


    private static boolean isPasswordLengthInvalid(String password) {
        return (
                StringUtils.isEmpty(password) ||
                        password.length() < ManagedUserVM.PASSWORD_MIN_LENGTH ||
                        password.length() > ManagedUserVM.PASSWORD_MAX_LENGTH
        );
    }

    static class OTP {
        private String otpCode;
        private Instant expiredCode;

        public OTP(String otpCode, Instant expiredCode) {
            this.otpCode = otpCode;
            this.expiredCode = expiredCode;
        }

        public OTP() {
        }

        public String getOtpCode() {
            return otpCode;
        }

        public void setOtpCode(String otpCode) {
            this.otpCode = otpCode;
        }

        public Instant getExpiredCode() {
            return expiredCode;
        }

        public void setExpiredCode(Instant expiredCode) {
            this.expiredCode = expiredCode;
        }
    }

}

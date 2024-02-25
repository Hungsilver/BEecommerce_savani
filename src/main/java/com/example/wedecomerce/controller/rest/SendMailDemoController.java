package com.example.wedecomerce.controller.rest;

import com.example.wedecomerce.service.MailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "sendMail")
public class SendMailDemoController {

    private final MailService mailService;

    @PostMapping("/sendMail")
    @PermitAll
    public String sendMail(@RequestBody MailBody mailBody) {
        mailService.sendEmail(mailBody.to, mailBody.subject, mailBody.content, mailBody.isMultipart, mailBody.isHtml);
        return "da send mail";
    }

    static class MailBody {
        private String to;
        private String subject;
        private String content;
        private boolean isHtml = false;
        private boolean isMultipart = false;

        public MailBody() {
        }

        public MailBody(String to, String subject, String content, boolean isHtml, boolean isMultipart) {
            this.to = to;
            this.subject = subject;
            this.content = content;
            this.isHtml = isHtml;
            this.isMultipart = isMultipart;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isHtml() {
            return isHtml;
        }

        public void setHtml(boolean html) {
            isHtml = html;
        }

        public boolean isMultipart() {
            return isMultipart;
        }

        public void setMultipart(boolean multipart) {
            isMultipart = multipart;
        }
    }
}

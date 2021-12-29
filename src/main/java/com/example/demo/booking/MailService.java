package com.example.demo.booking;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Service("api/v1/mail")
public class MailService {

    @PostMapping
    public Mail saveMail(Mail mail){ //funktioniert auch als list
        return mail;
    }
}

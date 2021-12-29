package com.example.demo.booking;

import com.example.demo.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mail")
@AllArgsConstructor
public class MailController {



    @PostMapping
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public void newMail(@RequestBody Mail Mail) {
        System.out.println("registerNewEmployee");
        Mail.sendMail();
        System.out.println(Mail);
    }
}

package com.example.basicregistration.login;

import com.example.basicregistration.registration.RegistrationForm;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping
    public List<RegistrationForm> loadPage()
    {
        return loginService.getPage();
    }

    @PostMapping
    public ResponseEntity<String> sendLogin(@RequestBody LoginForm loginForm)
    {
        return loginService.sendData(loginForm);
    }
}

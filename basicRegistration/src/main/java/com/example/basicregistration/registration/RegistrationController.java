package com.example.basicregistration.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="registration/")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService)
    {
        this.registrationService = registrationService;
    }

    @PostMapping
    public void registerUser(@RequestBody RegistrationForm registrationForm)
    {
        registrationService.uploadRegistration(registrationForm);
    }

}

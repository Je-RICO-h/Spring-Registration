package com.example.basicregistration.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository)
    {
        this.registrationRepository = registrationRepository;
    }

    public void uploadRegistration(RegistrationForm registrationForm)
    {
        Optional<RegistrationForm> isregistered = registrationRepository.findByEmail(registrationForm.getEmail());

        if(isregistered.isPresent())
            throw new IllegalStateException("This Email is already Registered!");

        registrationRepository.save(registrationForm);
    }

}

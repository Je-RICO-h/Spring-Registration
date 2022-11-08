package com.example.basicregistration.login;

import com.example.basicregistration.registration.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.util.Lazy.of;

@Service
public class LoginService {
    private final DataRepository dataRepository;

    @Autowired
    public LoginService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public /*ModelAndView*/ List<RegistrationForm> getPage()
    {
       /* ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;*/
        return this.dataRepository.findAll();
    }

    public ResponseEntity<String> sendData(LoginForm loginForm){

        Optional<RegistrationForm> emailexists = dataRepository.findByEmail(loginForm.getEmail());

        if(emailexists.isEmpty())
            throw new IllegalStateException("User not exists");

        Optional<RegistrationForm> passwordFromDB = dataRepository.dataMatch(loginForm.getEmail(),loginForm.getPassword());

        if(passwordFromDB.isPresent())
            return new ResponseEntity<>("Successfull login", HttpStatus.OK);
        else
            throw new IllegalStateException("Credentials doesnt match");

    }


}

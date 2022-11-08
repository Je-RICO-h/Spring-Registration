package com.example.basicregistration.login;
import com.example.basicregistration.registration.RegistrationForm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataRepository extends JpaRepository<RegistrationForm, Long> {
    @Query("SELECT s FROM RegistrationForm s WHERE s.email = ?1")
    Optional<RegistrationForm> findByEmail(String email);

    @Query("SELECT s FROM RegistrationForm s WHERE s.email = ?1 AND s.password = ?2")
    Optional<RegistrationForm> dataMatch(String email, String password);
}

package com.example.basicregistration.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationForm, Long> {
    @Query("SELECT s FROM RegistrationForm s WHERE s.email = ?1")
    Optional<RegistrationForm> findByEmail(String email);
}

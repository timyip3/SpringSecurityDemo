package com.example.repository;

import com.example.entity.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, String> {
    Optional<Attempts> findByUsername(String username);
}

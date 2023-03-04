package com.exercise.security.token.repository;

import com.exercise.security.token.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface TokenRepository extends JpaRepository<Token, String> {

}

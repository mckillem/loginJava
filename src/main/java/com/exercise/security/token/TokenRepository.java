package com.exercise.security.token;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface TokenRepository extends JpaRepository<Token, String> {

}

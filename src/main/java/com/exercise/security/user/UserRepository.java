package com.exercise.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserAppPk> {
	Optional<User> findByUserAppPk(String email, String app);
}

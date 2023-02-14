package com.exercise.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UserAppPk> {
//	Optional<User> findByUserAppPk(String email, String app);
	Optional<User> findByUserAppPkEmail(String email);
}

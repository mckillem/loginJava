package com.exercise.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UserAppPk> {
	Optional<User> findByUserAppPkEmail(String email);
	Collection<User> findByUserAppPkApp(String app);

	Collection<User> findAllByUserAppPkApp(String app);
}

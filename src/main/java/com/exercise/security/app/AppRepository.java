package com.exercise.security.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRepository extends JpaRepository<App, String> {
	Optional<App> findAppByAppName(String name);
}

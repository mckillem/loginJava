package com.exercise.security.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppRepositoryTest {

	@Autowired
	private AppRepository appRepository;

	@BeforeEach
	void setUp() {
	}

	@Test
	void findAppByAppName() {
		// given
		String appName = "TODO";
//		TODO: how to test

		// when
		Optional<App> app = appRepository.findAppByAppName(appName);

		// then
//		assertThat(app).isEqualTo(appName);
	}
}
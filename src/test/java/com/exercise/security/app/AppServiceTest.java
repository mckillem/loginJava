package com.exercise.security.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@DataJpaTest
class AppServiceTest {

	@Autowired
	private AppRepository appRepository;
	private AppService appService;

	@BeforeEach
	void setUp() {
	}

	@Test
	void getApp() {
	}

	@Test
	void isAppExisting() {

	}

	@Test
	void createNewApp() {
	}

	@Test
	void updateApp() {
	}

//	@Test
//	void deleteApp() {
//		// given
//		String app = "TODO";
//		given(appRepository.ex(id))
//				.willReturn(true);
//		// when
//		appService.deleteApp(app);
//
//		// then
//		verify(appRepository).deleteById(id);
//	}

	@Test
	void changeAppName() {
	}

	@Test
	void getAllApps() {
		// when
		appService.getAllApps();
		// then
		verify(appRepository).findAll();
	}
}
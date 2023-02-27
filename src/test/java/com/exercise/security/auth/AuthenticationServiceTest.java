package com.exercise.security.auth;

import com.exercise.security.user.User;
import com.exercise.security.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

	@Mock
	private UserRepository userRepository;
	private AuthenticationService authenticationService;

	@BeforeEach
	void setUp() {
	}

	@Test
	void canRegister() {
		//		given
		//		when
		//		then
	}

	@Test
	void willThrowApplicationDoesNotExistWhenRegisterIsNotSuccessful() {
		//		given
		//		when
		//		then
	}

	@Test
	void willThrowApplicationHasAlreadyBeenRegisteredWhenRegisterIsNotSuccessful() {
		//		given
		//		when
		//		then
	}

//	@Test
//	void canAuthenticate() {
//		//		given
//		AuthenticationRequest request = {
//				"email": "email@email.com",
//				"app": "TODO",
//				"password": "heslo"
//		}
//		//		when
//		authenticationService.authenticate();
//		//		then
//	}

//	@Test
//	void willThrowAnErrorWhenAuthenticateIsNotSuccessful() {
//		//		given
//		AuthenticationRequest request = new AuthenticationRequest(
//				"email": "email@email.com",
//				"app": "TODO",
//				"password": "heslo"¨
//		)
//
//
//		//		when
//		authenticationService.authenticate(request);
//		//		then
//	}
}
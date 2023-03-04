package com.exercise.security.auth;

import com.exercise.security.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	private final TokenService tokenService;

	@CrossOrigin("*")
	@PostMapping("/register")
	public AuthenticationResponse register(
			@RequestBody RegisterRequest request
	) {
		return service.register(request);
	}

//	todo: How to exclude an admin of need to log in to an application?
	@CrossOrigin("*")
	@PostMapping("/authenticate")
	public AuthenticationResponse authenticate(
			@RequestBody AuthenticationRequest request
	) {
		return service.authenticate(request);
	}

	@CrossOrigin("*")
	@PostMapping("/logout")
	public void logout(@RequestBody String token) {
		tokenService.logout(token);
	}
}

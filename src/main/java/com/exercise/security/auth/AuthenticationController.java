package com.exercise.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

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
}

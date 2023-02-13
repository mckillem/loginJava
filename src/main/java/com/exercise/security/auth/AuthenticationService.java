package com.exercise.security.auth;

import com.exercise.security.config.JwtService;
import com.exercise.security.user.Role;
import com.exercise.security.user.User;
import com.exercise.security.user.UserAppPk;
import com.exercise.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {

		// TODO if App does not exist in database than return exception
		if (!request.getApp() exist in table._app)
		{
			throw new RuntimeException(String.format("Application %s does not exist.", request.getApp()));
		}

		// TODO exist this user with this app?

		var user = User.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.userAppPk(new UserAppPk(request.getEmail(), request.getApp()))
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
				)
		);

		// TODO start refactoring maybe
		Optional<User> foundUser = repository.findByUserAppPk(request.getEmail(), request.getApp());

		if (foundUser.isEmpty()) {
			throw new RuntimeException(String.format("%s", request.getEmail()));
		}
		// TODO end refactoring

		var user = repository.findByUserAppPk(request.getEmail(), request.getApp()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
}

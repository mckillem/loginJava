package com.exercise.security.auth;

import com.exercise.security.app.AppService;
import com.exercise.security.config.JwtService;
import com.exercise.security.token.TokenService;
import com.exercise.security.user.Role;
import com.exercise.security.user.User;
import com.exercise.security.user.UserAppPk;
import com.exercise.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	private final AppService appService;

	public AuthenticationResponse register(RegisterRequest request) {

		if (!appService.isAppExisting(request.getApp()))
		{
			throw new RuntimeException(String.format("The application %s does not exist.", request.getApp()));
		}

		if (!repository.findByUserAppPkApp(request.getApp()).isEmpty() && repository.findByUserAppPkEmail(request.getEmail()).isPresent())
		{
			throw new RuntimeException(String.format("The user %s is already registered to the application %s.", request.getEmail(), request.getApp()));
		}

		var user = User.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.userAppPk(new UserAppPk(request.getEmail(), request.getApp()))
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		tokenService.saveToken(jwtToken);

		return AuthenticationResponse.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getUserAppPk().getEmail())
				.token(jwtToken)
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
//						todo: cannot add
//						request.getApp(),
						request.getPassword()
				)
		);

		// TODO start refactoring maybe
//		Optional<User> foundUser = repository.findByUserAppPk(request.getEmail(), request.getApp());
//
//		if (foundUser.isEmpty()) {
//			throw new RuntimeException(String.format("%s", request.getEmail()));
//		}
		// TODO end refactoring

		var user = repository.findByUserAppPkEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		tokenService.saveToken(jwtToken);

		return AuthenticationResponse.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getUserAppPk().getEmail())
				.token(jwtToken)
				.build();
	}
}

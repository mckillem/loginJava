package com.exercise.security.user;

import com.exercise.security.app.AppService;
import com.exercise.security.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final TokenService tokenService;
	private AppService appService;

	public Collection<UserResponse> getAll(UserRequest userRequest) {

		if (!tokenService.isTokenExisting(userRequest.getToken())) {
			throw new RuntimeException("Token does not exist.");
		}

		if (!appService.isAppExisting(userRequest.getApp())) {
			throw new RuntimeException("App does not exist.");
		}

		Collection<User> users = userRepository.findAllByUserAppPkApp(userRequest.getApp());

		return users.stream()
				.map(u -> UserResponse.builder()
						.firstName(u.getFirstName())
						.lastName(u.getLastName())
						.email(u.getUserAppPk().getEmail())
						.build())
				.collect(Collectors.toList());
	}
}

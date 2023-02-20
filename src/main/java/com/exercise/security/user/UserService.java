package com.exercise.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public Collection<User> findAllUsersWithApp(String app) {
		return userRepository.findByUserAppPkApp(app);
	}
}

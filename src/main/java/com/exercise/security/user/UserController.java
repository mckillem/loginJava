package com.exercise.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
	private final UserService userService;

	@GetMapping("/list")
	public Collection<UserResponse> getUsers(@RequestBody UserRequest userRequest) {
		return userService.getAll(userRequest);
	}

}

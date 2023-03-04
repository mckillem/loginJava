package com.exercise.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
	private final UserService userService;

	@CrossOrigin("*")
	@PostMapping("/list")
	public UserResponse getUsers(@RequestBody UserRequest userRequest) {
		return userService.getAll(userRequest);
	}

}

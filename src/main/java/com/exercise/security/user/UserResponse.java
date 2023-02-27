package com.exercise.security.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
	private String firstName;
	private String lastName;
	private String email;
}

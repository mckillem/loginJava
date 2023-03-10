package com.exercise.security.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
	private Collection<UserOfApp> users;
}

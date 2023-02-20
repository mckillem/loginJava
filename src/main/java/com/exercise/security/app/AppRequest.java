package com.exercise.security.app;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class AppRequest {
	private String appName;
	private String description;
}

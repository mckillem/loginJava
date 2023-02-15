package com.exercise.security.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/app")
@RequiredArgsConstructor
public class AppController {

	private final AppService service;

	@GetMapping
	public App getApp(String app) {
		return service.getApp(app);
	}

	@PostMapping("/newApp")
	@ResponseStatus(HttpStatus.OK)
	public void createNewApp(@RequestBody AppRequest app) {
		service.createNewApp(app);
	}

	@PostMapping("/updateApp")
	@ResponseStatus(HttpStatus.OK)
	public void updateApp(@RequestBody AppRequest app) {
		service.updateApp(app);
	}

	@PostMapping("/deleteApp")
	@ResponseStatus(HttpStatus.OK)
	public void deleteApp(@RequestBody AppRequest app) {
		service.deleteApp(app);
	}
}

package com.exercise.security.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
// todo: How to secure it? An admin logs as an admin and the program recognises that it is an admin
//  and then he can add applications and users. But how?
//  Will he has a special page with users and applications which he can check or uncheck depending on what?
// todo in auth.http
@RequestMapping("/api/v1/app")
@RequiredArgsConstructor
public class AppController {

	private final AppService appService;

//	TODO: todo in an app.http
	@GetMapping("/list")
	public Collection<App> getAllApps() {
		return appService.getAllApps();
	}

//	todo: why it returns 403. Is it missing AppResponse? Is it because I need right rights to create a new app?
//	 I presume that only an administrator can manipulate applications so I need to create an administrator first
//	 How to add an app? Admin has to log in to add an app? How? Create a frontend
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createNewApp(@RequestBody AppRequest app) {
		appService.createNewApp(app);
	}

	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateApp(@RequestBody AppRequest app) {
		appService.updateApp(app);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteApp(@RequestBody AppRequest app) {
		appService.deleteApp(app);
	}
}

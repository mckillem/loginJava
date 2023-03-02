package com.exercise.security.app;

import com.exercise.security.user.User;
import com.exercise.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppService {

    private final AppRepository appRepository;

    private final UserRepository userRepository;

	public App getApp(String app) {
        return appRepository.findAppByAppName(app).orElse(null);
    }

    public boolean isAppExisting(String app) {
        return appRepository.findAppByAppName(app).isPresent();
    }

    public void createNewApp(AppRequest app) {
        if (appRepository.findAppByAppName(app.getAppName()).isPresent()) {
            throw new RuntimeException(String.format("This application '%s' already exists.", app.getAppName()));
        }
        appRepository.saveAndFlush(App.builder()
                        .appName(app.getAppName())
                        .description(app.getDescription())
                        .build());
    }

    public void updateApp(AppRequest appRequest) {
        App appExists = this.getApp(appRequest.getAppName());

        if (appExists == null) {
            throw new RuntimeException(String.format("This application '%s' does not exist.", appRequest.getAppName()));
        }

        appRepository.saveAndFlush(appExists.toBuilder()
                        .description(appRequest.getDescription())
                        .build());
    }

    public void deleteApp(AppRequest app) {
        App appExists = this.getApp(app.getAppName());

        if (appExists == null) {
            throw new RuntimeException(String.format("This application '%s' does not exist.", app));
        }

        Collection<User> users = findAllUsersWithApp(app.getAppName());

        if (!users.isEmpty()) {
            throw new RuntimeException(String.format("This application '%s' cannot be deleted because it contains users.", app));
        }

        appRepository.deleteAllInBatch(Collections.singletonList(appExists));
        appRepository.flush();
    }

    // todo Should it be changeAppDescription?
    public void changeAppName() {

    }

    public Collection<App> getAllApps() {
        return appRepository.findAll();
    }

    private Collection<User> findAllUsersWithApp(String app) {
        return userRepository.findByUserAppPkApp(app);
    }
}

package com.exercise.security.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppService {

    public void getApp() {

    }

    public boolean isExistApp(String app) {
        return false;
    }

    public void createdNewApp(String app) {

    }

    public void updateApp() {

    }

    public void deletedApp() {
        // TODO if app is assign to user, so return exception
    }

    public void changeAppName() {

    }

}

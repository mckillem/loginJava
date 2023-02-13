package com.exercise.security.user;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserAppPk implements Serializable {

    private String email;

    private String app;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserAppPk that = (UserAppPk) o;
        return email.equals(that.email) &&
                app.equals(that.app);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, app);
    }
}

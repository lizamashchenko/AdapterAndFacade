package Adapter;

import Users.FacebookUser;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class FacebookUserAdapter implements UnifiedUser{
    private FacebookUser user;

    @Override
    public String getEmail() {
        if(user != null) {
            return user.getEmail();
        }
        return null;
    }

    @Override
    public String getCountry() {
        if(user != null) {
            return user.getUserCountry();
        }
        return null;
    }

    @Override
    public LocalDateTime getLastActiveTime() {
        if(user != null) {
            return user.getUserActiveTime();
        }
        return null;
    }
}

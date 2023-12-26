package Adapter;

import Users.FacebookUser;
import Users.TwitterUser;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class TwitterUserAdapter implements UnifiedUser{
    private TwitterUser user;

    @Override
    public String getEmail() {
        if(user != null) {
            return user.getUserMail();
        }
        return null;
    }

    @Override
    public String getCountry() {
        if(user != null) {
            return user.getCountry();
        }
        return null;
    }

    @Override
    public LocalDateTime getLastActiveTime() {
        if(user != null) {
            return user.getLastActiveTime();
        }
        return null;
    }
}

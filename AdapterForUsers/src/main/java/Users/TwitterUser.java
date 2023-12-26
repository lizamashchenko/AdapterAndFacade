package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

// TwitterUser (getUserMail, getCountry, getLastActiveTime)
@AllArgsConstructor @Getter
public class TwitterUser {
    private String userMail;
    private String country;
    private LocalDateTime lastActiveTime;
}

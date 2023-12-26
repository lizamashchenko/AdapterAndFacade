package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

// FacebookUser (getEmail, getUserCountry, getUserActiveTime)

@AllArgsConstructor @Getter
public class FacebookUser {
    private String email;
    private String userCountry;
    private LocalDateTime userActiveTime;
}

import java.time.LocalDateTime;

import Adapter.*;
import Users.*;
import Authentification.*;

public class Main {

    public static void main(String[] args) {
        TwitterUser twitterUser = new TwitterUser("twitter@example.com", "USA", LocalDateTime.now().minusMinutes(30));
        FacebookUser facebookUser = new FacebookUser("facebook@example.com", "Ukraine", LocalDateTime.now().minusHours(2));

        UnifiedUser twitterUserAdapter = new TwitterUserAdapter(twitterUser);
        UnifiedUser facebookUserAdapter = new FacebookUserAdapter(facebookUser);

        MessageSender messageSender = new MessageSender();

        messageSender.send("twitter message", twitterUserAdapter, "USA");
        messageSender.send("facebook message", facebookUserAdapter, "Ukraine");
    }
}

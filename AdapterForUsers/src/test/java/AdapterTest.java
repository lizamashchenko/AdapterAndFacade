import Users.*;
import Adapter.*;
import Authentification.*;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class AdapterTest {

    @Test
    public void testTwitterUserMessageSent() {
        TwitterUser twitterUser = new TwitterUser("twitter@example.com", "USA", LocalDateTime.now().minusMinutes(30));
        UnifiedUser twitterUserAdapter = new TwitterUserAdapter(twitterUser);

        MessageSender messageSender = new MessageSender();
        assertTrue(messageSender.send("Test message", twitterUserAdapter, "USA"));
    }
    @Test
    public void testFacebookUserMessageSent() {
        FacebookUser facebookUser = new FacebookUser("facebook@example.com", "USA", LocalDateTime.now().minusMinutes(30));
        UnifiedUser facebookUserAdapter = new FacebookUserAdapter(facebookUser);

        MessageSender messageSender = new MessageSender();
        assertTrue(messageSender.send("Test message", facebookUserAdapter, "USA"));
    }

    @Test
    public void testFacebookUserMessageNotSentWrongTime() {
        FacebookUser facebookUser = new FacebookUser("facebook@example.com", "Ukraine", LocalDateTime.now().minusHours(2));
        UnifiedUser facebookUserAdapter = new FacebookUserAdapter(facebookUser);

        MessageSender messageSender = new MessageSender();
        assertFalse(messageSender.send("Test message", facebookUserAdapter, "Ukraine"));
    }
    @Test
    public void testTwitterUserMessageNotSentWrongTime() {
        TwitterUser twitterUser = new TwitterUser("twitter@example.com", "Ukraine", LocalDateTime.now().minusHours(2));
        UnifiedUser twitterUserAdapter = new TwitterUserAdapter(twitterUser);

        MessageSender messageSender = new MessageSender();
        assertFalse(messageSender.send("Test message", twitterUserAdapter, "Ukraine"));
    }


    @Test
    public void testTwitterUserMessageNotSentWrongCountry() {
        TwitterUser twitterUser = new TwitterUser("twitter@example.com", "USA", LocalDateTime.now().minusMinutes(30));
        UnifiedUser twitterUserAdapter = new TwitterUserAdapter(twitterUser);

        MessageSender messageSender = new MessageSender();
        assertFalse(messageSender.send("Test message", twitterUserAdapter, "Canada"));
    }
    @Test
    public void testFacebookUserMessageNotSentWrongCountry() {
        FacebookUser facebookUser = new FacebookUser("facebook@example.com", "Ukraine", LocalDateTime.now().minusMinutes(3));
        UnifiedUser facebookUserAdapter = new FacebookUserAdapter(facebookUser);

        MessageSender messageSender = new MessageSender();
        assertFalse(messageSender.send("Test message", facebookUserAdapter, "Canada"));
    }

}

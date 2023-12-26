package Authentification;

import Adapter.*;
import java.time.LocalDateTime;

public class MessageSender {
    public boolean send(String message, UnifiedUser user, String country) {
        if (isFromCountry(user, country) && isActive(user, 1)) {
            System.out.println("Sending message: " + message + " to " + user.getEmail());
            return true;
        }
        System.out.println("Message not sent. User does not meet the criteria.");
        return false;
    }

    private boolean isFromCountry(UnifiedUser user, String country) {
        return user.getCountry().equals(country);
    }

    private boolean isActive(UnifiedUser user, int hours) {
        LocalDateTime lastActiveTime = user.getLastActiveTime();
        LocalDateTime timeBefore = LocalDateTime.now().minusHours(hours);

        return (lastActiveTime != null) && lastActiveTime.isAfter(timeBefore);
    }
}


package Adapter;

import java.time.LocalDateTime;

public interface UnifiedUser {
    String getEmail();
    String getCountry();
    LocalDateTime getLastActiveTime();
}

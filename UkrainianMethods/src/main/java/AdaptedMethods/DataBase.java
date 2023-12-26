package AdaptedMethods;

import UAMethods.БазаДаних;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataBase extends БазаДаних {
    private БазаДаних db;

    public String getUserData() {
        return db.отриматиДаніКористувача();
    }
    public String getStatisticsData() {
        return db.отриматиСтатистичніДані();
    }
}

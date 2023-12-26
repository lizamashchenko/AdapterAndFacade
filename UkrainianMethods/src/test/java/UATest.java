import AdaptedMethods.Authorization;
import AdaptedMethods.DataBase;
import UAMethods.Авторизація;
import UAMethods.БазаДаних;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UATest {

    @Test
    public void testOutputEquality() {
        String oldMainOutput = oldMain();
        String newMainOutput = newMain();

        assertEquals(oldMainOutput, newMainOutput);
    }

    private String oldMain() {
        БазаДаних db = new БазаДаних();
        Авторизація авторизація = new Авторизація();
        if (авторизація.авторизуватися(db)) {
            ReportBuilder br = new ReportBuilder(db);
            return br.getUserData() + "; " +  br.getStatisticsData();
        }
        return "";
    }

    private String newMain() {
        DataBase db = new DataBase(new БазаДаних());

        Authorization authorization = new Authorization(new Авторизація());
        if (authorization.authorize(db)) {
            ReportBuilder br = new ReportBuilder(db);
            return br.getUserData() + "; " +  br.getStatisticsData();
        }
        return "";
    }
}

import AdaptedMethods.DataBase;
import UAMethods.БазаДаних;

public class ReportBuilder {
    private DataBase db;
    // only fot testing
    private БазаДаних dbUA;

    public ReportBuilder(DataBase db) {
        this.db = db;
    }
    public ReportBuilder(БазаДаних db) {
        this.db = new DataBase(db);
        // only for testing
        dbUA = db;
    }
    public String getUserData() {
        return db.getUserData();
    }
    public String getStatisticsData() {
        return db.getStatisticsData();
    }

    // only for testing
    public String getUserDataUA() {
        return dbUA.отриматиДаніКористувача();
    }
    public String getStatisticsDataUA() {
        return dbUA.отриматиСтатистичніДані();
    }
}

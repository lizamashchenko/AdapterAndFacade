    import AdaptedMethods.Authorization;
    import AdaptedMethods.DataBase;
    import UAMethods.Авторизація;
    import UAMethods.БазаДаних;

    public class Main {
        public static void main(String[] args) {
            System.out.println(oldMain());
            System.out.println(newMain());
        }
        private static String oldMain() {
            БазаДаних db = new БазаДаних();
            Авторизація авторизація = new Авторизація();
            if (авторизація.авторизуватися(db)) {
                ReportBuilder br = new ReportBuilder(db);
                return br.getUserData() + "; " +  br.getStatisticsData();
            }
            return "";
        }
        private static String newMain() {
            DataBase db = new DataBase(new БазаДаних());

            Authorization authorization = new Authorization(new Авторизація());
            if (authorization.authorize(db)) {
                ReportBuilder br = new ReportBuilder(db);
                return br.getUserData() + "; " +  br.getStatisticsData();
            }
            return "";
        }
    }

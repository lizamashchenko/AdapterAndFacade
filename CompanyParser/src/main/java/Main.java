public class Main {
    public static void main(String[] args) {
        String url = "https://cms.ucu.edu.ua/?redirect=0";
        CompanyFacade facade = new CompanyFacade(url);
        Company c = facade.getCompanyInfo();
        System.out.println(c);
    }
}

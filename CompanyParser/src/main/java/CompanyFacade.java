import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CompanyFacade {
    private String companyURL;

    public CompanyFacade(String url) {
        this.companyURL = url;
    }

    public Company getCompanyInfo() {
        try {
            Document doc = Jsoup.connect(companyURL).get();

            String companyName = getCompanyName(doc);
            String companyDescription = getCompanyDescription(doc);
            String companyLogoUrl = getCompanyLogoUrl(doc);
            return new Company(companyName, companyDescription, companyLogoUrl);
        } catch (IOException e) {
            System.out.println("Error fetching information: " + e.getMessage());
            return null;
        }
    }

    private String getCompanyName(Document doc) {
        Elements title = doc.select("title");
        return title.text();
    }

    private String getCompanyDescription(Document doc) {
        Elements description = doc.select("meta[name=description]");
        return description.attr("content");
    }

    private String getCompanyLogoUrl(Document doc) {
        String logo = doc.select("link[rel$=icon]").attr("href");
        if (logo.startsWith("/")) { logo = companyURL + logo; }
        return logo;
    }
}

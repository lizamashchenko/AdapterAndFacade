package Extractors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrapingChatGPTExtractor {
    private String companyName;

    public WebScrapingChatGPTExtractor(String companyName) {
        this.companyName = companyName;
    }

    public void getCompanyInfo() {
        System.out.println("Fetching information for " + companyName + "...\n");

        String websiteUrl = "https://www.example.com/" + companyName;

        try {
            Document doc = Jsoup.connect(websiteUrl).get();

            // Extract company name
            String companyName = getCompanyName(doc);

            // Extract company description
            String companyDescription = getCompanyDescription(doc);

            // Extract company logo
            String companyLogoUrl = getCompanyLogoUrl(doc);

            // Display the information
            System.out.println("Company Information:");
            System.out.println("---------------------");
            System.out.println("Name: " + companyName);
            System.out.println("Description: " + companyDescription);
            System.out.println("Logo URL: " + companyLogoUrl);

        } catch (IOException e) {
            System.out.println("Error fetching information: " + e.getMessage());
        }
    }

    private String getCompanyName(Document doc) {
        // Adapt this based on the actual HTML structure of the company name on the website
        Element nameElement = doc.select("h1.company-name").first();
        return nameElement != null ? nameElement.text() : "Not available";
    }

    private String getCompanyDescription(Document doc) {
        // Adapt this based on the actual HTML structure of the company description on the website
        Element descriptionElement = doc.select("div.company-description").first();
        return descriptionElement != null ? descriptionElement.text() : "Not available";
    }

    private String getCompanyLogoUrl(Document doc) {
        // Adapt this based on the actual HTML structure of the company logo on the website
        Element logoElement = doc.select("img.company-logo").first();
        return logoElement != null ? logoElement.absUrl("src") : "Not available";
    }
}

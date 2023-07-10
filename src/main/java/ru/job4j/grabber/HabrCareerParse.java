package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrCareerParse {

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer?page=", SOURCE_LINK);

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 5; i++) {
            Connection connection = Jsoup.connect("%s%s".formatted(PAGE_LINK, i));
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                String date = row.selectFirst(".vacancy-card__date").child(0).attr("datetime");
                String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                try {
                    System.out.printf("%s %s %s%n%s%n", vacancyName, link, date, new HabrCareerParse().retrieveDescription(link));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private String retrieveDescription(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        return doc.select(".vacancy-description__text").first().text();
    }
}
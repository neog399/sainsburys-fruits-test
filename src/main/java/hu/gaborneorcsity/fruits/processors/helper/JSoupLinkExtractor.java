package hu.gaborneorcsity.fruits.processors.helper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JSoupLinkExtractor implements LinkExtractor {
    @Override
    public List<String> extract(String document) {
        Elements fruitLinkElements = Jsoup.parse(document).select("div.productinfo > h3 > a");
        List<String> fruitLinks = new ArrayList<>();
        for (Element fruitLinkElement : fruitLinkElements) {
            fruitLinks.add(fruitLinkElement.attr("href"));
        }

        return fruitLinks;
    }
}

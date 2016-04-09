package hu.gaborneorcsity.fruits.processors.attribute_extractors;

import org.jsoup.Jsoup;

public class JSoupFruitDescriptionExtractor implements FruitDescriptionExtractor {
    @Override
    public String extract(String document) {
        return Jsoup.parse(document).select("div.productText > p").get(0).ownText();
    }
}

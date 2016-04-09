package hu.gaborneorcsity.fruits.processors.attribute_extractors;

import org.jsoup.Jsoup;

public class JSoupFruitTitleExtractor implements FruitTitleExtractor {
    @Override
    public String extract(String document) {
        return Jsoup.parse(document).select("div.productTitleDescriptionContainer > h1").get(0).ownText();
    }
}

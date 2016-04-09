package hu.gaborneorcsity.fruits.processors.attribute_extractors;

import org.jsoup.Jsoup;

/**
 * A simple implementation based on JSoup
 */
public class JSoupFruitTitleExtractor implements FruitTitleExtractor {
    /**
     * {@inheritDoc}
     */
    @Override
    public String extract(String document) {
        return Jsoup.parse(document).select("div.productTitleDescriptionContainer > h1").get(0).ownText();
    }
}

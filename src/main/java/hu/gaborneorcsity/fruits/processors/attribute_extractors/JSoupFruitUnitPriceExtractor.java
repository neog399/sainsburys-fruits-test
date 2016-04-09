package hu.gaborneorcsity.fruits.processors.attribute_extractors;

import org.jsoup.Jsoup;

/**
 * A simple implementation based on JSoup
 */
public class JSoupFruitUnitPriceExtractor implements FruitUnitPriceExtractor {
    /**
     * {@inheritDoc}
     */
    @Override
    public String extract(String document) {
        return Jsoup.parse(document).select("p.pricePerUnit").get(0).ownText().substring(1);
    }
}

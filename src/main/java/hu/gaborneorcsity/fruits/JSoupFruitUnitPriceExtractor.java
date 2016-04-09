package hu.gaborneorcsity.fruits;

import org.jsoup.Jsoup;

public class JSoupFruitUnitPriceExtractor implements FruitUnitPriceExtractor {
    @Override
    public String extract(String document) {
        return Jsoup.parse(document).select("p.pricePerUnit").get(0).ownText().substring(1);
    }
}

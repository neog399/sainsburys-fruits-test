package hu.gaborneorcsity.fruits.processors.attribute_extractors;

/**
 * A service for extracting the fruit's unit price from an HTML document
 */
public interface FruitUnitPriceExtractor {
    /**
     * Extracts the fruit's unit price from the provided HTML document
     * @param document the document from which the unit price will be extracted
     * @return the extracted unit price
     */
    String extract(String document);
}

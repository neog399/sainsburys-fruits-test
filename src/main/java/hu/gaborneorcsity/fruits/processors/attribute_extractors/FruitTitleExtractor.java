package hu.gaborneorcsity.fruits.processors.attribute_extractors;

/**
 * A service for extracting the fruit's title from an HTML document
 */
public interface FruitTitleExtractor {
    /**
     * Extracts the fruit's title from the provided HTML document
     * @param document the document from which the title will be extracted
     * @return the extracted title
     */
    String extract(String document);
}

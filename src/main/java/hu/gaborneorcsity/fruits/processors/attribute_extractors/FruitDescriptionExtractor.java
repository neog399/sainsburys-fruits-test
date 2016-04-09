package hu.gaborneorcsity.fruits.processors.attribute_extractors;

/**
 * A service for extracting the fruit's description from an HTML document
 */
public interface FruitDescriptionExtractor {
    /**
     * Extracts the fruit's description from the provided HTML document
     * @param document the document from which the description will be extracted
     * @return the extracted description
     */
    String extract(String document);
}

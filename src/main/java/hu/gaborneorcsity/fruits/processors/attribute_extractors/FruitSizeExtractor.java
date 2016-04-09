package hu.gaborneorcsity.fruits.processors.attribute_extractors;

/**
 * A service for extracting the size of an HTML document containing a single fruit
 */
public interface FruitSizeExtractor {
    /**
     * Extracts the size of the provided HTML document containing a single fruit
     * @param document the document whose size is extracted
     * @return the extracted size in bytes
     */
    int extract(String document);
}

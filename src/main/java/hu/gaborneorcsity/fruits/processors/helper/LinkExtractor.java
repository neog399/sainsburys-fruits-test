package hu.gaborneorcsity.fruits.processors.helper;

import java.util.List;

/**
 * A service for extracting the links to the HTML documents containing the individual fruits
 */
public interface LinkExtractor {
    /**
     * Extracts the links to the HTML documents containing the indivudal fruits from the provided HTML document
     * @param document the HTML document from which the links are to be extracted
     * @return the extracted links
     */
    List<String> extract(String document);
}

package hu.gaborneorcsity.fruits.processors.helper;

/**
 * A service for retrieving an HTML document
 */
public interface HtmlRetriever {
    /**
     * Retrieves an HTML document located at the given URL
     * @param url the URL of document
     * @return the document
     */
    String retrieve(String url);
}

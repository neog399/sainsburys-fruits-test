package hu.gaborneorcsity.fruits.processors.helper;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.IOException;

/**
 * A simple implementation based on Apache's HttpClient
 */
public class ApacheHtmlRetriever implements HtmlRetriever {
    private HttpClient client;

    public ApacheHtmlRetriever(HttpClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String retrieve(String url) {
        try {
            return new BasicResponseHandler().handleResponse(client.execute(new HttpGet(url)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

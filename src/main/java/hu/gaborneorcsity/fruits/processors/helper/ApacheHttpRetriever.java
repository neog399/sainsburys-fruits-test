package hu.gaborneorcsity.fruits.processors.helper;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ApacheHttpRetriever implements HtmlRetriever {
    private HttpClient client;

    public ApacheHttpRetriever(HttpClient client) {
        this.client = client;
    }

    @Override
    public String retrieve(String url) {
        try {
            return new BasicResponseHandler().handleResponse(client.execute(new HttpGet(url)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

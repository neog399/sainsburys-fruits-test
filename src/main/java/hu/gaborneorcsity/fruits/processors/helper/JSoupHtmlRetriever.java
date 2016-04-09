package hu.gaborneorcsity.fruits.processors.helper;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class JSoupHtmlRetriever implements HtmlRetriever {
    @Override
    public String retrieve(String url) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            String body = new BasicResponseHandler().handleResponse(httpclient.execute(httpGet));

            return body;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

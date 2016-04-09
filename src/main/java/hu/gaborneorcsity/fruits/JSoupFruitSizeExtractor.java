package hu.gaborneorcsity.fruits;

import java.io.UnsupportedEncodingException;

public class JSoupFruitSizeExtractor implements FruitSizeExtractor {
    @Override
    public double extract(String document) {
        try {
            return (double) document.getBytes("UTF8").length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

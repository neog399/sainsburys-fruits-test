package hu.gaborneorcsity.fruits.processors.attribute_extractors;

import java.io.UnsupportedEncodingException;

/**
 * A simple implementation based on JSoup
 */
public class JSoupFruitSizeExtractor implements FruitSizeExtractor {
    /**
     * {@inheritDoc}
     */
    @Override
    public int extract(String document) {
        try {
            return document.getBytes("UTF8").length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

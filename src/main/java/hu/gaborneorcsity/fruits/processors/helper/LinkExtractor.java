package hu.gaborneorcsity.fruits.processors.helper;

import java.util.List;

public interface LinkExtractor {
    List<String> extract(String document);
}

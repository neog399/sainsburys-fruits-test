package hu.gaborneorcsity.fruits;

import java.util.ArrayList;
import java.util.List;

public class FruitsDocumentProcessor {
    private final LinkExtractor linkExtractor;

    private final HtmlRetriever htmlRetriever;

    private final FruitDocumentProcessor fruitDocumentProcessor;

    public FruitsDocumentProcessor(
            LinkExtractor linkExtractor,
            HtmlRetriever htmlRetriever,
            FruitDocumentProcessor fruitDocumentProcessor
    ) {
        this.linkExtractor = linkExtractor;
        this.htmlRetriever = htmlRetriever;
        this.fruitDocumentProcessor = fruitDocumentProcessor;
    }

    public FruitCollection process(String document) {
        List<Fruit> fruitList = new ArrayList<>();
        for (String fruitLink : linkExtractor.extract(document)) {
            fruitList.add(fruitDocumentProcessor.process(htmlRetriever.retrieve(fruitLink)));
        }

        return new FruitCollection(fruitList);
    }
}

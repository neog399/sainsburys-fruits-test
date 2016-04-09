package hu.gaborneorcsity.fruits.processors;

import hu.gaborneorcsity.fruits.models.Fruit;
import hu.gaborneorcsity.fruits.models.FruitCollection;
import hu.gaborneorcsity.fruits.processors.helper.HtmlRetriever;
import hu.gaborneorcsity.fruits.processors.helper.LinkExtractor;

import java.util.ArrayList;
import java.util.List;

/**
 * A service for processing an HTML document containing the complete list of fruits
 */
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

    /**
     * Processes the provided HTML document and generates a collection of fruits based on it
     * @param document the document to be processed
     * @return the collection of fruits generated from the document
     */
    public FruitCollection process(String document) {
        List<Fruit> fruitList = new ArrayList<>();
        for (String fruitLink : linkExtractor.extract(document)) {
            fruitList.add(fruitDocumentProcessor.process(htmlRetriever.retrieve(fruitLink)));
        }

        return new FruitCollection(fruitList);
    }
}

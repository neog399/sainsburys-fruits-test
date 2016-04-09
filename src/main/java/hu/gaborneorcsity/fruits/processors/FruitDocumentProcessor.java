package hu.gaborneorcsity.fruits.processors;

import hu.gaborneorcsity.fruits.models.Fruit;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitDescriptionExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitSizeExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitTitleExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitUnitPriceExtractor;

/**
 * A service for processing an HTML document containing a single fruit
 */
public class FruitDocumentProcessor {
    private final FruitTitleExtractor titleExtractor;

    private final FruitDescriptionExtractor descriptionExtractor;

    private final FruitUnitPriceExtractor unitPriceExtractor;

    private final FruitSizeExtractor sizeExtractor;

    public FruitDocumentProcessor(
            FruitTitleExtractor titleExtractor,
            FruitDescriptionExtractor descriptionExtractor,
            FruitUnitPriceExtractor unitPriceExtractor,
            FruitSizeExtractor sizeExtractor
    ) {
        this.titleExtractor = titleExtractor;
        this.descriptionExtractor = descriptionExtractor;
        this.unitPriceExtractor = unitPriceExtractor;
        this.sizeExtractor = sizeExtractor;
    }

    /**
     * Processes the provided HTML document and generates a fruit based on it
     * @param document the document to be processed
     * @return the fruit generated from the document
     */
    public Fruit process(String document) {
        String title = titleExtractor.extract(document);
        String description = descriptionExtractor.extract(document);
        String unitPrice = unitPriceExtractor.extract(document);
        int size = sizeExtractor.extract(document);

        return new Fruit(title, description, unitPrice, size);
    }
}

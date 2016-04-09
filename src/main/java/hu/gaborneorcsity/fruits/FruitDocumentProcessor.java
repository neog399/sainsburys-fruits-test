package hu.gaborneorcsity.fruits;

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

    public Fruit process(String document) {
        String title = titleExtractor.extract(document);
        String description = descriptionExtractor.extract(document);
        String unitPrice = unitPriceExtractor.extract(document);
        double size = sizeExtractor.extract(document);

        return new Fruit(title, description, unitPrice, size);
    }
}

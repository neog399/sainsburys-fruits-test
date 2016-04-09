package hu.gaborneorcsity.fruits.processors.integration;

import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitDescriptionExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitSizeExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitTitleExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitUnitPriceExtractor;
import hu.gaborneorcsity.fruits.models.Fruit;
import hu.gaborneorcsity.fruits.models.FruitCollection;
import hu.gaborneorcsity.fruits.processors.FruitDocumentProcessor;
import hu.gaborneorcsity.fruits.processors.FruitsDocumentProcessor;
import hu.gaborneorcsity.fruits.processors.helper.HtmlRetriever;
import hu.gaborneorcsity.fruits.processors.helper.ApacheHttpRetriever;
import hu.gaborneorcsity.fruits.processors.helper.JSoupLinkExtractor;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FruitsDocumentProcessorIntegrationTest {
    private HtmlRetriever htmlRetriever = new ApacheHttpRetriever(HttpClients.createDefault());

    private FruitsDocumentProcessor documentProcessor = new FruitsDocumentProcessor(
            new JSoupLinkExtractor(),
            htmlRetriever,
            new FruitDocumentProcessor(
                    new JSoupFruitTitleExtractor(),
                    new JSoupFruitDescriptionExtractor(),
                    new JSoupFruitUnitPriceExtractor(),
                    new JSoupFruitSizeExtractor()
            )
    );

    @Test
    public void itSuccessfullyRetrievesProcessesAndPrintsTheFruits() {
        Fruit fruit1 = new Fruit(
                "Sainsbury's Apricot Ripe & Ready x5",
                "Apricots",
                "3.50",
                39185
        );

        Fruit fruit2 = new Fruit(
                "Sainsbury's Avocado Ripe & Ready XL Loose 300g",
                "Avocados",
                "1.50",
                39597
        );

        Fruit fruit3 = new Fruit(
                "Sainsbury's Avocado, Ripe & Ready x2",
                "Avocados",
                "1.80",
                44485
        );


        Fruit fruit4 = new Fruit(
                "Sainsbury's Avocados, Ripe & Ready x4",
                "Avocados",
                "3.20",
                39610
        );

        Fruit fruit5 = new Fruit(
                "Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)",
                "Conference",
                "1.50",
                39465
        );

        Fruit fruit6 = new Fruit(
                "Sainsbury's Golden Kiwi x4",
                "Gold Kiwi",
                "1.80",
                39485
        );

        Fruit fruit7 = new Fruit(
                "Sainsbury's Kiwi Fruit, Ripe & Ready x4",
                "Kiwi",
                "1.80",
                39911
        );

        FruitCollection expectedFruits = new FruitCollection(
                Arrays.asList(fruit1, fruit2, fruit3, fruit4, fruit5, fruit6, fruit7)
        );

        FruitCollection actualFruits = documentProcessor.process(
                htmlRetriever.retrieve(
                        "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html")
        );

        assertEquals(expectedFruits, actualFruits);
    }
}

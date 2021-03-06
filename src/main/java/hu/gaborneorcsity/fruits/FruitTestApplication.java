package hu.gaborneorcsity.fruits;

import hu.gaborneorcsity.fruits.models.FruitCollection;
import hu.gaborneorcsity.fruits.processors.FruitDocumentProcessor;
import hu.gaborneorcsity.fruits.processors.FruitsDocumentProcessor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitDescriptionExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitSizeExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitTitleExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.JSoupFruitUnitPriceExtractor;
import hu.gaborneorcsity.fruits.processors.helper.ApacheHtmlRetriever;
import hu.gaborneorcsity.fruits.processors.helper.HtmlRetriever;
import hu.gaborneorcsity.fruits.processors.helper.JSoupLinkExtractor;
import org.apache.http.impl.client.HttpClients;

/**
 * The application runner
 */
public class FruitTestApplication {
    private static final String TEST_PAGE_URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    private FruitsDocumentProcessor fruitsDocumentProcessor;

    private HtmlRetriever htmlRetriever;

    /**
     * Creates a new application runner
     */
    public FruitTestApplication() {
        //in real-life, DI would be used here, but for the sake of this example's simplicity I didn't use any DI frameworks
        htmlRetriever = new ApacheHtmlRetriever(HttpClients.createDefault());

        fruitsDocumentProcessor = new FruitsDocumentProcessor(
                new JSoupLinkExtractor(),
                htmlRetriever,
                new FruitDocumentProcessor(
                        new JSoupFruitTitleExtractor(),
                        new JSoupFruitDescriptionExtractor(),
                        new JSoupFruitUnitPriceExtractor(),
                        new JSoupFruitSizeExtractor()
                )
        );

    }

    /**
     * Runs the application
     */
    public void run() {
        FruitCollection fruits = fruitsDocumentProcessor.process(htmlRetriever.retrieve(TEST_PAGE_URL));

        System.out.print(fruits.asJson().toString(4));
    }
}

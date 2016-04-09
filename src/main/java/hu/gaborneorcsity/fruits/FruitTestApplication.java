package hu.gaborneorcsity.fruits;

public class FruitTestApplication {
    private static final String TEST_PAGE_URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    private FruitsDocumentProcessor fruitsDocumentProcessor;

    private HtmlRetriever htmlRetriever;

    public FruitTestApplication() {
        htmlRetriever = new JSoupHtmlRetriever();

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

    public void run() {
        FruitCollection fruits = fruitsDocumentProcessor.process(htmlRetriever.retrieve(TEST_PAGE_URL));

        System.out.print(fruits.asJson().toString(4));
    }
}

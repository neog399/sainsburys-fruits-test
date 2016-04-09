package hu.gaborneorcsity.fruits;

import hu.gaborneorcsity.fruits.models.FruitCollection;
import hu.gaborneorcsity.fruits.processors.FruitsDocumentProcessor;
import hu.gaborneorcsity.fruits.processors.helper.HtmlRetriever;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FruitTestApplicationTest {
    @Mock
    private HtmlRetriever htmlRetriever;

    @Mock
    private FruitsDocumentProcessor fruitsDocumentProcessor;

    @Mock
    private FruitCollection fruits;

    @Mock
    private JSONObject fruitsAsJson;

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @InjectMocks
    private FruitTestApplication fruitTestApplication;

    @Before
    public void before() {
        System.setOut(new PrintStream(outputStream));

        when(htmlRetriever.retrieve(
                "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html")).thenReturn(
                "fruits document");

        when(fruitsDocumentProcessor.process("fruits document")).thenReturn(fruits);

        when(fruits.asJson()).thenReturn(fruitsAsJson);

        when(fruitsAsJson.toString(4)).thenReturn("fruits json representation");
    }

    @Test
    public void itRetrievesTheFruitsDocument() {
        fruitTestApplication.run();

        verify(htmlRetriever, times(1)).retrieve(
                "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html");
    }

    @Test
    public void itProcessesTheRetrievedDocument() {
        fruitTestApplication.run();

        verify(fruitsDocumentProcessor, times(1)).process("fruits document");
    }

    @Test
    public void itConvertsTheProcessedFruitsToAJsonObject() {
        fruitTestApplication.run();

        verify(fruits, times(1)).asJson();
    }

    @Test
    public void itPrintsTheJsonObjectToTheStandardOutput() {
        fruitTestApplication.run();

        assertEquals("fruits json representation", outputStream.toString());
    }
}
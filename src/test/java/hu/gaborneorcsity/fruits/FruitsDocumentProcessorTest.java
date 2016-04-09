package hu.gaborneorcsity.fruits;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FruitsDocumentProcessorTest {
    @Mock
    private LinkExtractor linkExtractor;

    @Mock
    private HtmlRetriever htmlRetriever;

    @Mock
    private FruitDocumentProcessor fruitDocumentProcessor;

    @Mock
    private FruitCollection fruitCollection;

    private Fruit fruit1;

    private Fruit fruit2;

    @InjectMocks
    private FruitsDocumentProcessor fruitsDocumentProcessor;

    @Before
    public void before() throws Exception {
        when(linkExtractor.extract("fruits document")).thenReturn(Arrays.asList("fruit link #1", "fruit link #2"));

        when(htmlRetriever.retrieve("fruit link #1")).thenReturn("fruit document #1");
        when(htmlRetriever.retrieve("fruit link #2")).thenReturn("fruit document #2");

        fruit1 = new Fruit("Fruit #1", "Fruit description #1", "2.55", 56874);
        fruit2 = new Fruit("Fruit #2", "Fruit description #2", "1.85", 37459);

        when(fruitDocumentProcessor.process("fruit document #1")).thenReturn(fruit1);
        when(fruitDocumentProcessor.process("fruit document #2")).thenReturn(fruit2);
    }

    @Test
    public void itExtractsTheLinksFromTheDocument() {
        fruitsDocumentProcessor.process("fruits document");

        verify(linkExtractor, times(1)).extract("fruits document");
    }

    @Test
    public void itRetrievesTheIndividualFruitDocuments() {
        fruitsDocumentProcessor.process("fruits document");

        verify(htmlRetriever, times(1)).retrieve("fruit link #1");
        verify(htmlRetriever, times(1)).retrieve("fruit link #2");
    }

    @Test
    public void itProcessesTheFruitDocuments() {
        fruitsDocumentProcessor.process("fruits document");

        verify(fruitDocumentProcessor, times(1)).process("fruit document #1");
        verify(fruitDocumentProcessor, times(1)).process("fruit document #2");
    }

    @Test
    public void itReturnsTheFruitCollectionContainingTheProcessedFruits() {
        FruitCollection fruits = fruitsDocumentProcessor.process("fruits document");

        assertEquals("4.40", fruits.getTotal());

        List<Fruit> fruitList = fruits.getFruits();
        assertEquals(2, fruitList.size());

        assertEquals(fruit1, fruitList.get(0));
        assertEquals(fruit2, fruitList.get(1));
    }
}
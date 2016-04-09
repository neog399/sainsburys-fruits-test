package hu.gaborneorcsity.fruits.processors;

import hu.gaborneorcsity.fruits.models.Fruit;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitDescriptionExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitSizeExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitTitleExtractor;
import hu.gaborneorcsity.fruits.processors.attribute_extractors.FruitUnitPriceExtractor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FruitDocumentProcessorTest {
    @Mock
    private FruitTitleExtractor fruitTitleExtractor;

    @Mock
    private FruitDescriptionExtractor fruitDescriptionExtractor;

    @Mock
    private FruitUnitPriceExtractor fruitUnitPriceExtractor;

    @Mock
    private FruitSizeExtractor fruitSizeExtractor;

    @InjectMocks
    private FruitDocumentProcessor fruitDocumentProcessor;

    @Before
    public void before() throws Exception {
        when(fruitTitleExtractor.extract("fruit document")).thenReturn("Fruit title");
        when(fruitDescriptionExtractor.extract("fruit document")).thenReturn("Fruit description");
        when(fruitUnitPriceExtractor.extract("fruit document")).thenReturn("2.55");
        when(fruitSizeExtractor.extract("fruit document")).thenReturn(37895);
    }

    @Test
    public void itExtractsTheFruitsTitleFromTheDocument() {
        fruitDocumentProcessor.process("fruit document");

        verify(fruitTitleExtractor, times(1)).extract("fruit document");
    }

    @Test
    public void itExtractsTheFruitsDescriptionFromTheDocument() {
        fruitDocumentProcessor.process("fruit document");

        verify(fruitDescriptionExtractor, times(1)).extract("fruit document");
    }

    @Test
    public void itExtractsTheFruitsUnitPriceFromTheDocument() {
        fruitDocumentProcessor.process("fruit document");

        verify(fruitUnitPriceExtractor, times(1)).extract("fruit document");
    }

    @Test
    public void itExtractsTheDocumentsSize() {
        fruitDocumentProcessor.process("fruit document");

        verify(fruitSizeExtractor, times(1)).extract("fruit document");
    }

    @Test
    public void itReturnsTheFruitCreatedFromTheExtractedAttributes() {
        Fruit fruit = fruitDocumentProcessor.process("fruit document");

        assertEquals("Fruit title", fruit.getTitle());
        assertEquals("Fruit description", fruit.getDescription());
        assertEquals("2.55", fruit.getUnitPriceAsString());
        assertEquals(37895, fruit.getSize());
    }
}
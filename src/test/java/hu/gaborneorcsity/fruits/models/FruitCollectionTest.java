package hu.gaborneorcsity.fruits.models;

import hu.gaborneorcsity.fruits.models.Fruit;
import hu.gaborneorcsity.fruits.models.FruitCollection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FruitCollectionTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private Fruit lemon;
    private Fruit apple;

    @Before
    public void setUp() throws Exception {
        lemon = new Fruit("Very nice lemon", "A lemon that's very nice", "7.2", 45781);
        apple = new Fruit("Very nice apple", "An apple that's very nice", "5.45", 37589);
    }

    @Test
    public void itSuccessfullyCreatesANewFruitCollectionContainingACoupleOfFruits() {
        FruitCollection fruits = new FruitCollection(Arrays.asList(lemon, apple));

        assertNotNull(fruits.getFruits());
        assertEquals("12.65", fruits.getTotal());

        List<Fruit> fruitList = fruits.getFruits();
        assertEquals(2, fruitList.size());
        assertTrue(fruitList.contains(lemon));
        assertTrue(fruitList.contains(apple));
    }

    @Test
    public void itSuccessfullyCreatesANewFruitCollectionCContainingNoFruits() {
        FruitCollection fruits1 = new FruitCollection(Collections.emptyList());

        assertNotNull(fruits1.getFruits());
        assertEquals("0.0", fruits1.getTotal());

        List<Fruit> fruitList1 = fruits1.getFruits();
        assertTrue(fruitList1.isEmpty());

        FruitCollection fruits2 = new FruitCollection();

        assertNotNull(fruits2.getFruits());
        assertEquals("0.0", fruits2.getTotal());

        List<Fruit> fruitList2 = fruits1.getFruits();
        assertTrue(fruitList2.isEmpty());
    }

    @Test
    public void itFailsToCreateANewFruitCollectionWithoutPassingInAListOfFruits() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The list of fruits cannot be null!");

        new FruitCollection(null);
    }

    @Test
    public void itReturnsTheFruitsJsonRepresentation() {
        FruitCollection fruits = new FruitCollection(Arrays.asList(lemon, apple));

        JSONObject fruitsAsJson = fruits.asJson();
        assertEquals("12.65", fruitsAsJson.getString("total"));

        JSONArray fruitList = fruitsAsJson.getJSONArray("results");
        assertEquals(2, fruitList.length());
    }
}
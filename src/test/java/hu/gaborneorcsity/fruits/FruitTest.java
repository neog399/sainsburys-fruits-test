package hu.gaborneorcsity.fruits;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FruitTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void itReturnsTheFruitsJsonRepresentation() {
        Fruit fruit = new Fruit("Very nice apple", 123.6, 5.45, "An apple that's very nice");

        JSONObject fruitAsJson = fruit.asJson();
        assertEquals("Very nice apple", fruitAsJson.getString("title"));
        assertEquals("123.6kb", fruitAsJson.getString("size"));
        assertEquals(5.45, fruitAsJson.getDouble("unit_price"), 0.0);
        assertEquals("An apple that's very nice", fruitAsJson.getString("description"));
    }
}
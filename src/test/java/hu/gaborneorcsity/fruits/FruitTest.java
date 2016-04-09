package hu.gaborneorcsity.fruits;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FruitTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void itReturnsTheFruitsJsonRepresentation() {
        Fruit fruit = new Fruit("Very nice apple", "An apple that's very nice", "5.45", 30720);

        JSONObject fruitAsJson = fruit.asJson();
        assertEquals("Very nice apple", fruitAsJson.getString("title"));
        assertEquals("30.0kb", fruitAsJson.getString("size"));
        assertEquals("5.45", fruitAsJson.getString("unit_price"));
        assertEquals("An apple that's very nice", fruitAsJson.getString("description"));
    }
}
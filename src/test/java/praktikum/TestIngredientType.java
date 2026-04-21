package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestIngredientType {
    @Test
    public void testEnumShouldLength() {
        assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void testEnumShouldValueSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testEnumShouldValueFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}
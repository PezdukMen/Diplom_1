package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredientParameterized {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public TestIngredientParameterized(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameters(name = "Ингредиент: {0} {1} цена {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.SAUCE, "sour cream", 200f},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 150f},
                {IngredientType.FILLING, "dinosaur", 250f},
                {IngredientType.FILLING, "sausage", 300f}
        });
    }

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void constructorShouldSetType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void constructorShouldSetName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void constructorShouldSetPrice() {
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }

}
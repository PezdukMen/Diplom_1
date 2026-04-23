package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient sauceA, sauceB, filling;

    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();

        when(bunMock.getName()).thenReturn("test bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(sauceA.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceA.getName()).thenReturn("hot sauce");
        when(sauceA.getPrice()).thenReturn(50f);

        when(sauceB.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceB.getName()).thenReturn("sour cream");
        when(sauceB.getPrice()).thenReturn(150f);

        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn("cutlet");
        when(filling.getPrice()).thenReturn(100f);
    }

    // ==================== setBuns ====================
    @Test
    public void setBunsShouldSetBunField() {
        burger.setBuns(bunMock);
        assertSame(bunMock, burger.bun);
    }

    // ==================== addIngredient ====================
    @Test
    public void addIngredientShouSizeOne() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void addIngredientShouSizeTwo() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void addIngredientShouSizeThree() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void addIngredientShouldAdd() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        assertSame(sauceA, burger.ingredients.get(0));
    }

    // ==================== removeIngredient ====================
    @Test
    public void removeIngredientShouldRemoveFirstElement() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        burger.removeIngredient(0);
        assertSame(sauceB, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientShouldRemoveMiddleElement() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        burger.removeIngredient(1);
        assertSame(filling, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientShouldRemoveLastElement() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        burger.removeIngredient(2);
        assertSame(sauceA, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientShouldWorkWithSingleElement() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);

        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    // ==================== moveIngredient ====================
    @Test
    public void moveIngredientShouldMoveFirstToEnd() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        burger.moveIngredient(0, 2);
        assertSame(sauceB, burger.ingredients.get(0));
        assertSame(filling, burger.ingredients.get(1));
        assertSame(sauceA, burger.ingredients.get(2));
    }

    @Test
    public void moveIngredientShouldMoveLastToFront() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        burger.moveIngredient(2, 0);
        assertSame(filling, burger.ingredients.get(0));
        assertSame(sauceA, burger.ingredients.get(1));
        assertSame(sauceB, burger.ingredients.get(2));
    }

    @Test
    public void moveIngredientShouldDoNothingWhenSameIndex() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        burger.moveIngredient(1, 1); // middle to middle
        assertSame(sauceA, burger.ingredients.get(0));
        assertSame(sauceB, burger.ingredients.get(1));
        assertSame(filling, burger.ingredients.get(2));
    }

    // ==================== getPrice ====================
    @Test
    public void getPriceShouldReturnDoubleBunPriceWhenNoIngredients() {
        burger.setBuns(bunMock);
        assertEquals(200f, burger.getPrice(), 0.001f);
    }

    @Test
    public void getPriceShouldAddIngredientPricesToDoubleBunPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        float expected = 100f * 2 + 50f + 150f + 100f; // 500
        assertEquals(expected, burger.getPrice(), 0.001f);
    }

    // ==================== getReceipt ====================
    @Test
    public void getReceiptShouldPrintCorrectFormatWithIngredients() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceA);
        burger.addIngredient(sauceB);
        burger.addIngredient(filling);

        String actual = burger.getReceipt()
                .replace("\r\n", "\n")
                .replace("\r", "\n")
                .replace(',', '.');

        String expected =
                "(==== test bun ====)\n" +
                        "= sauce hot sauce =\n" +
                        "= sauce sour cream =\n" +
                        "= filling cutlet =\n" +
                        "(==== test bun ====)\n" +
                        "\nPrice: 500.000000\n";

        assertEquals(expected, actual);
    }

    @Test
    public void getReceiptShouldPrintCorrectFormatWithoutIngredients() {
        burger.setBuns(bunMock);

        String actual = burger.getReceipt()
                .replace("\r\n", "\n")
                .replace("\r", "\n")
                .replace(',', '.');

        String expected =
                "(==== test bun ====)\n" +
                        "(==== test bun ====)\n" +
                        "\nPrice: 200.000000\n";

        assertEquals(expected, actual);
    }

}
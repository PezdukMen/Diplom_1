package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertSame;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientTest {

    @Mock
    private Ingredient sauceA;  // 0
    @Mock
    private Ingredient sauceB;  // 1
    @Mock
    private Ingredient filling; // 2

    private Burger burger;

    private final int fromIndex;
    private final int toIndex;
    private final int checkIndex;
    private final int expectedIngredientIndex;

    public BurgerMoveIngredientTest(int fromIndex, int toIndex,
                                    int checkIndex, int expectedIngredientIndex) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.checkIndex = checkIndex;
        this.expectedIngredientIndex = expectedIngredientIndex;
    }

    @Parameterized.Parameters(name = "move({0},{1}) → индекс {2} = ингредиент[{3}]")
    public static Object[][] data() {
        return new Object[][]{
                // move(0, 2): результат [B, C, A]
                {0, 2, 0, 1},
                {0, 2, 1, 2},
                {0, 2, 2, 0},
                // move(2, 0): результат [C, A, B]
                {2, 0, 0, 2},
                {2, 0, 1, 0},
                {2, 0, 2, 1},
                // move(1, 1): результат [A, B, C] (без изменений)
                {1, 1, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 2, 2},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.addIngredient(sauceA); // 0
        burger.addIngredient(sauceB); // 1
        burger.addIngredient(filling); // 2
    }

    @Test
    public void moveIngredientShouldPlaceCorrectIngredientAtPosition() {
        Ingredient[] all = {sauceA, sauceB, filling};

        burger.moveIngredient(fromIndex, toIndex);

        assertSame(all[expectedIngredientIndex], burger.ingredients.get(checkIndex));
    }
}
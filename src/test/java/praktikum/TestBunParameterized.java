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
public class TestBunParameterized {

    private final String name;
    private final float price;
    private Bun bun;

    public TestBunParameterized(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameters(name = "Булочка: {0}, цена {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f}
        });
    }

    @Before
    public void init() {
        bun = new Bun(name, price);
    }

    @Test
    public void constructorShouldSetName() {
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.001f);
    }

    @Test
    public void constructorShouldSetPrice() {
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.001f);
    }

}
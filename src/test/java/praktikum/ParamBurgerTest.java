package praktikum;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParamBurgerTest {

    private static final double DELTA_PRICE = 0.01;

    @ParameterizedTest
    @ValueSource(floats = {100F, 200F, 300F})
    void shouldCalculateTotalPriceCorrectly(float bunPrice) {

        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient1 = mock(Ingredient.class);
        Ingredient mockIngredient2 = mock(Ingredient.class);


        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredient1.getPrice()).thenReturn(50F);
        when(mockIngredient2.getPrice()).thenReturn(75F);


        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);


        float expectedPrice = bunPrice * 2 + 50F + 75F;
        assertEquals(expectedPrice, burger.getPrice(), DELTA_PRICE);
    }
}
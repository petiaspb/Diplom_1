package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class BurgerTest {


    @Mock
    private Bun blackBun;

    @Mock
    private Ingredient cutlet;

    @Mock
    private Ingredient hotSauce;

    private Burger burger;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        when(blackBun.getName()).thenReturn("Black Bun");
        when(blackBun.getPrice()).thenReturn(100F); // Цена булочки

        when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        when(cutlet.getName()).thenReturn("cutlet");
        when(cutlet.getPrice()).thenReturn(50F); // Цена котлеты

        when(hotSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(hotSauce.getName()).thenReturn("hot sauce");
        when(hotSauce.getPrice()).thenReturn(75F); // Цена соуса

        burger = new Burger(); // Реальная реализация класса Burger
    }

    @Test
    void shouldRemoveIngredientByIndex() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(hotSauce);

        burger.removeIngredient(0);

        assertFalse(burger.ingredients.contains(cutlet)); // Проверка удаления ингредиента
    }

    @Test
    void shouldMoveIngredientToNewPosition() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(hotSauce);

        burger.moveIngredient(0, 1);

        assertTrue(burger.ingredients.indexOf(cutlet) > burger.ingredients.indexOf(hotSauce)); // Проверка перемещения
    }

    @Test
    void shouldGenerateValidReceipt() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(hotSauce);

        String expectedReceipt =
                "(==== Black Bun ====)\r\n" +
                        "= filling cutlet =\r\n" +
                        "= sauce hot sauce =\r\n" +
                        "(==== Black Bun ====)\r\n\r\n" +
                        "Price: 325,000000\r\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}

package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

    private Burger burger;
    private Bun blackBun;
    private Ingredient cutlet;
    private Ingredient hotSauce;

    @BeforeEach
    void setup() {

        blackBun = new Bun("Black Bun", 100F);

        cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 50F);

        hotSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 75F);

        burger = new Burger();
    }




    @Test
    void shouldRemoveIngredientByIndex() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(hotSauce);

        burger.removeIngredient(0);

        assertFalse(burger.ingredients.contains(cutlet));
    }

    @Test
    void shouldMoveIngredientToNewPosition() {

        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(hotSauce);


        burger.moveIngredient(0, 1);


        assertTrue(burger.ingredients.indexOf(cutlet) > burger.ingredients.indexOf(hotSauce));
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

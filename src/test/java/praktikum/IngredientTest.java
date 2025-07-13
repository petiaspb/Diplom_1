package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    @Test
    void shouldReturnCorrectValuesForIngredient() {
        praktikum.Ingredient ingredient = new praktikum.Ingredient(praktikum.IngredientType.SAUCE, "Hot Sauce", 100);
        assertEquals(praktikum.IngredientType.SAUCE, ingredient.getType());
        assertEquals("Hot Sauce", ingredient.getName());
        assertEquals(100, ingredient.getPrice());
    }
}

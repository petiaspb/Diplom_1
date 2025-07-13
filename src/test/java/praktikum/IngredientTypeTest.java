package praktikum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class IngredientTypeTest {



    @Test
    void shouldContainExpectedTypes() {
        praktikum.IngredientType[] types = praktikum.IngredientType.values();
        praktikum.IngredientType[] expectedTypes = {praktikum.IngredientType.SAUCE, praktikum.IngredientType.FILLING};
        assertArrayEquals(expectedTypes, types);
    }
}

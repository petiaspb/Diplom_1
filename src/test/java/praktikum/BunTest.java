package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BunTest {

    @Test
    void shouldReturnCorrectNameAndPrice() {
        Bun bun = new Bun("Black Bun", 100);
        assertEquals("Black Bun", bun.getName());
        assertEquals(100, bun.getPrice());
    }
}
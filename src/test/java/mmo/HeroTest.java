package mmo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    private Hero hero;

    @BeforeEach
        // runs before EVERY test → each test gets a fresh lantern
    void setUp() {
        hero = new Hero("Samad", 275);   // 100 fuel
    }

    @Test
    void baseStats() {
        assertEquals("Samad", hero.getName());
        assertEquals(Hero.STARTING_LEVEL, hero.getLevel());
    }

    @Test
    void correctStartingHP(){
        assertEquals(275, hero.getMaxHP());
        assertEquals(275, hero.getCurrentHP());
    }

    @Test
    void emptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Hero("    ", 275));
    }

    @Test
    void nullName() {
        assertThrows(IllegalArgumentException.class, () -> new Hero(null, 275));
    }

    @Test
    void negativeMaxHealth() {
        assertThrows(IllegalArgumentException.class, () -> new Hero("Samad", - 275 ));
    }

    @Test
    void zeroMaxHealth() {
        assertThrows(IllegalArgumentException.class, () -> new Hero("Samad", 0));
    }


    @Test
    void takeDamageNeverGoesBelowZero() {

    }

    @Test
    void heal() {
    }

    @Test
    void isAlive() {
    }

    @Test
    void levelUp() {
    }
}
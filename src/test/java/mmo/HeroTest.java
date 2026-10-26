package mmo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    private Hero hero;

    @BeforeEach

    void setUp() {
        hero = new Hero("Samad", 275);
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
    void properDamageValue() {
        hero.takeDamage(75);
        assertEquals(200, hero.getCurrentHP());

    }

    @Test
    void heal() {
        hero.takeDamage(100);
        hero.heal(90);
        assertEquals(265,hero.getCurrentHP());
    }

    @Test
    void zeroHPHeroIsNotAlive() {
        hero.takeDamage(275);
        assertFalse(hero.isAlive());
    }

    @Test
    void levelUp() {
        hero.levelUp();
        assertEquals(2, hero.getLevel());
        assertEquals(285, hero.getMaxHP());
        assertEquals(285, hero.getCurrentHP());
    }
    @Test
    void overkillDamageClampsHPToZero() {
        hero.takeDamage(300);
        assertEquals(0, hero.getCurrentHP());
    }

    @Test
    void negativeDamageThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> hero.takeDamage(-10));
    }

    @Test
    void overHealClampsToMaxHP() {
        hero.takeDamage(100);
        hero.heal(200);
        assertEquals(275, hero.getCurrentHP());
    }

    @Test
    void healToExactlyMaxHP() {
        hero.takeDamage(100);
        hero.heal(100);
        assertEquals(275, hero.getCurrentHP());
    }

    @Test
    void deadHeroCannotBeHealed() {
        hero.takeDamage(275);
        hero.heal(50);
        assertEquals(0, hero.getCurrentHP());
    }

    @Test
    void negativeHealThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> hero.heal(-10));
    }

    @Test
    void fullHPHeroIsAlive() {
        assertTrue(hero.isAlive());
    }
}
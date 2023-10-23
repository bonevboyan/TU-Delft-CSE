package practice_exams.mock_exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;


public class SpellCardTest {
    private static final String NAME = "Spell";
    private static final int ENERGY_COST = 10;
    private static final String TYPE = "Frost";
    private static final String DESCRIPTION = "Chilly!";
    private static final Rarity RARITY = Rarity.LEGENDARY;
    private static SpellCard spellCard;

    @BeforeAll
    public static void createCards () {
        spellCard = new SpellCard(RARITY, NAME, ENERGY_COST, TYPE, DESCRIPTION);
    }

    @Test
    public void constructorShouldCreateInstance() {
        assertNotNull(spellCard);
    }

    @Test
    public void energyGetterShouldReturnCorrectValue() {
        assertEquals(ENERGY_COST, spellCard.getEnergyCost());
    }

    @Test
    public void nameGetterShouldReturnCorrectValue() {
        assertEquals(NAME, spellCard.getName());
    }

    @Test
    public void descriptionGetterShouldReturnCorrectValue() {
        assertEquals(DESCRIPTION, spellCard.getDescription());
    }

    @Test
    public void rarityGetterShouldReturnCorrectValue() {
        assertEquals(RARITY, spellCard.getRarity());
    }

    @Test
    public void equalsShouldReturnTrueIfSame() {
        SpellCard other = new SpellCard(RARITY, NAME, ENERGY_COST, TYPE, DESCRIPTION);

        assertEquals(other, spellCard);
    }

    @Test
    public void equalObjectsShouldReturnSameHash() {
        SpellCard other = new SpellCard(RARITY, NAME, ENERGY_COST, TYPE, DESCRIPTION);

        assertEquals(other.hashCode(), spellCard.hashCode());
    }

    @Test
    public void toStringReturnsCorrectString() {
        String result = String.format("Spell: %s (%s), costs (%d) Energy.\n%s - %s", NAME, RARITY, ENERGY_COST, TYPE, DESCRIPTION);

        assertEquals(result, spellCard.toString());
    }
}

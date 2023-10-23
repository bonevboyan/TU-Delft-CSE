package practice_exams.mock_exam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UnitCardTest {
    private static final String NAME = "Unit";
    private static final int ENERGY_COST = 5;
    private static final Rarity RARITY = Rarity.NORMAL;
    private static final int ATTACK = 6;
    private static final int DEFENCE = 7;

    private static UnitCard unitCard;

    @BeforeAll
    public static void createCards () {
        unitCard = new UnitCard(RARITY, NAME, ENERGY_COST, ATTACK, DEFENCE);
    }

    @Test
    public void constructorShouldCreateCorrectInstance() {
        assertNotNull(unitCard);
    }

    public void rarityGetterShouldReturnCorrectValue() {
        assertEquals(unitCard.getRarity(), RARITY);
    }

    @Test
    public void nameGetterShouldReturnCorrectValue() {
        assertEquals(unitCard.getName(), NAME);
    }

    @Test
    public void energyGetterShouldReturnCorrectValue() {
        assertEquals(unitCard.getEnergyCost(), ENERGY_COST);
    }

    @Test
    public void attackGetterShouldReturnCorrectValue() {
        assertEquals(unitCard.getAttackValue(), ATTACK);
    }

    @Test
    public void defenceGetterShouldReturnCorrectValue() {
        assertEquals(unitCard.getDefenceValue(), DEFENCE);
    }
}

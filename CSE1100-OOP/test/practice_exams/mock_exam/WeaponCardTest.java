package practice_exams.mock_exam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class WeaponCardTest {
    private static final Rarity RARITY = Rarity.RARE;
    private static final String NAME = "Weapon";
    private static final int ENERGY_COST = 8;
    private static final int DURABILITY = 9;
    private static WeaponCard weaponCard;

    @BeforeAll
    public static void createCards () {
        weaponCard = new WeaponCard(RARITY, NAME, ENERGY_COST, DURABILITY);
    }

    @Test
    public void constructorShouldCreateCorrectInstance() {
        assertNotNull(weaponCard);
    }

    @Test
    public void rarityGetterShouldReturnCorrectValue() {
        assertEquals(weaponCard.getRarity(), RARITY);
    }

    @Test
    public void nameGetterShouldReturnCorrectValue() {
        assertEquals(weaponCard.getName(), NAME);
    }

    @Test
    public void energyGetterShouldReturnCorrectValue() {
        assertEquals(weaponCard.getEnergyCost(), ENERGY_COST);
    }

    @Test
    public void durabilityGetterShouldReturnCorrectValue() {
        assertEquals(weaponCard.getDurability(), DURABILITY);
    }

}

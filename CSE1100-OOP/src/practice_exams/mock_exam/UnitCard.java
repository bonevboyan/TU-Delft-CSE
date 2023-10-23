package practice_exams.mock_exam;

import java.util.Objects;

public class UnitCard extends Card {
    private int attackValue;
    private int defenceValue;

    /**
     * Creates a new spell card.
     *
     * @param rarity     of the new card
     * @param name       of the new card
     * @param energyCost of the new card
     * @param attackValue of the new card
     * @param defenceValue of the new card
     */
    public UnitCard(Rarity rarity, String name, int energyCost, int attackValue, int defenceValue) {
        super(rarity, name, energyCost);
        this.attackValue = attackValue;
        this.defenceValue = defenceValue;
    }

    /**
     * @return the attack value of the card
     */
    public int getAttackValue() {
        return attackValue;
    }

    /**
     * @return the defence value of the card
     */
    public int getDefenceValue() {
        return defenceValue;
    }

    /**
     * Compares two unit cards
     * @param o object to compare with
     * @return true iff cards are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UnitCard unitCard = (UnitCard) o;
        return attackValue == unitCard.attackValue && defenceValue == unitCard.defenceValue;
    }

    /**
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackValue, defenceValue);
    }

    /**
     * @return the unit card as a string
     */
    @Override
    public String toString() {
        return String.format("Unit: %s\n%d Attack - %d Defence",
                super.toString(),
                attackValue,
                defenceValue);
    }
}

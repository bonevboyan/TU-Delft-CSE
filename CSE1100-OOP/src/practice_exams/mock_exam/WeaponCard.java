package practice_exams.mock_exam;

import java.util.Objects;

public class WeaponCard extends Card {
    private int durability;

    /**
     * Creates a new card.
     *
     * @param rarity     of the new card
     * @param name       of the new card
     * @param energyCost of the new card
     * @param durability of the new card
     */
    public WeaponCard(Rarity rarity, String name, int energyCost, int durability) {
        super(rarity, name, energyCost);
        this.durability = durability;
    }

    /**
     * @return the durability of the card
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Compares two weapon cards
     * @param o object to compare with
     * @return true iff cards are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WeaponCard that = (WeaponCard) o;
        return durability == that.durability;
    }

    /**
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), durability);
    }

    /**
     * @return the weapon card as a string
     */
    @Override
    public String toString() {
        return String.format("Spell: %s\n%s Durability",
                super.toString(),
                durability);
    }
}

package practice_exams.mock_exam;

import java.util.Objects;

public abstract class Card {
    private Rarity rarity;
    private String name;
    private int energyCost;

    /**
     * Creates a new card.
     *
     * @param rarity of the new card
     * @param name of the new card
     * @param energyCost of the new card
     */
    public Card(Rarity rarity, String name, int energyCost) {
        this.rarity = rarity;
        this.name = name;
        this.energyCost = energyCost;
    }

    /**
     * @return the rarity of the card
     */
    public Rarity getRarity() {
        return rarity;
    }

    /**
     * @return the name of the card
     */
    public String getName() {
        return name;
    }

    /**
     * @return the name of the card
     */
    public int getEnergyCost() {
        return energyCost;
    }

    /**
     * Compares two cards
     * @param o object to compare with
     * @return true iff cards are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return energyCost == card.energyCost && rarity == card.rarity && Objects.equals(name, card.name);
    }

    /**
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(rarity, name, energyCost);
    }

    /**
     * @return the card as a string
     */
    @Override
    public String toString() {
        return String.format("%s (%s), costs (%d) Energy.", name, rarity, energyCost);
    }
}

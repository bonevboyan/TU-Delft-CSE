package practice_exams.mock_exam;

import java.util.Objects;

public class SpellCard extends Card {
    private String type;
    private String description;

    /**
     * Creates a new card.
     *
     * @param rarity     of the new card
     * @param name       of the new card
     * @param energyCost of the new card
     * @param type of the new card
     * @param description of the new card
     */
    public SpellCard(Rarity rarity, String name, int energyCost, String type, String description) {
        super(rarity, name, energyCost);
        this.type = type;
        this.description = description;
    }


    /**
     * @return the description of the spell card
     */
    public String getDescription() {
        return description;
    }

    /**
     * Compares two spell cards
     * @param o object to compare with
     * @return true iff cards are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpellCard spellCard = (SpellCard) o;
        return Objects.equals(type, spellCard.type) &&
                Objects.equals(description, spellCard.description);
    }

    /**
     * @return hashCode of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, description);
    }

    /**
     * @return the spell card as a string
     */
    @Override
    public String toString() {
        return String.format("Spell: %s\n%s - %s",
                super.toString(),
                type,
                description);
    }
}

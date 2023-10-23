package practice_exams.mock_exam;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserCollection {
    private int gold;

    private final Set<Card> ownedCards;

    /**
     * Creates an empty user collection
     */
    public UserCollection() {
        gold = 0;
        ownedCards = new HashSet<>();
    }

    /**
     * @return owned cards
     */
    public Set<Card> getOwnedCards() {
        return ownedCards;
    }

    /**
     * @return gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * Add a new card if it is not present, if it is, add its value in gold to the total
     * @param newCard the card to be added
     */
    public void addCard(Card newCard) {
        if (!ownedCards.add(newCard)) {
            gold += newCard.getRarity().getValue();
        }
    }

    /**
     * @param o object to compare with
     * @return true iff equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCollection that = (UserCollection) o;
        return gold == that.gold && Objects.equals(ownedCards, that.ownedCards);
    }

    /**
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(gold, ownedCards);
    }

    /**
     * @return the user collection as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("You have %d gold and own %d cards.\n\n", gold, ownedCards.size()));

        for (Card card :
                ownedCards) {
            sb.append(card.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}

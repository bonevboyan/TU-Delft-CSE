package practice_exams.mock_exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserCollectionTest {
    private UserCollection userCollection;
    @BeforeEach
    public void createCards () {
        userCollection = new UserCollection();
    }

    @Test
    public void constructorShouldCreateInstance() {
        assertNotNull(userCollection);
    }

    @Test
    public void addCardShouldAddCorrectCards() {
        Card card = new WeaponCard(Rarity.EPIC, "Weapon", 5, 10);
        Set<Card> cards = new HashSet<>();
        cards.add(card);

        userCollection.addCard(card);

        assertEquals(cards, userCollection.getOwnedCards());
    }



    @Test
    public void addCardShouldAddGoldOnDuplicate() {
        Card card = new WeaponCard(Rarity.EPIC, "Weapon", 5, 10);
        Set<Card> cards = new HashSet<>();
        cards.add(card);

        userCollection.addCard(card);
        userCollection.addCard(card);

        assertEquals(cards, userCollection.getOwnedCards());
        assertEquals(Rarity.EPIC.getValue(), userCollection.getGold());
    }

    @Test
    public void equalsShouldReturnTrueOnSame() {
        Card card = new WeaponCard(Rarity.EPIC, "Weapon", 5, 10);

        UserCollection otherCollection = new UserCollection();

        userCollection.addCard(card);
        otherCollection.addCard(card);

        assertEquals(otherCollection, userCollection);
    }

    @Test
    public void hashCodeShouldBeSameForEqualObjects() {
        Card card = new WeaponCard(Rarity.EPIC, "Weapon", 5, 10);

        UserCollection otherCollection = new UserCollection();

        userCollection.addCard(card);
        otherCollection.addCard(card);

        assertEquals(otherCollection.hashCode(), userCollection.hashCode());
    }



    @Test
    public void toStringShouldReturnCorrectString() {
        Card card = new WeaponCard(Rarity.EPIC, "Weapon", 5, 10);

        userCollection.addCard(card);

        String expectedString = "You have 0 gold and own 1 cards.\n\nSpell: Weapon (EPIC), costs (5) Energy.\n10 Durability\n";

        assertEquals(expectedString, userCollection.toString());
    }
}

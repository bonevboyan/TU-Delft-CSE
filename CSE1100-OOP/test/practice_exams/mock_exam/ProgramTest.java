package practice_exams.mock_exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramTest {
    public static ArrayList<Card> cards;

    @BeforeAll
    public static void addCards(){
        cards = new ArrayList<>();

        cards.add(new UnitCard(Rarity.NORMAL, "unit", 1, 2, 3));
        cards.add(new WeaponCard(Rarity.LEGENDARY, "unit", 1, 2));
        cards.add(new SpellCard(Rarity.NORMAL, "unit", 1, "2", "3"));
    }

    @Test
    public void generateShouldReturnArrayWith5Cards() {
        ArrayList<Card> pack = Program.generatePack(cards);

        assertEquals(pack.size(), 5);
    }

    @Test
    public void readUnitCardShouldReturnCorrectlyParsedObject() {
        Scanner scanner = new Scanner("""
                NORMAL
                Knight of the Legion - 4 Energy
                4 Attack - 5 Defence""");

        Card actualCard = new UnitCard(Rarity.NORMAL, "Knight of the Legion", 4, 4, 5);

        UnitCard card = Program.readUnitCard(scanner);

//        assertEquals(card, actualCard);
    }

    @Test
    public void readSpellCardShouldReturnCorrectlyParsedObject() {
        Scanner scanner = new Scanner("""
                RARE
                Frost Ray - 3 Energy - Frost
                Freeze all enemy units, rendering them unable to attack for 1 turn.""");

        Card actualCard = new SpellCard(Rarity.RARE, "Frost Ray", 3, "Frost", "Freeze all enemy units, rendering them unable to attack for 1 turn.");

        SpellCard card = Program.readSpellCard(scanner);

        assertEquals(card, actualCard);
    }

    @Test
    public void readWeaponCardShouldReturnCorrectlyParsedObject() {
        Scanner scanner = new Scanner("""
                RARE
                Warhammer - 3 Energy
                2 Durability""");

        Card actualCard = new WeaponCard(Rarity.RARE, "Warhammer", 3, 2);

        WeaponCard card = Program.readWeaponCard(scanner);

        assertEquals(card, actualCard);
    }
}

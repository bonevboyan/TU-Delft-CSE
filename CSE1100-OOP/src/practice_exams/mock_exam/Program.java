package practice_exams.mock_exam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Program {
    /**
     * Runs the program
     *
     * @param args arguments of main
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<Card> knownCards = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File("./src/practice_exams/mock_exam/test.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                switch (line) {
                    case "Unit Card" -> knownCards.add(readUnitCard(fileScanner));
                    case "Spell Card" -> knownCards.add(readSpellCard(fileScanner));
                    case "Weapon Card" -> knownCards.add(readWeaponCard(fileScanner));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        UserCollection userCollection = new UserCollection();
        int option = 0;
        do {
            System.out.println("Please make your choice:\n" +
                    "1 – Show all known cards.\n" +
                    "2 – Show user’s card collection and gold.\n" +
                    "3 – Open a pack of cards.\n" +
                    "4 – Save collection to file.\n" +
                    "5 – Quit the application.\n");

            option = console.nextInt();
            switch (option) {
                case 1 -> {
                    String output = knownCards.stream().map(Card::toString)
                            .collect(Collectors.joining("\n"));
                    System.out.println(output);
                }
                case 2 -> System.out.println(userCollection.toString());
                case 3 -> generatePack(knownCards).forEach(userCollection::addCard);
                case 4 -> {
                    try (FileWriter fileWriter
                                 = new FileWriter("./src/practice_exams/mock_exam/output.txt")) {
                        fileWriter.write(userCollection.toString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> {
                }
            }
        } while (option != 5);
    }

    /**
     * Generates an array of 5 random cards
     * @param knownCards all cards
     * @return the card pack
     */
    public static ArrayList<Card> generatePack(ArrayList<Card> knownCards) {
        List<Card> legendaryCards = knownCards.stream()
                .filter(x -> x.getRarity() == Rarity.LEGENDARY).toList();
        List<Card> epicCards = knownCards.stream()
                .filter(x -> x.getRarity() == Rarity.EPIC).toList();
        List<Card> rareCards = knownCards.stream()
                .filter(x -> x.getRarity() == Rarity.RARE).toList();
        List<Card> normalCards = knownCards.stream()
                .filter(x -> x.getRarity() == Rarity.NORMAL).toList();

        ArrayList<Card> cardPack = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            double rarityChance = Math.random() * 100;

            if (rarityChance < 2) {
                cardPack.add(legendaryCards.get(ThreadLocalRandom
                        .current().nextInt(legendaryCards.size())));
            } else if (rarityChance < 8) {
                cardPack.add(epicCards.get(ThreadLocalRandom
                        .current().nextInt(epicCards.size())));
            } else if (rarityChance < 16) {
                cardPack.add(rareCards.get(ThreadLocalRandom
                        .current().nextInt(rareCards.size())));
            } else {
                cardPack.add(normalCards.get(ThreadLocalRandom
                        .current().nextInt(normalCards.size())));
            }
        }

        return cardPack;
    }

    /**
     * Reads all properties of a Unit Card
     *
     * @param scanner file scanner
     * @return a new UnitCard
     */
    public static UnitCard readUnitCard(Scanner scanner) {
        Rarity rarity = Rarity.valueOf(scanner.nextLine());

        String[] nameEnergy = scanner.nextLine().split(" - ");
        String name = nameEnergy[0];
        int energy = Integer.parseInt(nameEnergy[1].split(" ")[0]);

        String[] attackDefence = scanner.nextLine().split(" - ");
        int attack = Integer.parseInt(attackDefence[0].split(" ")[0]);
        int defence = Integer.parseInt(attackDefence[1].split(" ")[0]);

        return new UnitCard(rarity, name, energy, attack, defence);
    }

    /**
     * Reads all properties of a Spell Card
     *
     * @param scanner file scanner
     * @return a new SpellCard
     */
    public static SpellCard readSpellCard(Scanner scanner) {
        Rarity rarity = Rarity.valueOf(scanner.nextLine());

        String[] nameEnergyType = scanner.nextLine().split(" - ");
        String name = nameEnergyType[0];
        int energy = Integer.parseInt(nameEnergyType[1].split(" ")[0]);
        String type = nameEnergyType[2];
        String description = scanner.nextLine();

        return new SpellCard(rarity, name, energy, type, description);
    }

    /**
     * Reads all properties of a Weapon Card
     *
     * @param scanner file scanner
     * @return a new WeaponCard
     */
    public static WeaponCard readWeaponCard(Scanner scanner) {
        Rarity rarity = Rarity.valueOf(scanner.nextLine());

        String[] nameEnergy = scanner.nextLine().split(" - ");
        String name = nameEnergy[0];
        int energy = Integer.parseInt(nameEnergy[1].split(" ")[0]);

        String durabilityLine = scanner.nextLine();
        int durability = Integer.parseInt(durabilityLine.split(" ")[0]);

        return new WeaponCard(rarity, name, energy, durability);
    }
}

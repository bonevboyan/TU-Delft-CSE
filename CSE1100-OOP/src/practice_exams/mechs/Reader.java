package practice_exams.mechs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reader {
    /**
     * Parses from scanner and creates a mech list
     * @param scanner to read from
     * @param count of the mechs to read
     * @return the new list of mechs
     */
    public static List<Mech> readMechs(Scanner scanner, int count) {
        List<Mech> mechs = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] mechInfo = (scanner.nextLine().split(" - "));

            String statsLine = scanner.nextLine();
            List<Integer> mechStats = parseStats(statsLine);
            Stats stats = new Stats(mechStats.get(0), mechStats.get(1),
                    mechStats.get(2), mechStats.get(3));

            String elementsLine = scanner.nextLine();
            List<Element> elements = parseElements(elementsLine);

            Mech newMech = new Mech(mechInfo[1], mechInfo[2], Integer.parseInt(mechInfo[3]),
                    stats, elements);

            mechs.add(newMech);
        }

        return mechs;
    }

    /**
     * Parses from scanner and creates an equipment list
     * @param scanner to read from
     * @param count of the equipments to read
     * @return the new list of equipments
     */
    public static List<Equipment> readEquipments(Scanner scanner, int count) {
        List<Equipment> equipments = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] equipmentInfo = (scanner.nextLine().split(" - "));

            String statsLine = scanner.nextLine();
            List<Integer> equipmentStats = parseStats(statsLine);

            String elementsLine = scanner.nextLine();
            List<Element> elements = parseElements(elementsLine);

            Equipment equipment = new Equipment(equipmentInfo[1],
                    equipmentInfo[2].equals("Offensive")
                            ? EquipmentType.OFFENSIVE
                            : EquipmentType.DEFENSIVE,
                    Integer.parseInt(equipmentInfo[3]), equipmentStats.get(0), elements);

            equipments.add(equipment);
        }

        return equipments;
    }

    private static List<Element> parseElements(String line) {
        return line.isEmpty() ? new ArrayList<>() :
                Arrays.stream(line.split(" - "))
                        .map(element -> {
                            String[] tokens = element.split(": ");
                            ElementType type = tokens[0].equals("strength")
                                    ? ElementType.STRENGTH
                                    : ElementType.WEAKNESS;
                            return new Element(tokens[1], type);
                        }).toList();
    }

    private static List<Integer> parseStats(String line) {
        return Arrays.stream(line.split(" - "))
                .map(stat ->
                        Integer.parseInt(stat.chars()
                                .mapToObj(ch -> (char) ch)
                                .filter(Character::isDigit)
                                .map(Object::toString)
                                .collect(Collectors.joining()))).toList();
    }
}

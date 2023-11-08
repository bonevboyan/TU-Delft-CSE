package practice_exams.mechs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    private static String menu = """
            Please make your choice:
            1 – Show all mechs in the system.
            2 – Show player stats & equipment.
            3 – Fight a mech.
            4 – Write current state to file.
            5 – Restore state from file.
            6 – Quit the application.""";

    /**
     * Runs the program
     *
     * @param args of the main method
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a filename:");
        String filename = scanner.nextLine();

        List<Mech> mechs = new ArrayList<>();
        List<Equipment> availableEquipment = new ArrayList<>();

        Stats playerStats = new Stats(3, 1, 30, 3);
        Player player = new Player(playerStats);

        try {
            Scanner fileScanner = new Scanner(new File(filename));

            int numberOfMechs = Integer.parseInt(fileScanner.nextLine());
            mechs.addAll(Reader.readMechs(fileScanner, numberOfMechs));

            int numberOfEquipments = Integer.parseInt(fileScanner.nextLine());
            availableEquipment.addAll(Reader.readEquipments(fileScanner, numberOfEquipments));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int option = 0;

        do {
            System.out.println(menu);
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(mechs.stream().map(Mech::toString)
                            .collect(Collectors.joining()));
                    break;
                case 2:
                    System.out.println(player);
                    break;
                case 3:
                    Mech mechToFight = mechs.get(player.getBattlesWon());
                    System.out.printf("You fight against a %s and...", mechToFight.getName());

                    int lootDropId = player.fightMech(mechs.get(player.getBattlesWon()));
                    if (lootDropId == -1) {
                        System.out.println(" lose. Game over!\n");
                        player = new Player(playerStats);
                    }

                    Equipment newEquipment = availableEquipment.stream()
                            .filter(x -> x.getEquipmentId() == lootDropId).toList().get(0);
                    player.addEquipment(newEquipment);
                    System.out.printf(" win! You get a %s.\n", newEquipment.getName());
                    System.out.printf("You won %d battles!\n", player.getBattlesWon());

                    break;
                case 4:
                    try (PrintWriter printWriter = new PrintWriter("output.txt")) {
                        printWriter.print(String.format("%s\n%d", String.join(" ",
                                player.getEquipmentList().stream()
                                        .map(x -> x.getEquipmentId() + "").toList()),
                                player.getBattlesWon())
                        );
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    player = new Player(playerStats);
                    try {
                        Scanner outputScanner = new Scanner(new File("output.txt"));
                        List<Integer> equipmentIds =  Arrays.stream(outputScanner.nextLine()
                                        .split(" "))
                                .map(Integer::parseInt).toList();

                        List<Equipment> equipmentsToAdd = availableEquipment.stream()
                                .filter(x -> equipmentIds.stream()
                                        .anyMatch(eqId -> x.getEquipmentId() == eqId)).toList();

                        equipmentsToAdd.forEach(player::addEquipment);
                        int wins = outputScanner.nextInt();
                        player.setBattlesWon(wins);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
            }
        } while (option != 6);
    }
}

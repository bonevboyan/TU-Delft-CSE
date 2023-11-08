package practice_exams.mechs;

import java.util.*;
import java.util.stream.Collectors;

public class Player {
    private Stats stats;
    private List<Equipment> equipmentList;
    private int battlesWon;

    /**
     * Creates a player
     *
     * @param stats of the new player
     */
    public Player(Stats stats) {
        this.stats = stats;
        this.equipmentList = new ArrayList<>();
        this.battlesWon = 0;
    }

    /**
     * Add equipment to the equipmentList
     *
     * @param equipment to be added
     */
    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    /**
     * @return the stats of the player
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * @return the won battles of the player
     */
    public int getBattlesWon() {
        return battlesWon;
    }

    /**
     * @param wins to set
     */
    public void setBattlesWon(int wins) {
        this.battlesWon = wins;
    }

    /**
     * @return the equipment list of the player
     */
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    /**
     * Fights a mech
     * @param mech to fight
     * @return lootDrop if player won and -1 otherwise
     */
    public int fightMech(Mech mech) {
        int originalPlayerHealth = stats.getHealthPoints();

        boolean isPlayersTurn = stats.getSpeed() >= mech.getStats().getSpeed();

        while (stats.getHealthPoints() > 0 && mech.getStats().getHealthPoints() > 0) {
            if (isPlayersTurn) {
                playerAttack(mech);
            } else {
                mechAttack(mech);
            }
            isPlayersTurn = !isPlayersTurn;
        }

        if (mech.getStats().getHealthPoints() <= 0) {
            stats.setHealthPoints(originalPlayerHealth);
            battlesWon++;

            return mech.getLootDropId();
        }

        return -1;
    }

    private void mechAttack(Mech mech) {
        int attackPoints = mech.getStats().getAttackPoints();
        int defencePoints = getStats().getDefencePoints();
        int playerHealth = getStats().getHealthPoints();

        List<String> strengths = mech.getStrengths().stream().map(Object::toString).toList();
        List<String> weaknesses = getWeaknesses()
                .stream().map(Object::toString).toList();

        Set<String> intersection = new HashSet<>(weaknesses);
        intersection.retainAll(strengths);

        if (!intersection.isEmpty()) {
            attackPoints *= 2;
        }

        int damageToDeal = attackPoints - defencePoints;

        getStats().setHealthPoints(playerHealth - damageToDeal);
    }

    private void playerAttack(Mech mech) {
        int attackPoints = stats.getAttackPoints();
        int defencePoints = mech.getStats().getDefencePoints();
        int mechHealth = mech.getStats().getHealthPoints();

        List<String> strengths = getStrengths().stream().map(Object::toString).toList();
        List<String> weaknesses = mech.getWeaknesses()
                .stream().map(Object::toString).toList();

        Set<String> intersection = new HashSet<>(strengths);
        intersection.retainAll(weaknesses);

        if (!intersection.isEmpty()) {
            attackPoints *= 2;
        }

        int damageToDeal = attackPoints - defencePoints;

        mech.getStats().setHealthPoints(mechHealth - damageToDeal);
    }

    /**
     * Compares two players
     *
     * @param o player to compare with
     * @return true iff they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(stats, player.stats)
                && Objects.equals(equipmentList, player.equipmentList);
    }

    /**
     * @return hashCode of the player
     */
    @Override
    public int hashCode() {
        return Objects.hash(stats, equipmentList);
    }

    /**
     * @return the player parsed as a String
     */
    @Override
    public String toString() {
        String equipmentString = equipmentList.isEmpty()
                ? "none"
                : equipmentList.stream().map(Object::toString).collect(Collectors.joining());

        return String.format("Player has %s.\nEquipment: %s\n", stats.toString(), equipmentString);
    }

    private List<Element> getStrengths() {
        List<Element> strengths = this.equipmentList.stream()
                .flatMap(x -> x.getStrengths().stream()).toList();

        List<Element> weaknesses = this.equipmentList.stream()
                .flatMap(x -> x.getStrengths().stream()).toList();

        return strengths.stream()
                .filter(strength -> weaknesses.stream()
                        .noneMatch(weakness -> weakness.getName().equals(strength.getName())))
                .toList();
    }

    private List<Element> getWeaknesses() {
        List<Element> strengths = this.equipmentList.stream()
                .flatMap(x -> x.getStrengths().stream()).toList();

        List<Element> weaknesses = this.equipmentList.stream()
                .flatMap(x -> x.getStrengths().stream()).toList();

        return weaknesses.stream()
                .filter(weakness -> strengths.stream()
                        .noneMatch(strength -> strength.getName().equals(weakness.getName())))
                .toList();
    }
}

package practice_exams.mechs;

import java.util.Objects;

public class Stats {
    private int attackPoints;
    private int defencePoints;
    private int healthPoints;
    private int speed;

    /**
     * Creates stats object for party
     * @param attackPoints of the party
     * @param defencePoints of the party
     * @param healthPoints of the party
     * @param speed of the party
     */
    public Stats(int attackPoints, int defencePoints, int healthPoints, int speed) {
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
        this.speed = speed;
    }

    /**
     * @return the health points
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * @param healthPoints to be set
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * @return the attack points
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * @return the defence points
     */
    public int getDefencePoints() {
        return defencePoints;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Compares two stats
     * @param o stats to compare with
     * @return true iff they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return attackPoints == stats.attackPoints && defencePoints == stats.defencePoints
                && healthPoints == stats.healthPoints && speed == stats.speed;
    }

    /**
     * @return the hashCode of the stats
     */
    @Override
    public int hashCode() {
        return Objects.hash(attackPoints, defencePoints, healthPoints, speed);
    }

    /**
     * @return the stats parsed as a String
     */
    @Override
    public String toString() {
        return String.format("%d attack, %d defence, %d health, %d speed",
                attackPoints, defencePoints, healthPoints, speed);
    }
}

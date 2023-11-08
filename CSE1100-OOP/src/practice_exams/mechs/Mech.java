package practice_exams.mechs;

import java.util.List;
import java.util.Objects;

public class Mech {
    private String name;
    private String category;
    private int lootDropId;
    private Stats stats;

    private List<Element> elementList;

    /**
     * Creates a Mech
     * @param name of the new mech
     * @param category of the new mech
     * @param lootDropId of the new mech
     * @param stats of the new mech
     * @param elements of the new mech
     */
    public Mech(String name, String category, int lootDropId, Stats stats, List<Element> elements) {
        this.name = name;
        this.category = category;
        this.lootDropId = lootDropId;

        this.stats = stats;
        this.elementList = elements;
    }

    /**
     * @return the name of the mech
     */
    public String getName() {
        return name;
    }

    /**
     * @return the category of the mech
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the lootdropId of the mech
     */
    public int getLootDropId() {
        return lootDropId;
    }

    /**
     * @return the stats of the mech
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * @return the strengths of the mech
     */
    public List<Element> getStrengths() {
        return this.elementList.stream().filter(x -> x.getType() == ElementType.STRENGTH).toList();
    }

    /**
     * @return the weaknesses of the mech
     */
    public List<Element> getWeaknesses() {
        return this.elementList.stream().filter(x -> x.getType() == ElementType.WEAKNESS).toList();
    }

    /**
     * Compares two mechs
     * @param o mech to compare with
     * @return true iff they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mech mech = (Mech) o;
        return lootDropId == mech.lootDropId && Objects.equals(name, mech.name)
                && Objects.equals(category, mech.category) && Objects.equals(stats, mech.stats)
                && Objects.equals(elementList, mech.elementList);
    }

    /**
     * @return hashCode of the mech
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, category, lootDropId, stats, elementList);
    }

    /**
     * @return the mech parsed as a String
     */
    @Override
    public String toString() {
        return String.format("%s (%s)\nIt has %s.\n%s\n", name, category, stats.toString(),
                Element.elementsString(elementList));
    }
}

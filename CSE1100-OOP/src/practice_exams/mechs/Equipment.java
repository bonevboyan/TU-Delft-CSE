package practice_exams.mechs;

import java.util.List;
import java.util.Objects;

public class Equipment {
    private String name;
    private EquipmentType category;
    private int equipmentId;
    private int bonus;

    private List<Element> elements;

    /**
     * Creates equipment
     * @param name of new equipment
     * @param category of new equipment
     * @param equipmentId of new equipment
     * @param bonus of new equipment
     * @param elements of new equipment
     */
    public Equipment(String name, EquipmentType category, int equipmentId, int bonus,
                     List<Element> elements) {
        this.name = name;
        this.category = category;
        this.equipmentId = equipmentId;
        this.bonus = bonus;
        this.elements = elements;
    }

    /**
     * @return the name of the equipment
     */
    public String getName() {
        return name;
    }

    /**
     * @return the category of the equipment
     */
    public EquipmentType getCategory() {
        return category;
    }

    /**
     * @return the id of the equipment
     */
    public int getEquipmentId() {
        return equipmentId;
    }

    /**
     * @return the strengths of the equipment
     */
    public List<Element> getStrengths() {
        return this.elements.stream().filter(x -> x.getType() == ElementType.STRENGTH).toList();
    }

    /**
     * @return the weaknesses of the equipment
     */
    public List<Element> getWeaknesses() {
        return this.elements.stream().filter(x -> x.getType() == ElementType.WEAKNESS).toList();
    }

    /**
     * Compares two equipments
     * @param o equipment to compare with
     * @return true iff they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return equipmentId == equipment.equipmentId && bonus == equipment.bonus
                && Objects.equals(name, equipment.name) && category == equipment.category
                && Objects.equals(elements, equipment.elements);
    }


    /**
     * @return the hashCode of the element
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, category, equipmentId, bonus, elements);
    }

    /**
     * @return equipment as a string
     */
    @Override
    public String toString() {
        return String.format("%s (%s)\n%s\n",
                name, category,
                Element.elementsString(elements));
    }
}

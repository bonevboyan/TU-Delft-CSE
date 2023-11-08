package practice_exams.mechs;

import java.util.List;
import java.util.Objects;

public class Element {
    private String name;

    private ElementType type;

    /**
     * Creates element
     * @param name of the new element
     * @param type of the new element
     */
    public Element(String name, ElementType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * @return the name of the element
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type of the element
     */
    public ElementType getType() {
        return type;
    }

    /**
     * Parses array of elements into a String
     * @param elements to be parsed
     * @return the parsed String
     */
    public static String elementsString(List<Element> elements) {
        String weaknesses = String.join(", ", elements.stream()
                .filter(x -> x.getType() == ElementType.WEAKNESS)
                .map(Element::getName)
                .toList());

        String strengths = String.join(", ", elements.stream()
                .filter(x -> x.getType() == ElementType.STRENGTH)
                .map(Element::getName)
                .toList());

        return String.format("weakness(es): %s; strength(s): %s",
                weaknesses.isEmpty() ? "none" : weaknesses,
                strengths.isEmpty() ? "none" : strengths);
    }

    /**
     * Compares two elements
     * @param o element to compare with
     * @return true iff they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(name, element.name) && type == element.type;
    }

    /**
     * @return the hashCode of the element
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}

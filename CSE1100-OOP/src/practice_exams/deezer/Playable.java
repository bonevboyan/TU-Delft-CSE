package practice_exams.deezer;

import java.util.Objects;

public abstract class Playable {
    private String name;
    private String length;

    /**
     * Creates a track
     * @param name of the track
     * @param length of the track
     */
    public Playable(String name, String length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @return the track name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the track length
     */
    public String getLength() {
        return length;
    }

    /**
     * Compares this to an object and determines it is the same
     * @param o object to compare with
     * @return true iff same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playable track = (Playable) o;
        return Objects.equals(name, track.name) && Objects.equals(length, track.length);
    }

    /**
     * @return the hashcode of the track
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, length);
    }

    /**
     * @return the playable converted to a String
     */
    @Override
    public String toString() {
        return String.format("%s (%s)", name, length);
    }
}

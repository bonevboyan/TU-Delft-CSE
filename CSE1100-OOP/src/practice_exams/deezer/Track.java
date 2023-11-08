package practice_exams.deezer;

public class Track extends Playable{
    /**
     * Creates a track
     *
     * @param name   of the track
     * @param length of the track
     */
    public Track(String name, String length) {
        super(name, length);
    }

    /**
     * @return the track converted to a String
     */
    @Override
    public String toString() {
        return "Track: " + super.toString();
    }
}

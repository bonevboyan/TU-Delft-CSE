package practice_exams.deezer;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private List<Playable> playables;

    /**
     * Creates a playlist
     * @param playables in the playlist
     */
    public Playlist(List<Playable> playables) {
        this.playables = playables;
    }

    /**
     * @return the playables in the playlist
     */
    public List<Playable> getPlayables() {
        return playables;
    }

    /**
     * Adds a song to the front of the playlist
     * @param newTrack to add
     */
    public void addSongInFront(Track newTrack) {
        playables.add(0, newTrack);
    }

    /**
     * Calculate commercial value of playlist
     * @return the sum of ad prices
     */
    public double commercialValue() {
        return playables.stream().filter(x -> x instanceof Ad)
                .map(x -> (Ad) x).mapToDouble(Ad::getPrice).sum();
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
        Playlist playlist = (Playlist) o;
        return Objects.equals(playables, playlist.playables);
    }

    /**
     * @return the hashcode of the playlist
     */
    @Override
    public int hashCode() {
        return Objects.hash(playables);
    }

    /**
     * @return the playlist converted to a String
     */
    @Override
    public String toString() {
        return String.join("\n", playables.stream().map(Playable::toString).toList());
    }
}

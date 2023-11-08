package practice_exams.deezer;

import java.util.List;
import java.util.Objects;

public class Album {
    private String name;
    private String artistName;
    private int year;

    private List<String> artists;
    private List<Track> tracks;

    /**
     * Creates an album
     * @param name of the album
     * @param artistName of the album
     * @param year of the album
     * @param artists of the album
     * @param tracks of the album
     */
    public Album(String name, String artistName, int year,
                 List<String> artists, List<Track> tracks) {
        this.name = name;
        this.artistName = artistName;
        this.year = year;
        this.artists = artists;
        this.tracks = tracks;
    }

    /**
     * @return the name of the album
     */
    public String getName() {
        return name;
    }

    /**
     * @return the artist of the album
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * @return the artists of the album
     */
    public List<String> getArtists() {
        return artists;
    }

    /**
     * @return the tracks in the album
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /**
     * @return the year of the album
     */
    public int getYear() {
        return year;
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
        Album album = (Album) o;
        return Objects.equals(name, album.name) && Objects.equals(artistName, album.artistName)
                && year == album.year
                && Objects.equals(artists, album.artists) && Objects.equals(tracks, album.tracks);
    }

    /**
     * @return the hashcode of the album
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, artistName, year, artists, tracks);
    }

    /**
     * @return the album converted to a String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Album: %s's %s\n", artistName, name));
        sb.append(String.format("Artists: %s\n", String.join(", ", artists)));

        for (var track :
                tracks) {
            sb.append("\t");
            sb.append(track);
            sb.append("\n");
        }

        return sb.toString();
    }
}

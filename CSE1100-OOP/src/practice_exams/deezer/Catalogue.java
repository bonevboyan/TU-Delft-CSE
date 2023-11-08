package practice_exams.deezer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Catalogue extends Thread {
    private List<Album> albums;
    private List<Ad> ads;

    /**
     * Creates a catalogue
     * @param albums in the catalogue
     * @param ads in the catalogue
     */
    public Catalogue(List<Album> albums, List<Ad> ads) {
        this.albums = albums;
        this.ads = ads;
    }

    /**
     * @return the albums in the catalogue
     */
    public List<Album> getAlbums() {
        return albums;
    }

    /**
     * @param newAdd ad to add
     */
    public void addAd(Ad newAdd) {
        ads.add(newAdd);
    }

    /**
     * Returns the track that matches that name
     * @param name of the search
     * @return the track if found and null if not
     */
    public Track getTrack(String name) {
        List<Track> allTracks = albums.stream().flatMap(x -> x.getTracks().stream()).toList();
        List<Track> matchingTracks =
                allTracks.stream().filter(x -> x.getName().equals(name)).toList();

        if (matchingTracks.isEmpty()) return null;

        return matchingTracks.get(0);
    }

    /**
     * Generates a playlist of 10 songs and 10 ads
     * @return the new playlist
     */
    public Playlist generatePlaylist() {
        List<Playable> playables = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<Track> allTracks = albums.stream().flatMap(x -> x.getTracks().stream()).toList();

            Track randomTrack = allTracks.get(ThreadLocalRandom
                    .current().nextInt(0, allTracks.size()));
            Ad randomAd = ads.get(ThreadLocalRandom.current().nextInt(0, ads.size()));

            playables.add(randomTrack);
            playables.add(randomAd);
        }

        return new Playlist(playables);
    }

    @Override
    public void run() {
        super.run();
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
        Catalogue catalogue = (Catalogue) o;
        return Objects.equals(albums, catalogue.albums) && Objects.equals(ads, catalogue.ads);
    }

    /**
     * @return the hashCode of the catalogue
     */
    @Override
    public int hashCode() {
        return Objects.hash(albums, ads);
    }

    /**
     * @return the catalogue as a String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ALBUMS\n");
        for (var album : albums) {
            sb.append(String.format("ALBUM %s; %s; %d\n", album.getArtistName(),
                    album.getName(), album.getYear()));
            sb.append(String.format("ARTISTS %s\n", String.join("; ", album.getArtists())));

            List<Track> tracks = album.getTracks();
            for (int i = 0; i < tracks.size(); i++) {
                Track track = tracks.get(i);
                sb.append(String.format("TRACK %d; %s; %s\n", i + 1,
                        track.getName(), track.getLength()));
            }
        }

        sb.append("ADS\n");
        for (var ad : ads) {
            String adString = String.format("AD %s; %s; %.2f euros\n",
                    ad.getName(), ad.getLength(), ad.getPrice());
            sb.append(adString.replaceAll(",", "."));
        }

        return sb.toString();
    }
}

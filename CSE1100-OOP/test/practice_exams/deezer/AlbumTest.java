package practice_exams.deezer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumTest {


    @Test
    public void handleAddSongShouldNotAddSongToCatalogueIfNotFound() {
        List<Track> expectedTrackAlbum1 = new ArrayList<>();
        expectedTrackAlbum1.add(new Track("The Miracle", "4:15"));
        List<String> expectedArtistsAlbum1 = new ArrayList<>();
        expectedArtistsAlbum1.add("Larry Mullen Jr.");
        expectedArtistsAlbum1.add("The Edge");
        expectedArtistsAlbum1.add("Bono");
        expectedArtistsAlbum1.add("Adam Clayton");
        Album album = (new Album("Songs of Innocence", "U2", 2014,expectedArtistsAlbum1,  expectedTrackAlbum1));

        String expected = """
                Album: U2's Songs of Innocence
                Artists: Larry Mullen Jr., The Edge, Bono, Adam Clayton
                \tTrack: The Miracle (4:15)
                """;

        assertEquals(expected, album.toString());

    }

    @Test
    public void equalsShouldReturnCorrectResult() {
        List<Track> expectedTrackAlbum1 = new ArrayList<>();
        expectedTrackAlbum1.add(new Track("The Miracle", "4:15"));
        List<String> expectedArtistsAlbum1 = new ArrayList<>();
        expectedArtistsAlbum1.add("Larry Mullen Jr.");
        expectedArtistsAlbum1.add("The Edge");
        expectedArtistsAlbum1.add("Bono");
        expectedArtistsAlbum1.add("Adam Clayton");
        Album album = (new Album("Songs of Innocence", "U2", 2014,expectedArtistsAlbum1,  expectedTrackAlbum1));
        Album album1 = (new Album("Songs of Innocence", "U2", 2014,expectedArtistsAlbum1,  expectedTrackAlbum1));

        assertEquals(album, album1);
    }

    @Test
    public void hashCodeShouldReturnCorrectResult() {
        List<Track> expectedTrackAlbum1 = new ArrayList<>();
        expectedTrackAlbum1.add(new Track("The Miracle", "4:15"));
        List<String> expectedArtistsAlbum1 = new ArrayList<>();
        expectedArtistsAlbum1.add("Larry Mullen Jr.");
        expectedArtistsAlbum1.add("The Edge");
        expectedArtistsAlbum1.add("Bono");
        expectedArtistsAlbum1.add("Adam Clayton");
        Album album = (new Album("Songs of Innocence", "U2", 2014,expectedArtistsAlbum1,  expectedTrackAlbum1));
        Album album1 = (new Album("Songs of Innocence", "U2", 2014,expectedArtistsAlbum1,  expectedTrackAlbum1));

        assertEquals(album.hashCode(), album1.hashCode());
    }
}

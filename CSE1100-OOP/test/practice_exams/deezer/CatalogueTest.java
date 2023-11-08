package practice_exams.deezer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practice_exams.mock_exam.*;
import practice_exams.mock_exam.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CatalogueTest {
    public static String input = """
                ALBUMS
                ALBUM U2; Songs of Innocence; 2014
                ARTISTS Larry Mullen Jr.; The Edge; Bono; Adam Clayton
                TRACK 1; The Miracle; 4:15
                ADS
                AD ING; 0:20; 0.05 euros
                AD Bol.com; 0:15; 0.10 euros
                AD Albert; 0:30; 0.20 euros""";
    public static Catalogue catalogue;

    @BeforeAll
    public static void addCards(){
        Scanner scanner = new Scanner(input);
        scanner.nextLine();

        List<Album> albums = Reader.readAlbum(scanner);
        List<Ad> ads = Reader.readAds(scanner);

        catalogue = new Catalogue(albums, ads);
    }

    @Test
    public void toStringShouldReturnTheSameAsInput() {
        assertEquals(catalogue.toString().trim(), input.trim());
    }

    @Test
    public void generatePlaylistShouldReturnAPlaylistWith10SongsAnd10Ads() {
        List<Playable> playlist = catalogue.generatePlaylist().getPlayables();

        assertEquals(10, playlist.stream().filter(x -> x instanceof Ad).toList().size());
        assertEquals(10, playlist.stream().filter(x -> x instanceof Track).toList().size());

    }

    @Test
    public void getTrackShouldReturnCorrectTrack() {
        Track track = catalogue.getTrack("The Miracle");
        Track expected = new Track("The Miracle", "4:15");

        assertEquals(track, expected);

    }

    @Test
    public void getTrackShouldReturnNullOnIncorretName() {
        Track track = catalogue.getTrack("The Non-Miracle");

        assertNull(track);

    }

    @Test
    public void equalsShouldReturnCorrectResult() {
        Scanner scanner = new Scanner(input);
        scanner.nextLine();
        List<Album> albums = Reader.readAlbum(scanner);
        List<Ad> ads = Reader.readAds(scanner);

        Catalogue catalogue1 = new Catalogue(albums, ads);

        assertEquals(catalogue1, catalogue);
        assertEquals(catalogue1.hashCode(), catalogue.hashCode());
    }
}

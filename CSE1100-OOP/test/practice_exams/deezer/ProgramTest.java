package practice_exams.deezer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {
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
    public static void setUpCatalogue(){
        Scanner scanner = new Scanner(input);
        scanner.nextLine();

        List<Album> albums = Reader.readAlbum(scanner);
        List<Ad> ads = Reader.readAds(scanner);

        catalogue = new Catalogue(albums, ads);
    }

    @Test
    public void handleAddSongShouldAddSongToCatalogue() {
        Playlist playlist = new Playlist(new ArrayList<>());
        Scanner scanner = new Scanner("The Miracle");
        Program.handleAddSong(scanner, catalogue, playlist);

        assertEquals(playlist.getPlayables().get(0).getName(), "The Miracle");
    }

    @Test
    public void handleAddSongShouldNotAddSongToCatalogueIfNotFound() {
        Playlist playlist = new Playlist(new ArrayList<>());
        Scanner scanner = new Scanner("The Not-Miracle");
        Program.handleAddSong(scanner, catalogue, playlist);

        assertEquals(playlist.getPlayables().size(), 0);
    }



    @Test
    public void getAd() {
        Scanner scanner = new Scanner("1 2 3");
        Ad result = Program.getAd(scanner);
        Ad expected = new Ad("1", "2", 3);

        assertEquals(result, expected);
    }
}

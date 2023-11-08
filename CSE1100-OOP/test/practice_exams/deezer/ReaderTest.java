package practice_exams.deezer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import practice_exams.mock_exam.*;
import practice_exams.mock_exam.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    @Test
    public void readAlbumsShouldReturnCorrectAlbums() {
        Scanner scanner = new Scanner("""
                ALBUM U2; Songs of Innocence; 2014
                ARTISTS Larry Mullen Jr.; The Edge; Bono; Adam Clayton
                TRACK 1; The Miracle; 4:15
                ADS""");

        List<Album> albums = Reader.readAlbum(scanner);

        List<Album> expectedAlbums = new ArrayList<>();
        List<Track> expectedTrackAlbum1 = new ArrayList<>();
        expectedTrackAlbum1.add(new Track("The Miracle", "4:15"));
        List<String> expectedArtistsAlbum1 = new ArrayList<>();
        expectedArtistsAlbum1.add("Larry Mullen Jr.");
        expectedArtistsAlbum1.add("The Edge");
        expectedArtistsAlbum1.add("Bono");
        expectedArtistsAlbum1.add("Adam Clayton");
        expectedAlbums.add(new Album("Songs of Innocence", "U2", 2014,expectedArtistsAlbum1,  expectedTrackAlbum1));

        assertEquals(expectedAlbums, albums);
    }

    @Test
    public void readAdsShouldReturnCorrectAds() {
        Scanner scanner = new Scanner("""
                AD ING; 0:20; 0.05 euros
                AD Bol.com; 0:15; 0.10 euros
                AD Albert; 0:30; 0.20 euros""");

        List<Ad> ads = Reader.readAds(scanner);

        List<Ad> expectedAds = new ArrayList<>();
        expectedAds.add(new Ad("ING", "0:20", 0.05));
        expectedAds.add(new Ad("Bol.com", "0:15", 0.05));
        expectedAds.add(new Ad("Albert", "0:30", 0.20));

        assertEquals(expectedAds, ads);
    }
}

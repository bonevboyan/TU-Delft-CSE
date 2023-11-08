package practice_exams.deezer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistTest {
    @Test
    public void commercialValueShouldReturnCorretValue() {
        Ad ad = new Ad("1", "2", 3);
        Ad ad1 = new Ad("1", "2", 4);
        List<Playable> playables = new ArrayList<>();
        playables.add(ad);
        playables.add(ad1);
        Playlist playlist = new Playlist(playables);

        double expected = ad.getPrice() + ad1.getPrice();

        assertEquals(playlist.commercialValue(), expected);

    }

    @Test
    public void addInFrontShouldAddSongInFront() {
        Playlist playlist = new Playlist(new ArrayList<>());

        Track track = new Track("1", "2");
        playlist.addSongInFront(track);

        Track first = (Track) playlist.getPlayables().get(0);

        assertEquals(first, track);

    }



    @Test
    public void toStringShouldReturnCorrectString() {
        Track track = new Track("1", "2");

        Ad ad = new Ad("1", "2", 3);
        Ad ad1 = new Ad("1", "2", 4);
        List<Playable> playables = new ArrayList<>();
        playables.add(ad);
        playables.add(ad1);
        playables.add(track);
        Playlist playlist = new Playlist(playables);
        String expected = """
                AD: 1 (2)
                AD: 1 (2)
                Track: 1 (2)""";

        assertEquals(expected, playlist.toString());

    }
}

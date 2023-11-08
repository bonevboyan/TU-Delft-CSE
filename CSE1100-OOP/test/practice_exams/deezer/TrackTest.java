package practice_exams.deezer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackTest {
    @Test
    public void toStringShouldReturnCorrectString() {
        Track track = new Track("1", "2");
        String expected = "Track: 1 (2)";

        assertEquals(track.toString(), expected);

    }
}

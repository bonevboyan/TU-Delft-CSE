package practice_exams.deezer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdTest {
    @Test
    public void toStringShouldReturnCorrectString() {
        Ad ad = new Ad("1", "2", 3);
        String expected = "AD: 1 (2)";

        assertEquals(ad.toString(), expected);

    }

    @Test
    public void equalsShouldReturnCorrectResult() {
        Ad ad = new Ad("1", "2", 3);
        Ad ad1 = new Ad("1", "2", 3);

        assertEquals(ad, ad1);
    }

    @Test
    public void hashCodeShouldReturnCorrectResult() {
        Ad ad = new Ad("1", "2", 3);
        Ad ad1 = new Ad("1", "2", 3);

        assertEquals(ad.hashCode(), ad1.hashCode());
    }
}

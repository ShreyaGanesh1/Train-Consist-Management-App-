import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

public class MainTest {

    @Test
    void testValidTrainID() {
        assertTrue(Pattern.matches("TRN-\\d{4}", "TRN-1234"));
    }

    @Test
    void testInvalidTrainIDFormat() {
        assertFalse(Pattern.matches("TRN-\\d{4}", "TRAIN12"));
        assertFalse(Pattern.matches("TRN-\\d{4}", "TRN12A"));
        assertFalse(Pattern.matches("TRN-\\d{4}", "1234-TRN"));
    }

    @Test
    void testTrainIDLength() {
        assertFalse(Pattern.matches("TRN-\\d{4}", "TRN-123"));
        assertFalse(Pattern.matches("TRN-\\d{4}", "TRN-12345"));
    }

    @Test
    void testValidCargoCode() {
        assertTrue(Pattern.matches("PET-[A-Z]{2}", "PET-AB"));
    }

    @Test
    void testInvalidCargoCodeFormat() {
        assertFalse(Pattern.matches("PET-[A-Z]{2}", "PET-12"));
        assertFalse(Pattern.matches("PET-[A-Z]{2}", "AB-PET"));
    }

    @Test
    void testCargoCodeUppercaseOnly() {
        assertFalse(Pattern.matches("PET-[A-Z]{2}", "PET-ab"));
        assertFalse(Pattern.matches("PET-[A-Z]{2}", "PET-Ab"));
    }

    @Test
    void testEmptyInput() {
        assertFalse(Pattern.matches("TRN-\\d{4}", ""));
        assertFalse(Pattern.matches("PET-[A-Z]{2}", ""));
    }
}
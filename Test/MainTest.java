import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

public class MainTest {

    private List<Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(222, totalSeats); // 72+56+24+70
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> single = Arrays.asList(
                new Bogie("First Class", 24)
        );

        int totalSeats = single.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(24, totalSeats);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();

        int totalSeats = empty.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, totalSeats);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        int originalSize = bogies.size();

        bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
    }
}
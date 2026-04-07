import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

public class BogieTest {

    private List<Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypesCount() {
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, grouped.size()); // Sleeper, AC Chair, First Class
    }

    @Test
    void testGrouping_EmptyList() {
        List<Bogie> emptyList = Collections.emptyList();

        Map<String, List<Bogie>> grouped = emptyList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        int originalSize = bogies.size();

        bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(originalSize, bogies.size());
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HashMapChallengesTest {

    @Test
    @DisplayName("should return the first repeated character on a collection")
    void findFirstRecurring() {
        String[] elements = new String[]{"e", "d", "u", "a", "r", "d", "a"};

        Assertions.assertEquals(HashMapChallenges.findFirstRecurringOn(elements), "d");
    }

    @Test
    @DisplayName("should return empty if no duplicated character exist on a collection")
    void findFirstRecurring_empty() {
        String[] elements = new String[]{"e", "d", "u"};

        Assertions.assertEquals(HashMapChallenges.findFirstRecurringOn(elements), "");
    }
}
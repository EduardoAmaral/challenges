import java.util.HashSet;
import java.util.Set;

public class HashMapChallenges {

    public static String findFirstRecurringOn(String[] elements) {
        final Set<String> characters = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            if (!characters.add(elements[i])) {
                return elements[i];
            }
        }

        return "";
    }
}

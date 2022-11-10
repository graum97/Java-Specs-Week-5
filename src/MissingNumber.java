import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {
    public static int missingNumber(int[] numbers, int maxNum) {
        Set<Integer> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i++) {
            if (!set.contains(i)){
                return i;
            }
        }

        return 0;
    }
}

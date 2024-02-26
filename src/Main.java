import java.util.*;
public class Main {
    public static void main(String[] args) {
        //1
        List<Integer> list = new ArrayList<>(List.of(1, 2, 2, 3, 3, 4, 5));
        Collection<?> uniqueValues = unique(list);
        System.out.println("Unique values: " + uniqueValues);

        //2
        System.out.println(checkConcatenation(List.of("aa", "bb", "cc", "dd"), "aadd")); // true
        System.out.println(checkConcatenation(List.of("bb", "cc", "aa", "dd"), "ddcc")); // true
        System.out.println(checkConcatenation(List.of("aa", "aa", "aa", "aa"), "aaaaa")); // false
        System.out.println(checkConcatenation(List.of("bb", "aa", "aa", "bb"), "aabbaa")); // false
        System.out.println(checkConcatenation(List.of("a", "aab", "aabb", "ba", "aa"), "aabba")); // true

        //3
        System.out.println(maxLength(List.of(1L, 2L, 3L, 4L, 5L, 1L, 1L, 1L, 1L, 1L), 11)); // 6
        System.out.println(maxLength(new ArrayList<Long>(), 2)); // 0
        System.out.println(maxLength(List.of(5L, 7L, 12L, 6L, 4L), 4)); // 0
        System.out.println(maxLength(List.of(5L, 7L, 12L, 6L, 4L), 5)); // 1
        System.out.println(maxLength(List.of(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L), 10)); // 9
        System.out.println(maxLength(List.of(2L, 1L, 1L, 2L, 1L, 3L, 1L, 1L, 1L), 10)); // 6
    }

    //1
    public static Collection<?> unique(Collection<?> inputCollection) {
        Set<Object> uniqueValues = new HashSet<>(inputCollection);
        return uniqueValues;
    }

    //2
    public static boolean checkConcatenation(List<String> chunks, String key) {
        Set<String> set = new HashSet<>(chunks);
        for (String chunk : set) {
            String complement = key.substring(chunk.length());
            if (set.contains(complement)) {
                return true;
            }
        }
        return false;
    }

    //3
    public static long maxLength(List<Long> numbers, long P) {
        long maxLength = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < numbers.size(); right++) {
            sum += numbers.get(right);
            while (sum >= P) {
                sum -= numbers.get(left);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
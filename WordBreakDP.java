import java.util.*;

public class WordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // for quick lookup
        Map<Integer, Boolean> memo = new HashMap<>(); // memoization map

        return canBreak(0, s, wordSet, memo);
    }

    private boolean canBreak(int start, String s, Set<String> wordSet, Map<Integer, Boolean> memo) {
        // Base case: if we reached the end of the string
        if (start == s.length()) {
            return true;
        }

        // If result already computed
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        // Try every possible split
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix) && canBreak(end, s, wordSet, memo)) {
                memo.put(start, true);
                return true;
            }
        }

        // No valid segmentation found
        memo.put(start, false);
        return false;
    }

    // Test the implementation
    public static void main(String[] args) {
        WordBreakDP solver = new WordBreakDP();
        List<String> dict = Arrays.asList("apple", "pen");
        String s = "applepenapple";

        System.out.println(solver.wordBreak(s, dict)); // Output: true
    }
}

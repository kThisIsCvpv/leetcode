package medium.longest_palindromic_substring;

public class Solution {

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0)
            return s;

        int best_len = -1;
        int[] best = null;

        for (int i = 0; i < arr.length; i++) {
            char current_char = arr[i];
            int last_match = s.lastIndexOf(current_char);
            while (last_match != i) {
                if (isPalindromic(arr, i, last_match + 1)) {
                    int len = last_match - i + 1;
                    if (len > best_len) {
                        best_len = len;
                        best = new int[] { i, last_match };
                    }
                }

                last_match = s.lastIndexOf(current_char, last_match - 1);
            }
        }

        return best == null ? Character.toString(arr[0]) : s.substring(best[0], best[1] + 1);
    }

    public boolean isPalindromic(char[] arr, int start, int end) {
        int half = (end - start) / 2;

        for (int i = 0; i < half; i++) {
            if (arr[start + i] != arr[end - 1 - i])
                return false;
        }

        return true;
    }
}

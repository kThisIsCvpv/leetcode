package medium.longest_substring_without_repeating_characters;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] vals = new int[s.length()];

        if(vals.length == 0)
            return 0;
        
        for (int i = 0; i < vals.length; i++) {
            char loc = s.charAt(i);
            int next = s.indexOf(loc, i + 1);
            vals[i] = next != -1 ? next - i : -1;
        }

        int max = 1;

        for (int i = 0; i < vals.length; i++) {
            int left = vals.length - i;
            if(max >= left)
                break;
            
            int count = 0;
            int remaining = vals[i];

            while (remaining > 0 || remaining == -1) {
                count++;

                int index = i + count;
                if (index >= vals.length)
                    break;

                int next = vals[index];
                if ((next != -1 && next < remaining) || remaining == -1)
                    remaining = next;
                else if (remaining != -1)
                    remaining--;
            }

            if (count > max)
                max = count;
        }
        
        return max;
    }
}

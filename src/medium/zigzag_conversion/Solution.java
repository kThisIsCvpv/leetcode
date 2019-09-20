package medium.zigzag_conversion;

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;

        int sector_size = 2 * (numRows - 1);

        char[] arr = s.toCharArray();

        if (arr.length == 0)
            return s;

        int sector_count = (arr.length / sector_size) + 1;

        String val = "";

        for (int i = 0; i < sector_count; i++) {
            int index = i * sector_size;
            if (index < arr.length)
                val += arr[index];
        }

        int mid_count = (sector_size - 2) / 2;
        for (int j = 0; j < mid_count; j++) {
            for (int i = 0; i < sector_count; i++) {
                int index_a = (i * sector_size) + 1 + j;
                int index_b = ((i + 1) * sector_size) - 1 - j;
                for (int index : new int[] { index_a, index_b }) {
                    if (index < arr.length)
                        val += arr[index];
                }
            }
        }

        for (int i = 0; i < sector_count; i++) {
            int index = (i * sector_size) + (numRows - 1);
            if (index < arr.length)
                val += arr[index];
        }

        return val;
    }
}

package easy.reverse_integer;

public class Solution {

    public int reverse(int x) {
        try {
            boolean neg = x < 0;
            x = Math.abs(x);

            char[] arr = Integer.toString(x).toCharArray();
            String newInt = "";
            for (int i = arr.length - 1; i >= 0; i--)
                newInt += arr[i];

            return (neg ? -1 : 1) * Integer.parseInt(newInt);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
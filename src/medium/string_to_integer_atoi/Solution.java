package medium.string_to_integer_atoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public int myAtoi(String str) {
        String val = str.trim();

        Pattern pattern = Pattern.compile("[\\+\\-]{0,1}[0-9]+");
        Matcher m = pattern.matcher(val);
        if (m.find()) {
            if (m.start() == 0) {
                val = m.group();

                int multiplier = 1;
                if (val.startsWith("-")) {
                    val = val.substring(1);
                    multiplier = -1;
                } else if (val.startsWith("+")) {
                    val = val.substring(1);
                }

                try {
                    int num = Integer.parseInt(val) * multiplier;
                    return num;
                } catch (Exception ex) {
                    return multiplier == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
        }

        return 0;

    }
}

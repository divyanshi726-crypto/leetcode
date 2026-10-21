
class Solution {
    public int myAtoi(String s) {
        // Step 1: Remove leading whitespace
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        
        int sign = 1;
        int start = 0;
        
        // Step 2: Determine the sign
        char firstChar = s.charAt(0);
        if (firstChar == '-') {
            sign = -1;
            start = 1;
        } else if (firstChar == '+') {
            start = 1;
        }
        
        long result = 0; // Using long to easily check for 32-bit integer overflow
        
        // Step 3: Read digits and convert
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            
            result = result * 10 + (c - '0');
            
            // Step 4: Handle 32-bit signed integer clamping during accumulation (optional optimization)
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        
        return (int) (result * sign);
    }
}
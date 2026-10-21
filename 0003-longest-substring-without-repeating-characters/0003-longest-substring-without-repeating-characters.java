

        
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[128];
            int length = 0;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (seen[ch]) {
                    break;
                }

                seen[ch] = true;
                length++;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}

        

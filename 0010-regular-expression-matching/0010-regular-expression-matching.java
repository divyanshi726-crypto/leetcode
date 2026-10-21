
class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p, memo);
    }
    
    private boolean dp(int i, int j, String s, String p, Boolean[][] memo) {
        // Agar pattern khatam ho gaya, toh check karo ki string bhi khatam hui ya nahi
        if (j == p.length()) {
            return i == s.length();
        }
        
        // Agar already calculated hai, toh memoized result return karo
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        // Check karo ki current characters match karte hain ya nahi
        boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
        
        boolean ans;
        // Agar next character '*' hai
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Do choices hain:
            // 1. '*' ko zero times use karo (p mein 2 steps aage badho: j + 2)
            // 2. Ya agar first match hota hai, toh '*' ko use karke string mein aage badho (i + 1)
            ans = dp(i, j + 2, s, p, memo) || (firstMatch && dp(i + 1, j, s, p, memo));
        } else {
            // Agar '*' nahi hai, toh simply dono ko ek-ek step aage badhao
            ans = firstMatch && dp(i + 1, j + 1, s, p, memo);
        }
        
        return memo[i][j] = ans;
    }
}
class Solution {
    public int minChanges(String s) {
       int ans = 0;
        // Check characters in pairs by iterating through odd indices
        for (int i = 1; i < s.length(); i += 2) {
            // If the characters in the current pair don't match, 1 change is required
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans++;
            }
        }
        return ans; 
    }
}
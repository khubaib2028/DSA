class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder nextRound = new StringBuilder();
            
            // Iterate through the string in chunks of size k
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                // Sum digits within the current chunk, ensuring we don't go out of bounds
                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    sum += s.charAt(j) - '0';
                }
                nextRound.append(sum);
            }
            
            s = nextRound.toString();
        }
        
        return s;
    }
    
}
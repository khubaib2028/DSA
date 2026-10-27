class Solution {
    public int findCenter(int[][] edges) {
        int firstA = edges[0][0];
        int firstB = edges[0][1];
        int secondA = edges[1][0];
        int secondB = edges[1][1];
        if (firstA == secondA || firstA == secondB) {
            return firstA;
        }
        
        return firstB;
    }
}
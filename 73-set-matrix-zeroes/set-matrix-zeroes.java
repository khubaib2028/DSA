class Solution {
    public void setZeroes(int[][] matrix) {
       int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isCol = false; // Flag to indicate if the first column itself needs to be zeroed
        
        // Step 1: Traverse the matrix and use the first row/column as markers
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the corresponding row marker
                    matrix[0][j] = 0; // Mark the corresponding column marker
                }
            }
        }
        
        // Step 2: Iterate through the inner matrix (excluding first row/col) and set zeros
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Step 3: Handle the first row separately using matrix[0][0]
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Step 4: Handle the first column separately using the `isCol` flag
        if (isCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        } 
    }
}
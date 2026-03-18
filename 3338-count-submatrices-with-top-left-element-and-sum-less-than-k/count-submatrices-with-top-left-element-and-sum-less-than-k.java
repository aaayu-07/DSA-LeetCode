class Solution {
    public int countSubmatrices(int[][] matrix, int limit) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = 0;
        int[][] sum = new int[rows + 1][cols + 1];

        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                sum[r][c] = matrix[r - 1][c - 1]
                        + sum[r - 1][c]
                        + sum[r][c - 1]
                        - sum[r - 1][c - 1];
            }
        }

        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                if (sum[r][c] <= limit) result++;
            }
        }

        return result;
    }
}
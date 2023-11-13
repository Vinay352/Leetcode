class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int length = original.length;
        if(length != m * n){
            return new int[0][0];
        }

        int[][] answer = new int[m][n];

        int row = 0;
        int col = 0;

        int nextMultipleToCheck = n;
        int increment = 0;
        for(int i = 0; i < length; i++){
            answer[col][row] = original[i];
            row++;

            if(i == nextMultipleToCheck - 1){
                increment = 1;
            }

            if(increment == 1){
                row = 0;
                col++;
                nextMultipleToCheck = nextMultipleToCheck + n;
                increment = 0;
            }
        }
        return answer;
    }
}
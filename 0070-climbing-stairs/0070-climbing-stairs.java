class Solution {
    public int climbStairs(int n) {
        int previousToPrevious = 1;
        int immediatePrevious = 2;

        if(n == 1){
            return previousToPrevious;
        }
        if(n == 2){
            return immediatePrevious;
        }

        int answer = 0;
        for(int i = 3; i <= n; i++){
            answer = immediatePrevious + previousToPrevious;
            previousToPrevious = immediatePrevious;
            immediatePrevious = answer;
        }

        return answer;
    }
}
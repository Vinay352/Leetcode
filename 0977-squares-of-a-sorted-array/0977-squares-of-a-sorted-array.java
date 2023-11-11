class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;

        int firstNonZeroIndex = length;
        for(int i = 0; i < length; i++){
            if(nums[i] >= 0){
                firstNonZeroIndex = i;
                break;
            }
        }

//        int negativeElementsPointer = (firstNonZeroIndex == 0) ? -1 : firstNonZeroIndex - 1;
        int negativeElementsPointer = (firstNonZeroIndex == length) ? length - 1 : ((firstNonZeroIndex == 0) ? -1 : firstNonZeroIndex - 1);

        int breakOutFlag = 0;
        int[] squares = new int[length];

        int squaresIndex = 0;
        while(negativeElementsPointer >= 0 && firstNonZeroIndex < length){
            int negativeValue = Math.abs( nums[negativeElementsPointer] );
            int nonZeroValue = nums[firstNonZeroIndex];
            if( negativeValue < nonZeroValue ){
                squares[squaresIndex] = negativeValue * negativeValue;
                negativeElementsPointer--;
                squaresIndex++;
            }
            else if( negativeValue > nonZeroValue ){
                squares[squaresIndex] = nonZeroValue * nonZeroValue;
                firstNonZeroIndex++;
                squaresIndex++;
            }
            else if(negativeValue == nonZeroValue){
                squares[squaresIndex] = nonZeroValue * nonZeroValue;
                firstNonZeroIndex++;
                squaresIndex++;

                squares[squaresIndex] = negativeValue * negativeValue;
                negativeElementsPointer--;
                squaresIndex++;
            }
        }

        while(negativeElementsPointer >= 0){
            squares[squaresIndex] = nums[negativeElementsPointer] * nums[negativeElementsPointer];
            squaresIndex++;
            negativeElementsPointer--;
        }

        while(firstNonZeroIndex < length){
            squares[squaresIndex] = nums[firstNonZeroIndex] * nums[firstNonZeroIndex];
            squaresIndex++;
            firstNonZeroIndex++;
        }

        return squares;
    }
}
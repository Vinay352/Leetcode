class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        if(arr.length == 0){
            return ' ';
        }

        if(target < arr[0] || target >= arr[arr.length-1]){
            return arr[0];
        }

        return binarySearchCharUtil(arr, target, 0 , arr.length - 1);
    }
    
    private static char binarySearchCharUtil(char[] letters, char target, int left, int right) {


        while(left < right - 1){
            int middle = left + (int)((right - left) / 2);
            if(letters[middle] <= target){
                left = middle;
            }
            else{
                right = middle;
            }
        }

        return letters[right];

    }
}
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


        while(left <= right){
            // exit the loop when left == right, basically when you have one element or the matching or "just less than" element w.r.t target

            int middle = left + (int)((right - left) / 2);
            if(letters[middle] <= target){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }

        return letters[right + 1];
        // your aim is to output the smallest character that is greater than target
        // at "right" index you have matching or "just less than" element w.r.t target
        // therefore, (right + 1) index element will give you the immediately greater character than target


    }
}
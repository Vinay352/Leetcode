class Solution {
    // Moore's voting algorithm
    public int majorityElement(int[] nums) {
        int count = 0; // count of the candidate which occurs moer than floor(n / 2) times
        int candidate = nums[0]; // the candidate with the max count as compared to others or count > floor(n / 2)
        for(int i = 0; i < nums.length; i++){
            if(count == 0){ // if count is zero, assign the candidate to current array value
                candidate = nums[i];
            }

            if(candidate == nums[i]){ // if nums[i] matches the candidate, increment the count
                count++;
            }
            else{ // if it doesn't match, decrement count
                count--;
            }
        }
        // System.out.println(count);
        
        return candidate;
    }
}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            int goToIndex = Math.abs(nums[i]) - 1;

            nums[goToIndex] = Math.abs( nums[goToIndex] ) * (-1);
        }

        for(int i = 0; i< n; i++){
            if(nums[i] > 0){
                answer.add(i + 1); // means you didn't encounter (i + 1 number)
            }
        }

        return answer;
    }
}
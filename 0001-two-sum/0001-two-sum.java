class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        List<PairValueIndex> newList = new ArrayList<PairValueIndex>();

        for(int i = 0; i < length; i++){
            newList.add(new PairValueIndex(nums[i], i));
        }

        Collections.sort(newList, new Comparator<PairValueIndex>() {
            @Override
            public int compare(PairValueIndex o1, PairValueIndex o2) {
                return (o1.value - o2.value);
            }
        });

        Arrays.sort(nums);

        int firstPointer = 0;
        int secondPointer = length - 1;

        while (firstPointer < secondPointer) {
            int firstValue = nums[firstPointer];
            int secondValue = nums[secondPointer];
            int sum = firstValue + secondValue;
            if(sum < target){
                firstPointer++;
            }
            else if(sum > target){
                secondPointer--;
            }
            else if(sum == target){
                break;
            }
        }

        int firstIndex = newList.get(firstPointer).index;
        int secondIndex = newList.get(secondPointer).index;

        int[] answerIndices = {firstIndex, secondIndex};
        return answerIndices;
    }
}

class PairValueIndex{
    int value;
    int index;
    PairValueIndex(int value, int index){
        this.value = value;
        this.index = index;
    }
}
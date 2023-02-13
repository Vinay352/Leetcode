import java.io.BufferedReader;
import java.io.InputStreamReader;

class NumArray {

    int[] numArray = null;
    int[] consecutiveSumStore = null;

    public NumArray(int[] nums) {
        this.numArray = new int[nums.length];
        this.consecutiveSumStore = new int[nums.length];
        numArray = nums.clone();

        for(int i = 0; i < numArray.length; i++){
            consecutiveSumStore[i] = 0;

            if(i > 0){
                consecutiveSumStore[i] += numArray[i] + consecutiveSumStore[i - 1];
            }
            else if(i == 0){
                consecutiveSumStore[i] += numArray[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        int answer = this.consecutiveSumStore[right];
        if(left - 1 >= 0){
            answer -= this.consecutiveSumStore[left - 1];
        }
        return answer;
    }
}

public class RangeSumQuery_Immutable {
    public static void main(String[] args) {
        boolean flag = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(flag){
                String str = br.readLine();
                if (str == "") {
                    flag = false;
                    break;
                }
                String[] strArray = str.split(" ");
                int[] nums = new int[strArray.length];

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = Integer.parseInt(strArray[i]);
                }

                str = br.readLine();
                String[] temp = str.split(" ");
                int start = Integer.parseInt(temp[0]);
                int end = Integer.parseInt(temp[1]);

//                int nums = Integer.parseInt(str);

                // -2 0 3 -5 2 -1
                NumArray numArray = new NumArray(nums);
                int answer = numArray.sumRange(start,end);

                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

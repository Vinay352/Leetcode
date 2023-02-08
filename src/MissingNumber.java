import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(flag){
                String str = br.readLine();
                if (str == "") {
                    flag = false;
//                    break;
                }
                String[] strArray = str.split(" ");
                int[] nums = new int[strArray.length];

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = Integer.parseInt(strArray[i]);
                }

                int answer = missingNumber(nums);
                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    private static int missingNumber(int[] nums) {
        int approach1 = countSortAppraoch(nums); // O(n)

        int approach2 = sumOfNNumbers(nums);

        int approach3 = xorOperator(nums);

        return approach3;
    }

    private static int xorOperator(int[] nums) {
        int xor = 0;

        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }

        for(int i = 0; i <= nums.length; i++){
            xor ^= i;
        }

        return xor;

    }

    private static int sumOfNNumbers(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        int n = nums.length;
        int correctSum = n * (n + 1) / 2;

        return correctSum - sum;
    }

    private static int countSortAppraoch(int[] nums) {
        int[] countSort = new int[nums.length + 1];
        for(int i = 0; i < countSort.length; i++){
            countSort[i] = -1;
        }

        for(int i = 0; i < nums.length; i++){
            countSort[nums[i]] = 1;
        }

        for(int i = 0; i < countSort.length; i++){
            if(countSort[i] == -1){
                return i;
            }
        }
        return -1;
    }
}

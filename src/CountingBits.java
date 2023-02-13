import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountingBits {
    public static void main(String[] args) {
        boolean flag = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(flag){
                String str = br.readLine();
                if (str == "") {
                    flag = false;
                    break;
                }
//                String[] strArray = str.split(" ");
//                int[] nums = new int[strArray.length];
//
//                for (int i = 0; i < nums.length; i++) {
//                    nums[i] = Integer.parseInt(strArray[i]);
//                }

                int nums = Integer.parseInt(str);
                int[] answer = countingBits(nums);

//                int answer = bestTimeToButAndSellStock(nums);

                printArray(answer);

//                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    private static int[] countingBits(int nums) {
//        int[] appraoch1 = closestPowerOf2(nums); // nlogn

        int[] approach2 = singlePass(nums); // n

        return approach2;
    }

    private static int[] singlePass(int nums) {
        int start = 0;
        int count = 2;

        int[] dp = new int[nums + 1];
        dp[0] = 0;
        if(nums > 0){
            dp[1] = 1;
        }

        int flag = 0;
        while(true){
            start = count;
            for(int i = start; i < count*2; i++){
                if(i <= nums){
                    dp[i] = 1 + dp[i - count];
                }
                else{
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            count *= 2;
        }
        return dp;
    }

    private static int[] closestPowerOf2(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        if(num > 0){
            dp[1] = 1;
        }

        for(int i = 2; i <= num; i++){
            double log2Value = calculateLogBase2(i);

            if(log2Value != Math.floor(log2Value)){
                dp[i] = 1 + dp[i - (int) Math.pow(2, (int)(Math.floor(log2Value)))];
            }
            else{
                dp[i] = 1;
            }
        }

        return dp;
    }

    private static double calculateLogBase2(int i) {
        return (Math.log(i) / Math.log(2));
    }

    private static void printArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

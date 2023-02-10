import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClimbingStairs {

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

                int answer = climbStairs(nums);
                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        if(dp.length > 2)
            dp[2] = 2;

        for(int i = 3; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

}

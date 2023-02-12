import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BestTimeToBuyAndSellStock {
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

//                int nums = Integer.parseInt(str);

                int answer = bestTimeToButAndSellStock(nums);
                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    private static int bestTimeToButAndSellStock(int[] nums) {

        int approach1 = CompareAllElements(nums); // O(n^2)

        int approach2 = greedyAlgo(nums);

        return approach2;

    }

    private static int greedyAlgo(int[] nums) {

        int profit = 0;
        int lowest = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < lowest){
                lowest = nums[i];
            }
            if(nums[i] - lowest > profit){
                profit = nums[i] - lowest;
            }
        }
        return profit;

    }

    private static int CompareAllElements(int[] nums) {

        int profit = 0;

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] - nums[i] > profit){
                    profit = nums[j] - nums[i];
                }
            }
        }

        return profit;

    }
}

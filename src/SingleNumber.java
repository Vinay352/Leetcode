import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SingleNumber {

    public static void main(String[] args) {
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

                int answer = singleNumber(nums);
                System.out.println(answer);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }


    public static int singleNumber(int[] nums) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp ^= nums[i];
        }
        return temp;
    }
}

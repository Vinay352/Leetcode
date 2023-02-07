import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsDuplicates {

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        while(flag){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                String str = br.readLine();
                if(str == ""){
                    break;
                }
                String[] strArray = str.split(" ");
                int [] nums = new int[strArray.length];

                for(int i = 0; i < nums.length; i++){
                    nums[i] = Integer.parseInt( strArray[i] );
                }

                boolean answer = containsDuplicate(nums);




            }catch (Exception e){
                System.out.println("Exception");
            }
        }
    }

    public static boolean containsDuplicate(int[] nums) {

        boolean approach1 = n2Approach(nums);

        boolean approach2 = sortAndCheckAdjacent(nums); // O(nlogn) + O(n)

    }

    public static int[] mergeSort(int[] nums, int left, int right){
        int mid = left + (right - left)/2;
        int[] left = 
    }

    private static boolean sortAndCheckAdjacent(int[] nums) {
        int[] arr = mergeSort(nums, 0, nums.length - 1);
    }

    private static boolean n2Approach(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

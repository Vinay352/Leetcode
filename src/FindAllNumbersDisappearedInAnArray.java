import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
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

//                printArray(nums);

                List<Integer> answer = findDisappearedNumbers(nums); // 4 3 2 7 8 2 3 1
                System.out.println(answer);
//                System.out.println("VINAY");
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> approach1 = sortAndLinearSearch(nums); // nlogn + n
//        return approach1;

        List<Integer> approach2 = sortAndCountSort(nums);
        return approach2;

    }

    private static List<Integer> sortAndCountSort(int[] nums) {

        Arrays.sort(nums);

        int[] countSort = new int[nums.length + 1];

        for(int i = 0; i < countSort.length; i++){
            countSort[i] = 0;
        }

        countSort[0] = 1;

        for(int i = 0; i < nums.length; i++){
            countSort[ nums[i] ] = 1;
        }

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < countSort.length; i++){
            if(countSort[i] != 1){
                answer.add(i);
            }
        }
        return answer;
    }

    private static List<Integer> sortAndLinearSearch(int[] nums) {
        Arrays.sort(nums);
//        printArray(nums);

        List<Integer> answer = new ArrayList<>();
        Set<Integer> setAnswer = new HashSet<>();

        int previous = nums[0];

        for(int i = 1; i < nums[0]; i++){
            setAnswer.add(i);
        }

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                if(nums[i] != nums[i + 1] - 1){
                    int k = nums[i] + 1;
                    while(k != nums[i + 1]){
                        setAnswer.add(k);
                        k++;
                    }
                }
            }
        }

        for(int i = nums[nums.length - 1] + 1; i <= nums.length; i++){
            setAnswer.add(i);
        }

        for(int element : setAnswer){
            answer.add(element);
        }

        return answer;
    }

    private static void printArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}

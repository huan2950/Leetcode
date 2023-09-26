package exam.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            int num = in.nextInt();
            set.add(num);
        }    
        Integer[] nums = set.toArray(new Integer[set.size()]);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}

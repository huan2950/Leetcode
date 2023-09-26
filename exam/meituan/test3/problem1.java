package exam.meituan.test3;

import java.util.HashMap;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt() - k;
        }
    
        int res = 0;
        HashMap<Integer, Integer> occ = new HashMap<>();
        occ.put(0, -1);
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += nums[i];
            if (occ.containsKey(tmp)) {
                res = Math.max(res, i - occ.get(tmp));
            }
            if (!occ.containsKey(tmp)) {
                occ.put(tmp, i);
            }
        }
        System.out.println(res);
    }
}

package exam.tencent;

import java.util.Arrays;

public class problem4 {
    public int minOperations (String str) {
        // write code here
        int n = str.length();
        char[] s0 = new char[n];
        char[] s1 = new char[n];
        Arrays.fill(s0, '0');
        Arrays.fill(s1, '1');
        int res0 = 0;
        int res1 = 0;
        int i = 0;
        int j =0;
        while(i < n || j < n){
            if (i < n && str.charAt(i) != s0[i]){
                res0++;
                i += 2;
                j += 1;
            }else if (j < n ){
                res1++;
                i += 1;
                j += 2;
            }
        }
        return Math.min(res0, res1);
    }
}

package exam.tencent;

import java.util.ArrayList;

public class problem5 {
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
        int n = a.size();
        int l = 0, r = 0;
        int count2 = 0,count5 = 0;
        int res = 0;
        while (r < n){
            while (Math.min(count2, count5) < x){
                count2 += compute(a.get(r), 2);
                count5 += compute(a.get(r), 5);
                r++;
            }

            res += n - r + 1;

            while (Math.min(count2, count5) >= x){
                count2 -= compute(a.get(l), 2);
                count5 -= compute(a.get(l), 5);
                l++;
            }
        }
        return res % 1000000007;
    }

    public int compute(int num, int x){
        int res = 0;
        while (num % x == 0){
            res++;
            num /= x;
        }
        return res;
    }
}

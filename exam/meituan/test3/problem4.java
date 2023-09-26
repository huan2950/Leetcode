package exam.meituan.test3;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }  
        Arrays.sort(nums);
        // long res = 0;
        // long product = 1;
        // long sum = 0;
        BigInteger res = BigInteger.valueOf(0);
        BigInteger product = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);
        k = Math.min(n,k);
        for (int i = n - 1; i >= n - k - 1; i--){
            // product *= nums[i];
            product = product.multiply(BigInteger.valueOf(nums[i]));
        }
        for (int i = 0; i < n - k - 1; i++){
            // sum += nums[i];
            sum = sum.add(BigInteger.valueOf(nums[i]));
        }
        // res = product + sum + k; 
        res = res.add(product).add(sum).add(BigInteger.valueOf(k));
        // System.out.println(res % 1000000007);
        System.out.println(res.mod(BigInteger.valueOf(1000000007)));
    }
}

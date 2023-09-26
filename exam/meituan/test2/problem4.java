package exam.meituan.test2;

import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++){
            long m = in.nextLong();
            long x = in.nextLong();
            if (x <= m){
                System.out.println(x);
            }else{
                if (x % m == 0){
                    System.out.println(m);
                }else 
                System.out.println(x%m);
            }
        }
    }
}

package exam.meituan.test3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int zero = 0;
        Set<Integer> oneSet = new HashSet<>();
        for (int i = 0; i < m; i++){
            int t = in.nextInt();
            int num = in.nextInt();
            if (t == 1){
                if (num == zero){
                    System.out.println(i + 1);
                    return;
                }
                oneSet.add(num);
                if (oneSet.size() == n){
                    System.out.println(i + 1);
                    return;
                }
            }else {
                if (zero != 0 && num != zero || oneSet.contains(num)){
                    System.out.println(i + 1);
                    return;
                }
                zero = num;
            }
        }
        System.out.println(-1);
    }
}

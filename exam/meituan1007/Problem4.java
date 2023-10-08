package exam.meituan1007;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Set<Integer>> list = new ArrayList<>();// list存储set集合
        for (int i = 0; i < n; i++){
            Set<Integer> set = new HashSet<>();
            int m = in.nextInt();
            while (--m >= 0){
                set.add(in.nextInt());
            }
            list.add(set);
        }
        double sum = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                Set<Integer> mergeSet = new HashSet<>(list.get(i));
                mergeSet.addAll(list.get(j));
                sum += mergeSet.size();
            }
        }
        double num = 0.5 * n * (n-1);
        System.out.printf("%.11f",sum / num);
    }
}

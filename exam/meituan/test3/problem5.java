package exam.meituan.test3;

import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int count = 0;
        int day = 0;
        while (count < z){
            day++;
            count += x;
            if (day % 3 == 1){
                count += y;
            }
        }
        System.out.println(day);
    }
}

package exam.meituan1007;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String num = in.nextLine();
        int maxValue = 0;
        for (int i = 0; i < num.length(); i++){
            maxValue = Math.max(maxValue,num.charAt(i) - '0'); 
        }
        System.out.println(maxValue);
    }
}

package exam.huawei;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            int sum = 0;
            for (int i = 2; i < str.length(); i++){
                char c = str.charAt(i);
                if (c >= '0' && c <= '9'){
                    sum = sum * 16 + c - '0';
                }else if (c >= 'A' && c <= 'F'){
                    sum = sum * 16 + c - 'A' + 10;
                }
            }
            System.out.println(sum);
        }     
    }
}

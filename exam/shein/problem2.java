package exam.shein;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(",");
        String str = input[0];
        int row = Integer.valueOf(input[1]);
        int group = 2 * row - 2;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < row; i++){
            if (i == 0 || i == row - 1){
                int index = i;
                while (index < str.length()){
                    sb.append(str.charAt(index));
                    index += group;
                }
            }
            else {
                int index1 = i,index2 = group - i;
                while (index1 < str.length() || index2 < str.length()){
                    if (index1 < str.length())sb.append(str.charAt(index1));
                    if (index2 < str.length())sb.append(str.charAt(index2));
                    index1 += group;
                    index2 += group;
                }
            }
        }
        System.out.println(sb.toString());
    }
}

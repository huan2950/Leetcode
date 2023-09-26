package exam.meituan.test3;

import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            if (str.startsWith(".") || str.endsWith(".")){
                System.out.println("invalid");
                continue;
            }
            String[] strs = str.split("\\.");
            if (strs.length != 4){
                System.out.println("invalid");
                continue;
            }
            int[] nums = new int[4];
            boolean flag = true;
            for (int i = 0; i < 4; i++){
                int num = check(strs[i]);
                if (num == -1){
                    System.out.println("invalid");
                    flag = false;
                    break;
                }
                nums[i] = num;
            }
            if (flag){
                System.out.println(judge(nums));
            }

        }
    }

    public static int check(String s){
        if (s.length() == 0) return -1;
        if (s.length() > 1 && s.startsWith("0")){
            return -1;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return -1;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return -1;
            }
        }
        return num; 
    }

    public static String judge(int[] nums){
        if (nums[0] >= 1 && nums[0] < 126)return "A_address";
        if (nums[0] == 126 && nums[1] == 0 && nums[2] == 0 && nums[3] == 0)return "A_address";
        if (nums[0] >= 128 && nums[0] < 192)return "B_address";
        if (nums[0] >= 192 && nums[0] < 224)return "C_address";
        else return "other";
    }
}

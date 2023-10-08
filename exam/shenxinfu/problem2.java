package exam.shenxinfu;

import java.math.BigInteger;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        char[] str = n.toString().toCharArray();
        int len = str.length;
        char max = '0';
        int maxIndex = 0;
        for(int i = 0;i < len; i++){
            if (str[i] > max){
                max = str[i];
                maxIndex = i;
            }
            else if (str[i] == max){
                int j = i;
                int k =maxIndex;
                while (next(j, str) >= next(k, str)){
                    if (next(j, str) > next(k, str)){
                        max = str[i];
                        maxIndex = i;
                        break;
                    }else {
                        j = (j + 1) % len;
                        k = (k + 1) % len;
                    }
                }
            } 
        } 
        long res = 0;
        for (int i = maxIndex; i < len; i++){
            res = res * 10 + (str[i] - '0');
        }
        for (int i = 0; i < maxIndex; i++){
            res = res * 10 + (str[i] - '0');
        }
        System.out.println(res);
    }

    public static char next(int index, char[] str){
        int len = str.length;
        index = index % len;
        if (index == len - 1){
            return str[0];
        }else return str[index + 1];
    }
}

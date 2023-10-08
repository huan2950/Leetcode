package exam.shein;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int curToken = 100;
        int curTime = 0;
        int maxToken = 150; 
        int limitCount = 0;
        for (int i = 0; i < n; i++){
            int time = in.nextInt();
            int requestNum = in.nextInt();
            // 当前生产出的总共的token
            curToken += (time - curTime)/10;
            // 桶内容纳的最多的token
            curToken = Math.min(curToken,maxToken);
            if (curToken < requestNum){
                limitCount += (requestNum - curToken);
                curToken = 0;
            }else{
                curToken = curToken - requestNum;
            }
            curTime = time;
        }
        System.out.println(limitCount);
    }
}

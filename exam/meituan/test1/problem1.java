package exam.meituan.test1;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        double oldTotal = 0;
        double newTotal = 0;
        for (int i = 0; i < n; i++){
            double oldPrice = in.nextDouble();
            double newPrice = in.nextDouble();
            if (oldPrice < newPrice || oldPrice <= 0 || newPrice <= 0){
                System.out.println("error");
                return;
            }        
            oldTotal += oldPrice;
            newTotal += newPrice;
        }
        double reachPrice = in.nextDouble();
        double subPrice = in.nextDouble();
        if (reachPrice < subPrice || reachPrice <= 0 || subPrice <= 0){
            System.out.println("error");
            return;
        }
        double finPrice = oldTotal >= reachPrice ? oldTotal - subPrice : oldTotal;
        finPrice = Math.min(finPrice, newTotal);
        System.out.printf("%.2f", finPrice);
    }
}

package exam.jd;

import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int b = -2 * (x + y);        
        int c = x * x + y * y;
        int delta = b * b - 4 * c;
        double root1 = (-b - Math.sqrt(delta)) / 2;
        double root2 = (-b + Math.sqrt(delta)) / 2;
        System.out.printf("%.4f %.4f", root1, root2);
    }
}

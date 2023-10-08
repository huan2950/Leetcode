package exam.jd;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        if (k == 1) {
            System.out.println(0);
            return;
        }
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = in.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }
        

    }
}
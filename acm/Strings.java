package acm;

import java.util.Scanner;

import java.util.*;
 
public class Strings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                char[] arr = line.toCharArray();
                StringBuilder sb = new StringBuilder();
                int j = 0;
                while (j < arr.length) {
                    if (arr[j] <= 'z' && arr[j] >= 'a') {
                        arr[j] = Character.toUpperCase(arr[j]);
                    }
                    sb.append(arr[j]);
                    while (j < arr.length && arr[j] != ' ') {
                        j++;
                    }
                    while (j < arr.length && arr[j] == ' ') {
                        j++;
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}

// public class Strings {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         while(in.hasNextLine()){
//             String line = in.nextLine();
//             String[] degrees = line.split(" ");
//             int res = compute(degrees);
//             if (res == -1 ) {
//                 System.out.println("Unknown");
//             }else{
//                 System.out.printf("%.2f\n", res * 1.0/degrees.length);
//             }
//         }
//         in.close();
//     }

//     private static int compute(String[] degrees){
//         int sum = 0;
//         for (String degree: degrees){
//             int num = convert(degree);
//             if (num == -1){
//                 return -1;
//             }
//             sum += num;
//         }
//         return sum;
//     }

//     private static int convert(String degree) {
//         switch (degree) {
//             case "A":
//                 return 4;
//             case "B":
//                 return 3;
//             case "C":
//                 return 2;
//             case "D":
//                 return 1;
//             case "F":
//                 return 0;
//             default:
//                 return -1;
//         }
//     }
// }

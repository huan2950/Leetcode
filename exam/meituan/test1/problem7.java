package exam.meituan.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class problem7{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        char[][] chars = new char[m][n];
        for (int i = 0; i < m; i++){
            chars[i] = in.nextLine().trim().toCharArray();
        }
        int count = 0;
        for (int i = 0; i <= m - 3; i++){
            for (int j = 0; j <= n - 3; j++){
                if (judge(chars, i, j))count++;
            }
        }
        System.out.println(count);
    }
    
    public static boolean judge(char[][] chars, int x, int y){
        boolean countA = false;
        boolean countB = false;
        boolean countC = false;
        for(int i = x; i < x + 3;i++){
            for (int j = y; j < y + 3; j++){
                char cur = chars[i][j];
                if (cur == 'A'){
                    countA = true;
                }else if (cur == 'B'){
                    countB = true;
                }else if (cur == 'C'){
                    countC = true;
                }else {
                    return false;
                }
                if (j < y + 2 && cur == chars[i][j+1]){
                    return false;
                }
                if (i < x + 2 && cur == chars[i+1][j]){
                    return false;
                }
            }
        }
        if (countA && countB && countC) return true;
        else return false;
    }
}
// class problem7 {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         int m = in.nextInt();
//         int n = in.nextInt();
//         in.nextLine();
//         char[][] chars = new char[m][n];
//         for (int i = 0; i < m; i++){
//             chars[i] = in.nextLine().trim().toCharArray();
//         }
//         int count = 0;
//         Map<Character,Integer> mapFirst = new HashMap<>();
//         boolean find = true;
//         // 判断第一个3*3的方阵
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 char cur = chars[i][j];
//                 if (mapFirst.containsKey(cur)){
//                     mapFirst.put(cur ,mapFirst.get(cur ) + 1);
//                 }else{
//                     mapFirst.put(chars[i][j],1);
//                 }
//                 if (!find) continue;
//                 if ((i < 2 && j < 2) && cur == chars[i+1][j] || cur == chars[i][j+1]){
//                     find = false;
//                 }
//             }
//         }

//         if (chars[2][1] == chars[2][2] || chars[1][2] == chars[2][2]) find = false;

//         if(mapFirst.entrySet().size() != 3 || !mapFirst.containsKey('A') || !mapFirst.containsKey('B') || !mapFirst.containsKey('C')) find = false;

//         if (find) count++;

//         Map<Character,Integer> mapLater = new HashMap<>(mapFirst);
//         for (int i = 0; i <= m - 3; i++){
//             for(int j = 0; j <= n - 4; j++){
//                 boolean findLater = true;
//                 for(int k = i; k < i + 3; k++){
//                     char curOut = chars[k][j];
//                     char curIn = chars[k][j+3];
//                     char judgeIn = chars[k][j+2];
//                     // out
//                     int num;
//                     if ( ( num = mapLater.get(curOut)) == 1 ){
//                         mapLater.remove(curOut);
//                     }else {
//                         mapLater.put(curOut,num - 1);
//                     }
//                     // in
//                     if (mapLater.containsKey(curIn)){
//                         mapLater.put(curIn, mapLater.get(curIn) + 1);
//                     }else {
//                         mapLater.put(curIn,1);
//                     }
//                     if (!findLater) continue;
//                     if (curIn == judgeIn) findLater = false;
//                 }
//                 if (judge(mapLater) && findLater) count++;
//             }
//             // 更新mapFirst
//             if (i == m - 3) break; // 最后一行了
//             boolean findFirst = true;
//             for (int k = 0; k < 3; k++){
//                 char curOut = chars[i][k];
//                 char curIn = chars[i+3][k];
//                 char judgeIn = chars[i+2][k];
//                 // out
//                 int num;
//                 if ( (num = mapFirst.get(curOut)) == 1 ){
//                     mapFirst.remove(curOut);
//                 }else {
//                     mapFirst.put(curOut,num - 1);
//                 }
//                 // in
//                 if (mapFirst.containsKey(curIn)){
//                     mapFirst.put(curIn, mapFirst.get(curIn) + 1);
//                 }else {
//                     mapFirst.put(curIn,1);
//                 }
//                 if (!findFirst) continue;
//                 if (curIn == judgeIn) findFirst = false;
//             }
//             if (judge(mapFirst) && findFirst) count++;
//             // 更新mapLater
//             mapLater = new HashMap<>(mapFirst);
//         }
//         System.out.println(count);
//         // for (int i = 0; i < m; i++){
//         //     for (int j = 0; j < n; j++) {
//         //         System.out.println(chars[i][j]); 
//         //     }
//         // }
//     }

//     public static boolean judge(Map<Character,Integer> map){
//         if(map.entrySet().size() != 3 || !map.containsKey('A') || !map.containsKey('B') || !map.containsKey('C'))
//             return false;
//         else return true;
//     }
// }

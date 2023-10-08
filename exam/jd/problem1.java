package exam.jd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Set <Character> set = new HashSet<Character>();
        set.add('i');
        set.add('l');
        set.add('m');
        set.add('n');
        set.add('o');
        set.add('v');
        set.add('u');
        set.add('w');
        set.add('x');
        Map <Character,Character> map = new HashMap<>();
        map.put('p','q');
        map.put('q','p');
        map.put('b','d');
        map.put('d','b');
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < n; i++) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int j = 0, k = str.length() - 1;
            boolean flag = true;
            while (j <= k){
                char a = str.charAt(j);
                char b = str.charAt(k);
                if (a != b ){
                    if (!check(a, b, map)){
                        System.out.println("No");
                        flag = false;
                        break;
                    }
                }else if (!set.contains(a)){
                    System.out.println("No");
                    flag = false;
                    break;
                }
                j++;
                k--;
            }
            if (flag) System.out.println("Yes");
        }
    }

    public static boolean check (char a, char b, Map<Character,Character> map){
        if (!map.containsKey(a) || !map.containsKey(b))return false;
        else{
            if (map.get(a) == b)return true;
            else return false;
        }
    }
}

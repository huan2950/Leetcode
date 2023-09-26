package exam.meituan.test1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String t = in.nextLine();
        Map<Character, Set<Character>> mapS = new HashMap<>();
        Map<Character, Set<Character>> mapT = new HashMap<>();
        int count = 0;
        boolean singleMatch = false;
        for (int i = 0; i < n; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (c1 == c2){
                count++;
            }else{
                if (!mapS.containsKey(c1)){
                    Set<Character> set = new HashSet<>();
                    set.add(c2);
                    mapS.put(c1,set);
                }else if (!mapS.get(c1).contains(c2)) mapS.get(c1).add(c2);

                if (!mapT.containsKey(c2)){
                    Set<Character> set = new HashSet<>();
                    set.add(c1);
                    mapT.put(c2, set);
                }else if (!mapT.get(c2).contains(c1)) mapT.get(c2).add(c1);
            }
        }

        for (char keyS: mapS.keySet()){
            for (char valueS: mapS.get(keyS)){
                if (mapT.containsKey(keyS)){
                    singleMatch = true;
                    if (mapT.get(keyS).contains(valueS)){
                        System.out.println(count + 2);
                        return;
                    }
                }
            }
        }

        for (char keyT: mapT.keySet()){
            for (char valueT: mapT.get(keyT)){
                if (mapS.containsKey(keyT)){
                    singleMatch = true;
                    if (mapS.get(keyT).contains(valueT)){
                        System.out.println(count + 2);
                        return;
                    }
                }
            }
        }
        
        count = singleMatch ? count + 1 : count;
        System.out.println(count);

    }
}

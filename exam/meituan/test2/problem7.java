package exam.meituan.test2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class problem7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Set<String>> memberMap = new HashMap<>();
        Map<String, String> addressMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            String[] s = in.nextLine().trim().split(" ");
            String name = s[0];
            if (!isAllLowerCase(name) || !isAllLowerCase(s[1])) continue;
            if (!memberMap.containsKey(name)){
                addressMap.put(name, s[1]);
                Set<String> set = new HashSet<>();
                memberMap.put(name, set);
            }else{
                if (addressMap.get(name).equals(s[1])) continue;
                memberMap.get(name).add(s[1]);
            }
        }
        String[] names = memberMap.keySet().toArray(new String[memberMap.size()]);
        Arrays.sort(names);
        for (int i = 0; i < names.length; i++){
            String name = names[i];
            System.out.println(name + " " + addressMap.get(name) + " " + memberMap.get(name).size());
        }
    }

    public static boolean isAllLowerCase(String str) {
        // 遍历字符串的每个字符
        for (int i = 0; i < str.length(); i++) {
            // 如果有任意一个字符不是小写字母，则返回false
            if (!Character.isLowerCase(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

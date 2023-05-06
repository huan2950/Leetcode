class test {
    //递归中需要用到下标，为了方便，定义一个成员变量
    private int index = 0;

    public String decodeString(String s) {
        String str = recurve(s);
        return str;
    }

    //使用递归解决
    //为什么会想到递归呢，因为不确定有多少[]这样的子串，这种不确定次数的情况使用递归非常合适
    public String recurve(String s){
        StringBuilder builder = new StringBuilder();//用一个builder来拼接字符串
        while(index < s.length()){
            char cur = s.charAt(index);//获取当前字符
            index++;
            //如果是数字
            if(cur >= '0' && cur <= '9'){
                //数字可能有很多位，因此需要循环把数字遍历完
                int num = cur - '0';//用num来记录数字，也就是子串重复的次数
                while(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                String str = recurve(s);//递归获取子串
                //将子串重复相应的次数
                for(int i = 0;i < num;i++){
                    builder.append(str);
                }
            }else if(cur == '['){//如果是[，不需要做什么

            }else if(cur == ']'){//如果是]，则子串已经建立完成，退出循环
                break;
            }else{//如果是普通字符，则拼接
                builder.append(cur);
            }
        }
        return builder.toString();//返回子串
    }

    public static void main(String[] args) {
        test t = new test();
        String s = "3[a2[c]]";
        String returnString =t. decodeString(s);
        System.out.println(returnString);
    }
}

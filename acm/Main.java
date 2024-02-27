package acm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        int[] arr = new int[]{61,109,149,111,34,2,24,119,122,27};
 
       ShellSort_swap(arr);
        // ShellSort_move(arr);
 
    }
 
 
    //交换式
    public static void ShellSort_swap(int[] arr) {
        int temp = 0;
        // 步长每次减半直到为1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // i的初始值为第一组内第二个元素的位置
            // 每次比较值都是同一组内的两个元素，同组内的两个元素相差gap个位置
            for (int i = gap; i < arr.length; i++) {
                // j的初始值为第一组内第一个元素的位置
                // 每一组内都要进行比较并swap,比较方向从后往前
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，则交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println("Shell排序后:" + Arrays.toString(arr));
    }
 
 
    //移位式的希尔排序
    public static void ShellSort_move(int[] arr){
        //增量的gap
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int temp = 0;
            int j = 0;
            //从第gap个元素开始，逐个对其所在的组进行直接插入
            for(int i = gap ; i < arr.length ; i++){
                j = i;
                temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while循环后，就给temp找到了插入位置
                    arr[j] = temp;
                }
            }
        }
        System.out.printf("Shell排序后:%s\n",Arrays.toString(arr));
    }
}

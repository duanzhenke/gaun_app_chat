package com.guan.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class SuanFa {

    public static void main(String[] args) {

       String str= "Hello World StringUtils";
        String[] s = str.split(" ");
        int length = s[s.length - 1].length();
        System.out.println(length);



    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    /**
     * rev是循环使用的，每循环一次最后一位就乘以10，并在改数后面拼接上前一位，以此来实现反转。
     * 例如：输入为321,
     * 第一次循环 rev =0, 321的余数pop=1, x除以10后等于32.1，但因为是整型所以自动舍去后面的小数，x=32, rev = 0*10 + 1 = 1
     * 第二次循环 rev =1，x=32的余数pop=2,x除以10后等于3.2，但因为是整型所以自动舍去后面的小数，x=3, rev = 1*10 + 2 = 12
     * 第三次循环 rev =12，x=3的余数pop=3,x除以10后等于0.3，但因为是整型所以自动舍去后面的小数，x=0, rev = 12*10 + 3 = 123
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            // 以下等于 x = x/10;
            x /= 10;
            // 大于等于Integer的正整数的最大值返回0
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            // 小于等于Integer的负整数的最大值返回0
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;

    }

    /**
     * 递归算阶乘
     * @param n (计算的数)
     * @return result(计算的结果)
     */
    private static int factorial(int n) {
        if(n == 1) {
            return 1;
        }else {
            int factorial = factorial(n - 1);
            return n * factorial;
        }
    }

    public static int binarySearch(List<Integer> list, int target) {

        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            // 每次检查中间的元素
            int mid = (low + high) / 2;
            int guess =list.get(mid);
            if (guess < target) {
                low = mid + 1;
            } else if (guess > target) {
                high = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    /**
     * 选择排序
     * @param array	数组
     * @return 排序好的数组(从小到大)
     */
    private static int[] findMinNumber(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}

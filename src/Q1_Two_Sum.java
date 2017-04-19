/**
 * Created by xubowen on 2017/4/15.
 */
/*
 *光在真空中一纳秒仅传播0.3米。个人电脑的微处理器执行一道指令（如将两数相加）约需2至4纳秒。
 */
/**
 * https://leetcode.com/problems/two-sum/#/description
 * Description
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 问题描述
 * 给一个数组，返回数组中求和等于给定值的下标。给定的数恰好只有一种答案。
 */

import java.util.HashMap;
import java.util.Map;


public class Q1_Two_Sum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 9, 10, 11, 15};
        int target = 26;
        long start = System.nanoTime();
        int result[]=twoSum(nums,target);
        System.out.println("已耗时：" + (System.nanoTime()-start));
        System.out.println(result[0]+"&"+result[1]);
    }
    public  static int[] twoSum(int[] numbers, int target) {
        //耗时：348495ns
        //极端情况，最后两位相加，耗时：303196ns
        //数据少的情况下耗时相差不多
        int[] result = new int[2];
        int length=numbers.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(numbers[i]+numbers[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
        //官网Solution版本，耗时：378030ns
        //极端情况，最后两位相加，耗时：244011ns
        /*int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;*/
    }
}

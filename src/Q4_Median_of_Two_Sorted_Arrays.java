/**
 * Created by xubowen on 2017/4/17.
 */
/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/#/description
 * Description
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 问题描述：
 * 求连个数组合在一起的中间数。
 */
public class Q4_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int nums1[]={1,2};
        int nums2[]={3,4};
        System.out.print(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length=nums1.length+nums2.length;
        int src[]=new int[length];
        int i=0;
        for(i=0;i<nums1.length;i++){
            src[i]=nums1[i];
        }
        for(int j=0;j<nums2.length;j++){
            src[i]=nums2[j];
            i++;
        }
        int sort[]=quicksort(src,0, length-1);
        if(sort.length%2==0){
            return (sort[sort.length/2-1]+sort[sort.length/2])/2.0;
        }else{
            return sort[(sort.length-1)/2];
        }
    }
    //快速排序
    private static int[] quicksort(int []src,int begin, int end){
        if(begin<end){
            int key=src[begin];
            int i= begin;
            int j= end;
            while(i<j){
                while(i<j&&src[j]>key) j--;
                if(i<j){
                    src[i]=src[j];
                    i++;
                }
                while(i<j&&src[i]<key) i++;
                if(i<j){
                    src[j]=src[i];
                    j--;
                }
            }
            src[i]=key;
            quicksort(src,begin,i-1);
            quicksort(src,i+1,end);
        }
        return src;
    }
}

/**
 * Created by xubowen on 2017/4/19.
 */
/*https://leetcode.com/problems/longest-palindromic-substring/#/description
 *Description
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 * 问题描述:
 * 返回最长回文字符串
 */
public class Q5_Longest_Palindromic_Substring {
    public static void main(String args[]){
        System.out.println(longestPalindrome("abcdcbaaa"));
    }
    public static String longestPalindrome(String s) {

        String str="";
        int recindex=0;
        int reclength=0;
        int maxlength=0;
        boolean jiou=false;
        int length=s.length();
        for(int i=0;i<length;i++){
            for(int j=0;i-j>=0&&i+j+1<length;j++){
                if(s.charAt(i-j)!=s.charAt(i+j+1)){
                    break;
                }
                reclength=j*2+2;
            }
            if(maxlength<reclength){
                maxlength=reclength;
                recindex=i;
                jiou=false;
            }
            for(int j=0;i-j>=0&&i+j<length;j++){
                if(s.charAt(i-j)!=s.charAt(i+j)){
                    break;
                }
                reclength=j*2+1;
            }
            if(maxlength<reclength){
                maxlength=reclength;
                recindex=i;
                jiou=true;
            }
        }
        if(jiou){
            //System.out.println("奇数索引："+recindex+"长度："+maxlength);
            int len=(maxlength-1)/2;//abcdcba; 7 3
            str=s.substring(recindex-len,recindex+len+1);//3
        }else{
            //System.out.println("偶数索引："+recindex+"长度："+maxlength);
            int len=maxlength/2;//abcddcba; 8 4
            str=s.substring(recindex-len+1,recindex+len+1);//4
        }
        return str;

    }
}

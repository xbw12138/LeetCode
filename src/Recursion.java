/**
 * Created by xubowen on 2017/4/18.
 */
public class Recursion {
    public static void main(String args[]){
        System.out.println("吓得我抱起了");
        Recursion(2);
    }
    public static void Recursion(int depth) {
        System.out.println("抱着");
        if (depth == 0) System.out.println("我的小鲤鱼");
        else Recursion(--depth);
        System.out.println("的我");
    }

    private static int[] quickSort(int []src,int begin, int end){
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
            quickSort(src,begin,i-1);
            quickSort(src,i+1,end);
        }
        return src;
    }
}

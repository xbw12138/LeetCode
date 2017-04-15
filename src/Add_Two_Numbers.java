/**
 * Created by xubowen on 2017/4/15.
 */

/**
 * https://leetcode.com/problems/add-two-numbers/#/description
 * Description
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their
 * nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * 问题描述
 * 给两个不为空的链表，代表两个非负数，每个数字倒着存放在链表中，求和，结果同样倒着存放在链表中。
 */
public class Add_Two_Numbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null,cur=null;
        result=cur=new ListNode(0);
        int carry=0,a=0,b=0;
        while(l1 != null||l2 != null||carry != 0){
            int sum=0;
            a=l1!=null?l1.val:0;
            b=l2!=null?l2.val:0;
            sum=a+b+carry;
            carry=sum/10;
            cur=cur.next=new ListNode(sum%10);
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        return result.next;
    }
    public static void main(String[] args) {
        /*
         *Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
         *Output: 7 -> 0 -> 8
         *
         */
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        /*ListNode head = null, node = null;
        head = node = new ListNode(0);
        ListNode result=l1;
        while(result!=null) {
            node = node.next = new ListNode(result.val);
            result = (result != null ? result.next : null);
        }
        //result=result.next;
        ListNode headresult=head.next;
        while(headresult!=null){
            System.out.println(headresult.val);
            headresult=(headresult!=null?headresult.next:null);
        }*/
        ListNode result=addTwoNumbers(l1, l2);
        while(result!=null){
            System.out.println(result.val);
            result=(result!=null?result.next:null);
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

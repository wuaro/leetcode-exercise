package LeetCode热题100.链表.回文链表;
/*
234. 回文链表
简单
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

示例 1：
输入：head = [1,2,2,1]
输出：true

示例 2：
输入：head = [1,2]
输出：false

提示：
链表中节点数目在范围[1, 105] 内
0 <= Node.val <= 9

进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    //方法一：全部入栈，在将后一半出栈 并依次与前一半比较，从而得出结论
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> sta = new Stack<Integer>();      //定义一个栈，将链表中的值依次入栈
        int l = 0;
        for (ListNode node = head; node!=null ; node=node.next) {
            sta.push(node.val);
            l++;
        }

        //l记录为链表的总长度，此时只需要将后一半（l/2）元素依次出栈，并依次与链表的前一半元素进行比较即可得出结论
        for (int i = 0; i < l/2; i++) {
            if (head.val != sta.peek()) return false;
            head = head.next;
            sta.pop();
        }
        return true;
    }

    /*
     方法二：O（1）空间复杂度实现
      将后半部分链表反转，随后与前半部分链表中的元素依次比较，判断是否为回文链表
      优点：不需要栈，空间复杂度为O(1)
     */
    public boolean isPalindrome1(ListNode head) {

        int l = 0;      //记录链表的总长度
        for (ListNode node = head; node!=null ; node=node.next) {
            l++;
        }

        //从第l/2个节点开始，翻转指针
        ListNode h = head;
        for (int i = 0; i < l/2; i++) {
            h = h.next;
        }
        ListNode nh = reverseList(h);

        //将翻转的后半部分链表中的节点依次与前半部分相比，判断是否为回文链表
        for (int i = 0; i < l/2; i++) {
            if (head.val != nh.val) return false;
            head = head.next;
            nh = nh.next;
        }
        return true;
    }

    //翻转链表方法
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null)return head;
        ListNode i = null, j = head, k = j.next;
        while (true){
            j.next = i;
            i = j;
            j = k;
            if (j != null){
                k = k.next;
            }else {
                return i;
            }
        }
    }
}
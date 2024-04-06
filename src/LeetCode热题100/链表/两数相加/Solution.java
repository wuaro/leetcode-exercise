package LeetCode热题100.链表.两数相加;
/*
2. 两数相加
中等
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
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

    /*
    方法一：正常做法
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0, num2 = 0;
        for (ListNode i = l1; i != null; i = i.next) {          //记录两个链表分别多长
            num1++;
        }
        for (ListNode i = l2; i != null; i = i.next) {
            num2++;
        }

        if (num1 > num2) {                               //如果两个数字中有一个更长，则短的那一个在入栈的时候需要补0
            ListNode node = l2;
            while (node.next != null){
                node = node.next;
            }
            for (int i = 0; i < num1-num2; i++) {
                node.next = new ListNode(0);
                node = node.next;
                node.next = null;
            }
        } else if (num2 > num1) {
            ListNode node = l1;
            while (node.next != null){
                node = node.next;
            }
            for (int i = 0; i < num2-num1; i++) {
                node.next = new ListNode(0);
                node = node.next;
                node.next = null;
            }
        }

        int carry = 0;      //进位的值
        ListNode n1 = l1;         //s1中当前末尾结点
        ListNode n2 = l2;         //s2中当前末尾结点
        int n1_v = 0;
        while (true) {
            System.out.println("n1:"+n1.val + "n2:"+n2.val + "carry:"+carry);
            n1_v = n1.val;
            n1.val = (n1.val + n2.val + carry) % 10 ;
            carry = (n1_v + n2.val + carry) / 10;
            System.out.println("n1:"+n1.val + "carry:"+carry);
            if (n1.next==null && n2.next==null) {
                if (carry!=0){
                    ListNode ans = new ListNode(carry);
                    n1.next = ans;
                    return l1;
                }else {
                    return l1;
                }
            }
            n1 = n1.next;
            n2 = n2.next;
        }
    }
}
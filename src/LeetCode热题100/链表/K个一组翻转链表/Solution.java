package LeetCode热题100.链表.K个一组翻转链表;
/*
25. K 个一组翻转链表
困难
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

示例 2：
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000

进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */


import java.util.List;

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
public class Solution {


    /*
    方法一：写一个方法reverse(h,n)，专门负责反转以h为头结点，长度为n的一段链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode t = head;
        ListNode l = head;
        ListNode m = null;
        ListNode a = null;
        ListNode b = null;
        while (true){
            for (int i = 0; i < k; i++) {
                if (t == null){
                    a.next = l;
                    System.out.println("a:"+a.val +" a.next:"+a.next.val);
                    System.out.println("已经到头");
                    for(ListNode p = head;p != null;p = p.next){
                        System.out.print(p.val+" ");
                    }
                    return head;          //如果在找尾巴的过程中就遇见null了，说明已经不足k个节点了，那就不用再反转了
                }
                System.out.println("探索到："+t.val);
                t = t.next;                     //t最终会指向下一个链表的头
            }
            if(l == head){
                a = l;
                m = reverse(l,k);
                head = m;
            }else{
                b = a;
                a = l;
                m = reverse(l,k);
                b.next = m;
            }
            a.next = m;
            System.out.println();
            l = t;
        }
    }


    public static ListNode reverse(ListNode head , int length){       //把长度为length的链表反转
        if (length==0 || length==1) return head;
        ListNode i = null;
        ListNode j = head;
        ListNode k = head.next;

        for (int l = 0; l < length; l++) {
            j.next = i;
            i = j;
            j = k;
            if (k!=null){
                k = k.next;
                head.next = k;          //返回反转后的链表头结点，并将尾节点连到下一段链表上
            }
        }
        return i;
    }
}

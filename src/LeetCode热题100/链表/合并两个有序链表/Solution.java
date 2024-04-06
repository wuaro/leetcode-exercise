package LeetCode热题100.链表.合并两个有序链表;
/*
21. 合并两个有序链表
简单
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

示例 2：
输入：l1 = [], l2 = []
输出：[]

示例 3：
输入：l1 = [], l2 = [0]
输出：[0]

提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
 */


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)return list2;
        if (list2 == null)return list1;
        ListNode i = list1.val>list2.val ? list2 : list1;           //始终让i 指向第一个元素更小的那个链表
        ListNode j = list1.val>list2.val ? list1 : list2;;
        ListNode k = null;
        ListNode ans = i;
        while (i.next!=null && j!=null){
            if (j.val>=i.val && j.val<=i.next.val){
                k = j.next;
                j.next = i.next;
                i.next = j;
                j = k;
            }else if (i.next!=null){
                i = i.next;
            }
        }
        if (i.next == null){
            i.next = j;
            return list1.val<list2.val ? list1 : list2;
        } else if (j == null) {
            return list1.val<list2.val ? list1 : list2;
        }
        return null;
    }
}
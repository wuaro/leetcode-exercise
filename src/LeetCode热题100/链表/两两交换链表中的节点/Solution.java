package LeetCode热题100.链表.两两交换链表中的节点;
/*
24. 两两交换链表中的节点
中等
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：
输入：head = []
输出：[]

示例 3：
输入：head = [1]
输出：[1]

提示：
链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode i = null;
        ListNode j = head;
        ListNode k = head.next;
        ListNode l = head.next.next;
        while(true){

            j.next = l;
            k.next = j;             //此后指针的顺序由jkl变成kjl
            if (j == head){
                head = k;
            }else {
                i.next = k;
            }

            if (l == null || l.next == null)return head;
            i = j;
            j = l;
            k = l.next;
            l = l.next.next;

        }

    }

}

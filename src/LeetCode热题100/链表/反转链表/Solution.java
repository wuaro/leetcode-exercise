package LeetCode热题100.链表.反转链表;
/*
206. 反转链表
简单
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

示例 2：
输入：head = [1,2]
输出：[2,1]

示例 3：
输入：head = []
输出：[]

提示：
链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000
 */
public class Solution {
    /*
    方法一：递归法
     假设reverseList方法可以实现：传入头结点，返回反转后的链表的头结点
     则每一层的任务就是，接过上一层传来的”新头结点“,并将自己当前节点进行反转
     */
    public ListNode reverseList(ListNode head) {
        /*
        如果链表本来就是空则返回null
        如果head.next==null说明链表已经递归到最后一个元素，则该元素就应该是反转后链表的头结点
        */
        if (head==null || head.next==null) return head;

        ListNode node = reverseList(head.next);     //每一层的任务就是，接过上一层传来的”新头结点“,并将自己当前节点进行反转
        head.next.next = head;
        head.next = null;

        return node;            //每一层都将上一层传下来的“新头结点”再传给下一层，直到最后，即返回最终完全反转后的链表头结点
    }

    /*
    方法二：迭代法
     两三个指针同时向后移动，进行指针反转，考研备考时候经常写
     */
}

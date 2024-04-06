package LeetCode热题100.链表.删除链表的倒数第N个结点;

import java.util.Stack;

/*
19. 删除链表的倒数第 N 个结点
中等
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]

示例 3：
输入：head = [1,2], n = 1
输出：[1]

提示：
链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
进阶：你能尝试使用一趟扫描实现吗？
 */
public class Solution {

    //方法一：用栈
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        for (ListNode i = head; i!=null;i = i.next) {       //将链表入栈
            stack.push(i);
        }

        ListNode p = null;
        for (int i = 0; i < n; i++) {
            p = stack.pop();
        }
        if (stack.empty())return p.next;
        stack.peek().next = p.next;
        return head;
    }

    //方法二：两次遍历，不用栈
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int l = 0;
        for (ListNode i = head; i!=null;i = i.next) {       //将链表入栈
            l++;
        }
        System.out.println("l:"+l + "n:"+n);
        ListNode k = head;
        for (int i = 0; i < l-n; i++) {
            k = k.next;
            System.out.println("i:"+i);
        }
        if (k == head)return k.next;
        k.next = k.next.next;
        return head;
    }
}

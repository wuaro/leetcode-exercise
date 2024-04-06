package LeetCode热题100.链表.相交链表;
/*
160. 相交链表
简单
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：
题目数据 保证 整个链式结构中不存在环。
注意，函数返回结果后，链表必须 保持其原始结构 。

自定义评测：
评测系统 的输入如下（你设计的程序 不适用 此输入）：
intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。

示例 1：
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。

示例 2：
输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Intersected at '2'
解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

示例 3：
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
这两个链表不相交，因此返回 null 。

提示：
listA 中节点数目为 m
listB 中节点数目为 n
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
如果 listA 和 listB 没有交点，intersectVal 为 0
如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]

进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
 */


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {


    /*
    方法一：用栈
    设置两个栈，两个链表都依次分别入栈，由于末尾相同，所以最开始分别出栈的时候一定是相同的，到后面就不同了，由此可以找出交叉点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack_A = new Stack<ListNode>();
        Stack<ListNode> stack_B = new Stack<ListNode>();

        ListNode a = headA;
        while (a != null){
            stack_A.push(a);
            a = a.next;
        }
        ListNode b = headB;
        while (b != null){
            stack_A.push(b);
            b = b.next;
        }
        ListNode p = stack_A.peek();
        while (!stack_A.empty() && !stack_B.empty()){
            if (stack_A.empty() || stack_B.empty()){
                return null;
            }else if (stack_A.peek() != stack_B.peek()){
                return p;
            }else{
                p = stack_A.peek();
                stack_A.pop();
                stack_B.pop();
            }
        }
        return null;
    }

     /*
    方法二：我走过你走的路（绝妙绝妙绝妙！！！）
     a，b两个指针都沿着各自的链表往后走，一旦有一个指针走到表尾，立刻转到另一条链表的头部继续走（画图仔细理解！！！）
     这样的话，当两个指针指向同一节点时，他们走的路程是相同的，而且此节点便是相交节点
     实在太妙！！！敬佩之情无以言表！！！
     */
     public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
         if (headA==null || headB==null) return null;
         ListNode a = headA;
         ListNode b = headB;
         while (a != b){
             a = a==null? headB : a.next;
             b = b==null? headA : b.next;
         }
         return a;
     }

}

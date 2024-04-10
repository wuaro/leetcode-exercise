package 分类刷题.链表.图书管理I;

/**
 * 图书整理 I
 * 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。
 * 为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。
 * 请倒序返回这个书单链表。
 *
 * 示例 1：
 * 输入：head = [3,6,4,1]
 * 输出：[1,4,6,3]
 *
 * 提示：
 * 0 <= 链表长度 <= 10000
 */



public class Solution {
    /**
     * 递归
     * 栈
     * 修改指针
     *
     */
    public int[] reverseBookList(ListNode head) {
        if (head == null) return new int[0];    //注意极端情况
        ListNode a = null;
        ListNode b = head;
        ListNode c = head.next;
        int l = 0;
        while (true) {
            l++;
            b.next = a;
            if (c == null) break;
            a = b;
            b = c;
            c = c.next;
        }

        int[] result = new int[l];
        int i = 0;
        while (b != null) {
            result[i] = b.val;
            i++;
            b = b.next;
        }
        return result;
    }
}

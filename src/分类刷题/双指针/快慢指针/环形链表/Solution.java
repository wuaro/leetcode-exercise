package 分类刷题.双指针.快慢指针.环形链表;



public class Solution {

    /**
     * 快慢指针法
     * 指针p每次走一步，指针q每次走两步
     * 如果有环，快指针早晚扣圈追上慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p = head;
        ListNode q = head;
        while (q.next!=null && q.next.next!=null){
            p = p.next;
            q = q.next.next;
            if (p == q) return true;
        }
        return false;
    }


}

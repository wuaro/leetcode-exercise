package LeetCode热题100.链表.排序链表;

class Solution {

    //负责排序
    public ListNode sort(ListNode head,int length){
        ListNode node = head;
        if (length < 2) return head;
        else if (length == 2){
            if (head.val > head.next.val){      //
                int temp = head.val;
                head.val = head.next.val;
                head.next.val = temp;
            }
        }else {
            sort(head,length/2);
            for (int i = 0; i < length/2; i++) {
                node = node.next;
            }
            sort(node,length/2);
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        ListNode i = head;
        ListNode j = head;
        int length = 0;
        while (i!=null){            //计算链表总长度
            length++;
            i = i.next;
        }
        return sort(head,length);
    }
}
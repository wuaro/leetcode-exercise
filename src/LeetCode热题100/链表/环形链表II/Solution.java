package LeetCode热题100.链表.环形链表II;
/*
142. 环形链表 II
中等
给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
不允许修改 链表。

示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。

提示：
链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引

进阶：你是否可以使用 O(1) 空间解决此题？
 */

import java.util.HashMap;

public class Solution {
    /*
    方法一：哈希表
     */
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> hm = new HashMap<ListNode,Integer>();
        ListNode i = head;
        while (i != null){
            if (!hm.containsKey(i)){
                hm.put(i,0);
            }else {
                return i;
            }
            i = i.next;
        }
        return null;
    }


    /*
    方法二：O(1)空间复杂度的方法   （双指针法）
     定义俩个指针，一快一慢（如果出现环的话，快的指针一定能“扣圈”追上慢的指针）
     速度：快指针每次走2格，慢指针一次走1格，则k次移动慢指针走k格，快指针走2k格
     假设：从表头到入环处距离为a，环的长度为b，则链表总长度为a+b
     那么：当快指针“扣n圈”时恰好和慢指针正好重合，那么他比慢指针多走了nb格，也就是2k-k=nb，也就是说慢指针走了nb格
          如果慢指针想要走到入环处的话，需要再走a步，那怎么确定a等于多少？
     关于a：“如果慢指针想要走到入环处的话，需要再走a步”，巧了嘛这不是，从head走到入环处的话，也需要再走a步！
          所以只需要此时让快指针移动到head处，并且改成每次移动1格，此后每次和慢指针一起移动（都是每次移动1格）
          则在移动了a次之后，两指针就会恰好重合在入环处（妙极啊woc！！！）
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null)return null;
        ListNode fast = head,slow = head;       //定义快慢指针
        Boolean flag = true;           //判断是否遍历到null
        while (fast!=null && slow!=null){
            fast = fast.next;
            if (fast == null)return null;
            fast = fast.next;
            slow = slow.next;
            if (fast==slow){        //如果快慢指针重合，则将快指针移动到head处，并改为每次移动一格
                System.out.println(fast.val);
                fast = head;
                flag = false;
                break;
            }
        }
        if (!flag){
            while (true){
                if (fast == slow)return fast;
                fast = fast.next;
                slow = slow.next;
            }
        }
        return null;
    }
}

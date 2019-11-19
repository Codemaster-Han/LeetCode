/**
 *反转一个单链表。
 *输入: 1->2->3->4->5->NULL
 *输出: 5->4->3->2->1->NULL
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
          ListNode temp=cur.next;
          cur.next=pre;

          pre=cur;
          cur=temp;
        }
        return pre;
    }
}
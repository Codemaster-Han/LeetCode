/**
 *删除链表中等于给定值 val 的所有节点。
 *输入: 1->2->6->3->4->5->6, val = 6
 *输出: 1->2->3->4->5
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**思路：这道题是要求我们删除链表中指定的元素，也就是某些特定的节点。
如果已经遍历到一个节点时，就无法删除这个节点了，因为是单链表。
所以想要删除某个节点，就必须找到这个节点的前一个节点，把前一个节点的指针改变，即指向下下一个就可以达到删除的目的了。
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
     ListNode pre=new ListNode(-1);
     pre.next=head;
     ListNode h=pre;
	 	//因为要删除的可能是链表的第一个元素，所以用一个h节点来做处理
		//最后只要返回h的下一个节点即可
        while(pre.next!=null){
            if(pre.next.val==val){
                pre.next=pre.next.next;
            }else{
                pre=pre.next;
            }
        }
        return  h.next;
    }
}
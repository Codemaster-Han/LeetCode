/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
  }
public class 从尾到头打印链表_06 {
    public static int[] reversePrint(ListNode head) {
        int len=0;
        ListNode node=head;//现将最开始的头结点保存下来
        while (head!=null){
            len++;
            head=head.next;
        }
        int[] arr=new int[len];
        for(int i=len-1;i>=0;i--){
            arr[i]=node.val;
            node=node.next;
        }
        return  arr;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        int[] array=reversePrint(n1);
        for(int e:array){
            System.out.print(e+" ");
        }

    }
}

/**
*给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
*输入: 1->2->3->4->5->NULL, k = 2
*输出: 4->5->1->2->3->NULL
*解释:
*向右旋转 1 步: 5->1->2->3->4->NULL
*向右旋转 2 步: 4->5->1->2->3->NULL
*/
 class Node{
	
	//属性
	int val;
	Node next;
	
	//构造方法
	Node(int val,Node next){
		this.val=val;
		this.next=next;
	}
	
	Node(int val){
		this(val,null);
	}
	
	
	//复写
	@Override
	public String toString(){
		return String.format("Node(%d)",val);
	}
}

public class RotateRight {
	//右旋
    public static Node rotateRight(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        Node tmp = head;
        int len = 0;
        //求出链表的长度
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        k = k % len;  //以len为一个周期
        if (k == 0) {
            return head;
        }
        //保存一下头节点
        Node node = head;
        //快慢指针
        tmp = head;
        while (k > 0) {
            k--;
            tmp = tmp.next;
        }
        while (tmp.next != null) {
            head = head.next;
            tmp = tmp.next;
        }
        //记录next的位置，也就是返回值的头结点
        Node res = head.next;
        //断开连接
        head.next = null;
        //后一段的末尾指向前一段的开头
        tmp.next = node;
        return res;
    }
	
	//打印链表
	public static void printLinkedList(Node head){
		Node cur=head; //current指当前节点    head 指的是头结点
		while(cur!=null){
			System.out.println(cur.val);
			cur=cur.next;
		}
	}
	
	//测试
	public static void main(String[] args){
		Node n1=new Node (1);
		Node n2=new Node (2);
		Node n3=new Node (3);
		Node n4=new Node (4);
		Node n5=new Node (5);

		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		printLinkedList(n1);//1 2 3 4 5
		System.out.println("===================");
		
		printLinkedList(rotateRight(n1,2));//4 5 1 2 3
		
		
	}
}

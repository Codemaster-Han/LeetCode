//用两个栈实现队列---队列原则：先进先出
//堆栈原则--先进的后出
//1.添加元素直接添加；
// 2.删除元素时判断第二个栈是不是空，是的话一次性将第一个栈元素全部压入，再删除就可以了
// 3.删除时如果第二个栈不空，那直接弹出就可以了。
//可以使用LinkedList来做Stack的容器,提高效率，因为LinkedList本身就是一个双向链表，它实现了Deque接口
import java.util.LinkedList;
public class CQueue {
    //属性
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    //构造方法
    public CQueue() {
        stack1 =new LinkedList<>();//stack1用于存储元素
        stack2=new LinkedList<>();//stack2用于辅助操作
    }

    //普通方法--队列尾插
    public void appendTail(int value) {
        stack1.add(value);
    }

    //普通方法--队列头删
    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty())
            {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());//栈1出栈的元素，入栈到栈2里面
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
}

/*
用两个栈实现队列_09
队列的声明如下，请实现它的两个函数 appendTail (尾插）和 deleteHead（头删） ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
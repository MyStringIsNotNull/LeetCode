package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space? 

给定一个链表，返回第一个循环的节点，如果不存在循环，返回null

提示:
不去修改链表

接着:
你能够没有使用额外的空间去解决这个问题吗？

 */
public class LinkedListCycleII 
{
	public ListNode detectCycle(ListNode head) 
	{
        ListNode cycle=null;
        Set<ListNode> set=new HashSet<ListNode>();
        while(head!=null)
        {
        	if(set.contains(head))
        	{
        		cycle=head;
        		break;
        	}
        	set.add(head);
        	head=head.next;
        }
        return cycle;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 可参见LinkedListCysle的代码的思路
	 * 
	 */
	/*
	public ListNode detectCycle(ListNode head)
	{        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) 
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) //当快慢指针相遇的时候，证明其有环，其中的代码目的为找到构成环的那个节点(即链表的尾节点的下个节点)
            {
            	 *
            	 * 从链表的第一个节点和slow和fast相遇的那个节点开始，一步一步的走，两者相遇的那个顶点，便是
            	 *链表开始循环的那个节点
            	 *详细请见: http://www.cnblogs.com/hiddenfox/p/3408931.html 博文
            	 *该博文的第三个方法中，其结论为正确的，但是证明过程中有点问题
            	 *
                ListNode newNode = head;
                while(newNode != slow) 
                {
                    newNode = newNode.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }*/
	
}

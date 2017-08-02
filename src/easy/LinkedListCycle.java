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
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

给定一个链表，判断其是否有循环存在

接着:
你能够没有使用额外的空间去解决这个问题吗？

 */
public class LinkedListCycle 
{
	/*
	 * 该方法的思路为，将遍历过的节点的值设置为某一个特定的值，用于表示其遍历过，其对节点的值是破坏性的，且其节点的值
	 * 不能等于某一个值
	 */
	public boolean hasCycle(ListNode head) 
	{
		boolean result=false;
		ListNode temp=null;
		if(head!=null)
		{
			//用于标记表示该节点遍历过
			head.val=Integer.MAX_VALUE;
			temp=head.next;
		}
		while(temp!=null)
		{
			if(temp.val==Integer.MAX_VALUE)
			{
				result=true;
				break;
			}
			temp.val=Integer.MAX_VALUE;
			temp=temp.next;
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 *
	 *其思路如下:
	 *大家考虑这样一个问题，链表的环相当于一个圆形操场。
	 *假设有两个人在圆形操场上无限循环的跑，那么速度快的一定能追得上速度慢的。(这句话为重点)
	 *同理，若要判断一个链表是否有环，可设计快慢指针，当快慢指针都进入环的时候，若最终两个指针相遇，必可说明链表存在环。
	 *下面就要考虑快慢指针的步长，从跑操场的情况来看，不管慢的有多慢，快得有多快，最终肯定能相遇。
	 *同理，链表中，也可随意指定快慢指针的步长，无非就是跑的圈数多少的问题。
	 *
	 *一般而言，都是采用快指针的速度为每次两个节点，慢指针的速度为每次一个节点的速度进行
	 *这样的话，可以这样理解(p1和p2分别为慢指针和快指针)
	 *在任意时刻，p1和p2都在环上。由于p1每次向前1步，p2每次向前两步，用相对运动的观点来看，把p1看作静止，
	 *那么p2每次相对p1向前1步，二者在顺时针方向上的距离每经过一个时刻就减少1，直到变为0，也即二者恰好相遇。
	 *这样就证明了在离散情况下，对于有环链表，二者也是必然在某一时刻相遇在某个节点上的。
	 *
	 */
	 /*
	 public boolean hasCycle(ListNode head) 
	 {
        if(head == null) 
        {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) 
            {
                return true;
            }
        }
        return false;
	 }*/
	
	
	/**
	 * leetcode上提交的答案中较为直观且容易理解的代码
	 * 其比以上自己所写的代码所用的时间和空间复杂度更高，但是
	 * 其不要求节点的值不能为某一个值，并且其对节点的操作不为破坏性的
	 * 
	 */
	/*
	public boolean hasCycle(ListNode head) 
	{
	    Set<ListNode> nodesSeen = new HashSet<>();
	    while (head != null) 
	    {
	        if (nodesSeen.contains(head)) 
	        {
	            return true;
	        } 
	        else 
	        {
	            nodesSeen.add(head);
	        }
	        head = head.next;
	    }
	    return false;
	}*/
	
}

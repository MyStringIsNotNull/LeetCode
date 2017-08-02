package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
You are given two non-empty linked lists representing two non-negative integers. 

The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

给定两个非空链表代表两个非负的整数

数字按照颠倒的顺序进行存储，并且每个节点只包含了单个数字，将这两个数字进行相加，并以链表的形式返回他们相加的结果

你需要假设两个数字都不包含前置0，除了数字0本身

输入:(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出:7 -> 0 -> 8
 */
public class AddTwoNumber
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
        ListNode h1=l1.next;
        ListNode h2=l2.next;
        int add=(l1.val+l2.val)%10;
        int carry=(l1.val+l2.val)/10;
        ListNode hr=new ListNode(add);
        ListNode result=hr;
        while(h1!=null&&h2!=null)
        {
        	int number=h1.val+h2.val+carry;
        	add=number%10;
        	carry=number/10;
        	h1=h1.next;
        	h2=h2.next;
        	hr.next=new ListNode(add);
        	hr=hr.next;
        }
        while(h1!=null)
        {
        	int number=h1.val+carry;
        	add=number%10;
        	carry=number/10;
        	h1=h1.next;
        	hr.next=new ListNode(add);
        	hr=hr.next;
        }
        while(h2!=null)
        {
        	int number=h2.val+carry;
        	add=number%10;
        	carry=number/10;
        	h2=h2.next;
        	hr.next=new ListNode(add);
        	hr=hr.next;
        }
        if(carry!=0)
        {
            hr.next=new ListNode(carry);
        }
        return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 
	 */
/*
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode node = null;
		ListNode result = null;
		int nextPlusValue = 0;
		int val1 = 0;
		int val2 = 0;
		while (l1 != null || l2 != null || nextPlusValue > 0)
		{
			val1 = val2 = 0;
			if (l1 != null)
			{
				val1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null)
			{
				val2 = l2.val;
				l2 = l2.next;
			}
			int value = (val1 + val2 + nextPlusValue);
			if (node == null)
			{
				result = node = new ListNode(0);
			} 
			else
			{
				//这一步，等价于node.next=new ListNode(0);
				//node=node.next;这两步
				node = node.next = new ListNode(0);
			}
			node.val = value % 10;
			nextPlusValue = value / 10;
		}
		return result;
	}*/
	
	
}

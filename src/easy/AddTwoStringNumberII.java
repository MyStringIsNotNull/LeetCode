package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
You are given two non-empty linked lists representing two non-negative integers. 

The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

给定两个非空的链表代表了两个非负的整数

数字的最高位出现在头部，并且其每个节点只包含了单独的一个数字，将这两个整数进行相加，并以链表的形式进行返回

你必须假设这两个数字均不包含前导0，除了0本身之外

接着：
如果不能该边输入的链表呢？换句话说，颠倒链表的行为是不被允许的

例子:
输入:(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出:7 -> 8 -> 0 -> 7


 */
public class AddTwoStringNumberII
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		Stack<Integer> n1=new Stack<Integer>();
		Stack<Integer> n2=new Stack<Integer>();
		ListNode h1=l1;
		ListNode h2=l2;
		while(h1!=null)
		{
			n1.push(h1.val);
			h1=h1.next;
		}
		while(h2!=null)
		{
			n2.push(h2.val);
			h2=h2.next;
		}
		return addTwoNumbers(n1,n2);
	}
	
	private ListNode addTwoNumbers(Stack<Integer> n1,Stack<Integer> n2)
	{
		int add=n1.pop()+n2.pop();
		ListNode hr=new ListNode(add%10);
		ListNode result=hr;
		int carry=add/10;
		while(!n1.isEmpty()||!n2.isEmpty()||carry!=0)
		{
			add=carry;
			if(!n1.isEmpty())
			{
				add+=n1.pop();
			}
			if(!n2.isEmpty())
			{
				add+=n2.pop();
			}
			ListNode tem=new ListNode(add%10);
			result=tem;
			tem.next=hr;
			hr=tem;
			carry=add/10;
		}
		return result;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其addTwoNumbers2方法符合题目的要求，但是addTwoNumbers方法不符合题目的要求
	 * 
	 */

/*	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2)
	{

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (l1 != null)
		{
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null)
		{
			stack2.push(l2.val);
			l2 = l2.next;
		}

		ListNode list = new ListNode(0);
		int sum = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty())
		{
			if (!stack1.isEmpty())
				sum += stack1.pop();
			if (!stack2.isEmpty())
				sum += stack2.pop();
			ListNode head = new ListNode(sum / 10);
			list.val = sum % 10;
			head.next = list;
			list = head;
			sum /= 10;
		}
		return list.val == 0 ? list.next : list;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{

		ListNode l1_r = reverse(l1);
		ListNode l2_r = reverse(l2);

		ListNode l1_cur = l1_r;
		ListNode l2_cur = l2_r;

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode l_result = dummy;

		int flag = 0;
		while (l1_cur != null && l2_cur != null)
		{
			int i = (l1_cur.val + l2_cur.val + flag) % 10;
			flag = (l1_cur.val + l2_cur.val + flag) / 10;
			l_result.next = new ListNode(i);

			l_result = l_result.next;
			l1_cur = l1_cur.next;
			l2_cur = l2_cur.next;
		}
		while (l1_cur != null)
		{
			int i = (l1_cur.val + flag) % 10;
			flag = (l1_cur.val + flag) / 10;
			l_result.next = new ListNode(i);
			l_result = l_result.next;
			l1_cur = l1_cur.next;
		}
		while (l2_cur != null)
		{
			int i = (l2_cur.val + flag) % 10;
			flag = (l2_cur.val + flag) / 10;
			l_result.next = new ListNode(i);
			l_result = l_result.next;
			l2_cur = l2_cur.next;
		}
		if (flag == 1)
		{
			l_result.next = new ListNode(1);
		}

		return reverse(dummy.next);

	}

	private ListNode reverse(ListNode head)
	{
		if (head == null || head.next == null)
			return head;

		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;
		while (cur != null)
		{
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;
	}*/
	
	/**
	 * leetcode上一份符合题目要求的接近运行时间最短的代码
	 * 
	 */
	/*
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode n0 = new ListNode(0), pcurr = n0;
		ListNode curr1 = l1, curr2 = l2;
		int cnt1 = 0, cnt2 = 0;
		while (curr1 != null)
		{
			curr1 = curr1.next;
			cnt1++;
		}
		while (curr2 != null)
		{
			curr2 = curr2.next;
			cnt2++;
		}
		for (int i = 0; i < Math.abs(cnt1 - cnt2); i++)
		{
			pcurr.next = new ListNode(0);
			pcurr = pcurr.next;
		}
		if (cnt1 < cnt2)
		{
			pcurr.next = l1;
			l1 = n0.next;
		} 
		else
		{
			pcurr.next = l2;
			l2 = n0.next;
		}

		ListNode res = sumup(l1, l2);
		return res.val == 0 ? res.next : res;
	}

	private ListNode sumup(ListNode l1, ListNode l2)
	{
		if (l1 == null && l2 == null)
		{
			return new ListNode(0);
		} 
		else
		{
			ListNode rest = sumup(l1.next, l2.next);
			int rval = rest.val + l1.val + l2.val;
			rest.val = rval % 10;
			ListNode newRest = new ListNode(rval / 10);
			newRest.next = rest;
			return newRest;
		}
	}
	*/
	
}

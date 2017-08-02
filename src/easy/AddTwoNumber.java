package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
You are given two non-empty linked lists representing two non-negative integers. 

The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

���������ǿ�������������Ǹ�������

���ְ��յߵ���˳����д洢������ÿ���ڵ�ֻ�����˵������֣������������ֽ�����ӣ������������ʽ����������ӵĽ��

����Ҫ�����������ֶ�������ǰ��0����������0����

����:(2 -> 4 -> 3) + (5 -> 6 -> 4)
���:7 -> 0 -> 8
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
	 * leetcode������ʱ����̵Ĵ���
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
				//��һ�����ȼ���node.next=new ListNode(0);
				//node=node.next;������
				node = node.next = new ListNode(0);
			}
			node.val = value % 10;
			nextPlusValue = value / 10;
		}
		return result;
	}*/
	
	
}

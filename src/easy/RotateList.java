package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

给定一个列表，旋转这个列表到右边，通过k个空间，k并不为负数
例如
给定1->2->3->4->5->NULL 和 k = 2,
返回 4->5->1->2->3->NULL.

 */
public class RotateList 
{
	public ListNode rotateRight(ListNode head, int k) 
	{
		if(head==null||k==0)
			return head;
		int length=0;
		ListNode temp=head;
		ListNode tem=null;
		while(temp!=null)
		{
			length++;
			if(temp.next==null)
				tem=temp;
			temp=temp.next;
		}
		tem.next=head;
		temp=head;
		//此处k%length运算的原因是因为，去除掉循环的次数
		length-=(k%length+1);
		while(length!=0)
		{
			temp=temp.next;
			length--;
		}
		head=temp.next;
		temp.next=null;
		return head;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 代码的思路同自己所写的代码的思路保持一致
	 */
	
	/*
	public ListNode rotateRight(ListNode head, int k) 
	{
        if (head==null||head.next==null) 
        	return head;
	    ListNode dummy=new ListNode(0);
	    dummy.next=head;
	    ListNode fast=dummy,slow=dummy;
	    int i;
	    for (i=0;fast.next!=null;i++)//Get the total length 
	    	fast=fast.next;
	    
	    for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
	    	slow=slow.next;
	    
	    fast.next=dummy.next; //Do the rotation
	    dummy.next=slow.next;
	    slow.next=null;
	    
	    return dummy.next;
    }
	*/
	
}

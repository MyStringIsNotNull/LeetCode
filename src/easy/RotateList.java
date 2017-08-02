package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

����һ���б���ת����б��ұߣ�ͨ��k���ռ䣬k����Ϊ����
����
����1->2->3->4->5->NULL �� k = 2,
���� 4->5->1->2->3->NULL.

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
		//�˴�k%length�����ԭ������Ϊ��ȥ����ѭ���Ĵ���
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
	 * leetcode������ʱ����̵Ĵ���
	 * �����˼·ͬ�Լ���д�Ĵ����˼·����һ��
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

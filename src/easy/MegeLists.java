package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

�ϲ��������ź�����������ظúϲ��������������Ӧ��ͨ��ƴ��ǰ��������Ľڵ�����ɡ�

 */
public class MegeLists 
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
        ListNode together=l1;
        ListNode previous=l1;
        while(l1!=null&&l2!=null)
        {
        	if(l1.val<l2.val)
        	{
        		previous=l1;
        		l1=l1.next;
        	}
        	else
        	{
        		ListNode node=new ListNode(l2.val);
        		if(previous!=l1)
        		{
	        		previous.next=node;
	        		node.next=l1;
	        		previous=node;
	        		l2=l2.next;
        		}
        		else
        		{
        			node.next=together;
        			together=node;
        			previous=l1;
        			l1=together;
        			l2=l2.next;
        		}
        	}
        }
        if(l2!=null&&l1==null)
        {
        	if(together==null)
        	{
        		together=l2;
        	}
        	else
        	{
        		previous.next=l2;
        	}
        }
        return together;
	}
	
	
	/**
	 * leetcode�ϻ���ʱ�����ٵĴ���
	 * ps:�о����������㣬����
	 */
	 /*public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	 {
	        ListNode temp;
	        ListNode begin;
	        if(l1==null) 
	        	return l2;
	        else if(l2==null) 
	        	return l1;
	        else
	        {
	            if(l1.val<l2.val)
	            {
	                begin = l1;
	                l1 = l1.next;
	            }
	            else
	            {
	                begin = l2;
	                l2 = l2.next;
	            }
	        }
	        temp = begin;
	        while(l1!=null&l2!=null)
	        {
	            if(l1.val<l2.val)
	            {
	                temp.next = l1;
	                l1 = l1.next;
	            }
	            else
	            {
	                temp.next = l2;
	                l2 = l2.next;
	            }
	            temp = temp.next;
	        }
	        if(l1 == null)
	            l1 = l2;
	        temp.next = l1;
	        return begin;
	    }*/
}

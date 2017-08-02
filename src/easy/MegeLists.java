package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

合并两个已排好序的链表并返回该合并后的链表。新链表应该通过拼接前两个链表的节点来完成。

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
	 * leetcode上花费时间最少的代码
	 * ps:感觉这代码很优秀，荐读
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

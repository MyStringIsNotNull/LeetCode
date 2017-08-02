package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Reverse a singly linked list.

��ת������

 */
public class ReverseLinkedList 
{
	public ListNode reverseList(ListNode head)
	{
        ListNode reverse=null;
        ListNode headPrevious=head;
        while(head!=null)
        {
        	headPrevious=head;
        	head=head.next;
        	headPrevious.next=reverse;
        	reverse=headPrevious;
        }
        return reverse;
    }
	/**
	 * 
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼��ͬ�Լ���д�Ĵ��룬���Ǳ��Լ�д��˼·��������һЩ
	 * 
	 */
	
	/*
	public ListNode reverseList(ListNode head)
	{
        ListNode newlist = null;
        while(head!=null)
        {
            ListNode nextnode = head.next;
            head.next = newlist;
            newlist = head;
            head = nextnode;
        }
        return newlist;
    }
	*/
	
}

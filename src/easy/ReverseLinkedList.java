package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Reverse a singly linked list.

翻转单链表

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
	 * leetcode上运行时间最短的代码
	 * 其思想同自己所写的代码，但是比自己写的思路更加清晰一些
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

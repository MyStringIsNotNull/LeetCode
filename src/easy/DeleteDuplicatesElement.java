package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 


给定一个排好序的链表，删除所有重复的的元素以使其每个元素只出现一个
例如:
给定链表：
1->1->2, 返回 1->2.
1->1->2->3->3, 返回 1->2->3. 

 */

class ListNodes
{
      int val;
      ListNodes next;
      ListNodes(int x) 
      {
    	  val = x; 
      }
 }
 
public class DeleteDuplicatesElement
{
	public ListNodes deleteDuplicates(ListNodes head) 
	{
        ListNodes node=head;
        while(node!=null&&node.next!=null)
        {
        	if(node.next.val==node.val)
        		node.next=node.next.next;
        	else
        		node=node.next;
        }
        return head;
    }
}

package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 

移除链表中所有值为val的元素

例如:
给定:1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
返回:1 --> 2 --> 3 --> 4 --> 5 

 */
public class RemoveLinkedListElement 
{
	public ListNode removeElements(ListNode head, int val) 
	{
		//将第一个元素指向非val的值的元素
        while(head!=null&&head.val==val)
        {
        	head=head.next;
        }
        ListNode nextNode=null;
        ListNode node=head;
        if(head!=null)
        	nextNode=node.next;
        while(nextNode!=null)
        {
        	//当找到nextNode的元素的值为val的时候，将其进行删除
        	if(nextNode.val==val)
        	{
        		node.next=nextNode.next;
        		nextNode=nextNode.next;
        	}
        	//当没有找到的时候，继续执行
        	else
        	{
        		node=nextNode;
        		nextNode=nextNode.next;
        	}
        }
        return head;
    }
	/**
	 * leetcode上运行时间最短的代码
	 *其思路同自己所写的代码的思路
	 */
	
	/*
	 public ListNode removeElements(ListNode head, int val) 
	 {
	        if(head == null) return null;
	        ListNode currentNode = head;
	        while(currentNode.next!=null)
	        {
	            if(currentNode.next.val == val) 
	            	currentNode.next = currentNode.next.next;
	            else 
	            	currentNode = currentNode.next;
	        }
	        return (head.val == val)?head.next:head;
	        
//	         ListNode currentNode = head;
//	         ListNode parentNode = null;
//	         while(currentNode!=null){
//	             if(currentNode.val == val){
//	                 if(parentNode == null){
//	                     head = currentNode.next;
//	                     currentNode = currentNode.next;
//	                 }else{
//	                     currentNode = currentNode.next;
//	                     parentNode.next = currentNode;
	                    
//	                 }
//	             }else{
//	                 parentNode = currentNode;
//	                 currentNode = currentNode.next;
//	             }
//	         }
//	         return head;
	    }
	*/
	
	
}

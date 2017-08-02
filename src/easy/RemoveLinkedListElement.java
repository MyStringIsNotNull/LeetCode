package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 

�Ƴ�����������ֵΪval��Ԫ��

����:
����:1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
����:1 --> 2 --> 3 --> 4 --> 5 

 */
public class RemoveLinkedListElement 
{
	public ListNode removeElements(ListNode head, int val) 
	{
		//����һ��Ԫ��ָ���val��ֵ��Ԫ��
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
        	//���ҵ�nextNode��Ԫ�ص�ֵΪval��ʱ�򣬽������ɾ��
        	if(nextNode.val==val)
        	{
        		node.next=nextNode.next;
        		nextNode=nextNode.next;
        	}
        	//��û���ҵ���ʱ�򣬼���ִ��
        	else
        	{
        		node=nextNode;
        		nextNode=nextNode.next;
        	}
        }
        return head;
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 *��˼·ͬ�Լ���д�Ĵ����˼·
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

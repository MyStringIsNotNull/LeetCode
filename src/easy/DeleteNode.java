package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 

the linked list should become 1 -> 2 -> 4 after calling your function.  

编写一个函数，在单链表中去删除节点(除了尾部节点)

假定链表为1 -> 2 -> 3 -> 4 和给定第三个节点的值为3

在调用了函数之后，链表将变为1 -> 2 -> 4

 */
public class DeleteNode 
{
	//ps:给定的参数即为要进行删除的那个节点
	/**
	 * 其思路为，将后一节点的值赋给当前节点，之后，删除该节点的后一节点
	 */
	public void deleteNode(ListNode node) 
	{
        if(node==null)
        	return;
        if(node.next==null)
        	node=null;
        else
        {
        	node.val=node.next.val;
        	node.next=node.next.next;
        }
    }
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路同上自己所写，但是这里的代码可能会出现bug，其没有考虑空指针异常的情况
	 */
	
	/*
	public void deleteNode(ListNode node)
	{
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	*/
	
}

package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 

the linked list should become 1 -> 2 -> 4 after calling your function.  

��дһ���������ڵ�������ȥɾ���ڵ�(����β���ڵ�)

�ٶ�����Ϊ1 -> 2 -> 3 -> 4 �͸����������ڵ��ֵΪ3

�ڵ����˺���֮��������Ϊ1 -> 2 -> 4

 */
public class DeleteNode 
{
	//ps:�����Ĳ�����ΪҪ����ɾ�����Ǹ��ڵ�
	/**
	 * ��˼·Ϊ������һ�ڵ��ֵ������ǰ�ڵ㣬֮��ɾ���ýڵ�ĺ�һ�ڵ�
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
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·ͬ���Լ���д����������Ĵ�����ܻ����bug����û�п��ǿ�ָ���쳣�����
	 */
	
	/*
	public void deleteNode(ListNode node)
	{
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	*/
	
}

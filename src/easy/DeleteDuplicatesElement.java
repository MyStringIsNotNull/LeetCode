package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 


����һ���ź��������ɾ�������ظ��ĵ�Ԫ����ʹ��ÿ��Ԫ��ֻ����һ��
����:
��������
1->1->2, ���� 1->2.
1->1->2->3->3, ���� 1->2->3. 

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

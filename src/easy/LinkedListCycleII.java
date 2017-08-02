package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space? 

����һ���������ص�һ��ѭ���Ľڵ㣬���������ѭ��������null

��ʾ:
��ȥ�޸�����

����:
���ܹ�û��ʹ�ö���Ŀռ�ȥ������������

 */
public class LinkedListCycleII 
{
	public ListNode detectCycle(ListNode head) 
	{
        ListNode cycle=null;
        Set<ListNode> set=new HashSet<ListNode>();
        while(head!=null)
        {
        	if(set.contains(head))
        	{
        		cycle=head;
        		break;
        	}
        	set.add(head);
        	head=head.next;
        }
        return cycle;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �ɲμ�LinkedListCysle�Ĵ����˼·
	 * 
	 */
	/*
	public ListNode detectCycle(ListNode head)
	{        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) 
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) //������ָ��������ʱ��֤�����л������еĴ���Ŀ��Ϊ�ҵ����ɻ����Ǹ��ڵ�(�������β�ڵ���¸��ڵ�)
            {
            	 *
            	 * ������ĵ�һ���ڵ��slow��fast�������Ǹ��ڵ㿪ʼ��һ��һ�����ߣ������������Ǹ����㣬����
            	 *����ʼѭ�����Ǹ��ڵ�
            	 *��ϸ���: http://www.cnblogs.com/hiddenfox/p/3408931.html ����
            	 *�ò��ĵĵ����������У������Ϊ��ȷ�ģ�����֤���������е�����
            	 *
                ListNode newNode = head;
                while(newNode != slow) 
                {
                    newNode = newNode.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }*/
	
}

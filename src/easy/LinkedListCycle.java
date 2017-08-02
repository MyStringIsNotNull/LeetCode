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
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

����һ�������ж����Ƿ���ѭ������

����:
���ܹ�û��ʹ�ö���Ŀռ�ȥ������������

 */
public class LinkedListCycle 
{
	/*
	 * �÷�����˼·Ϊ�����������Ľڵ��ֵ����Ϊĳһ���ض���ֵ�����ڱ�ʾ�����������Խڵ��ֵ���ƻ��Եģ�����ڵ��ֵ
	 * ���ܵ���ĳһ��ֵ
	 */
	public boolean hasCycle(ListNode head) 
	{
		boolean result=false;
		ListNode temp=null;
		if(head!=null)
		{
			//���ڱ�Ǳ�ʾ�ýڵ������
			head.val=Integer.MAX_VALUE;
			temp=head.next;
		}
		while(temp!=null)
		{
			if(temp.val==Integer.MAX_VALUE)
			{
				result=true;
				break;
			}
			temp.val=Integer.MAX_VALUE;
			temp=temp.next;
		}
		return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 *
	 *��˼·����:
	 *��ҿ�������һ�����⣬����Ļ��൱��һ��Բ�βٳ���
	 *��������������Բ�βٳ�������ѭ�����ܣ���ô�ٶȿ��һ����׷�����ٶ����ġ�(��仰Ϊ�ص�)
	 *ͬ����Ҫ�ж�һ�������Ƿ��л�������ƿ���ָ�룬������ָ�붼���뻷��ʱ������������ָ���������ؿ�˵��������ڻ���
	 *�����Ҫ���ǿ���ָ��Ĳ��������ܲٳ���������������������ж���������ж�죬���տ϶���������
	 *ͬ�������У�Ҳ������ָ������ָ��Ĳ������޷Ǿ����ܵ�Ȧ�����ٵ����⡣
	 *
	 *һ����ԣ����ǲ��ÿ�ָ����ٶ�Ϊÿ�������ڵ㣬��ָ����ٶ�Ϊÿ��һ���ڵ���ٶȽ���
	 *�����Ļ��������������(p1��p2�ֱ�Ϊ��ָ��Ϳ�ָ��)
	 *������ʱ�̣�p1��p2���ڻ��ϡ�����p1ÿ����ǰ1����p2ÿ����ǰ������������˶��Ĺ۵���������p1������ֹ��
	 *��ôp2ÿ�����p1��ǰ1����������˳ʱ�뷽���ϵľ���ÿ����һ��ʱ�̾ͼ���1��ֱ����Ϊ0��Ҳ������ǡ��������
	 *������֤��������ɢ����£������л���������Ҳ�Ǳ�Ȼ��ĳһʱ��������ĳ���ڵ��ϵġ�
	 *
	 */
	 /*
	 public boolean hasCycle(ListNode head) 
	 {
        if(head == null) 
        {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) 
            {
                return true;
            }
        }
        return false;
	 }*/
	
	
	/**
	 * leetcode���ύ�Ĵ��н�Ϊֱ�����������Ĵ���
	 * ��������Լ���д�Ĵ������õ�ʱ��Ϳռ临�Ӷȸ��ߣ�����
	 * �䲻Ҫ��ڵ��ֵ����Ϊĳһ��ֵ��������Խڵ�Ĳ�����Ϊ�ƻ��Ե�
	 * 
	 */
	/*
	public boolean hasCycle(ListNode head) 
	{
	    Set<ListNode> nodesSeen = new HashSet<>();
	    while (head != null) 
	    {
	        if (nodesSeen.contains(head)) 
	        {
	            return true;
	        } 
	        else 
	        {
	            nodesSeen.add(head);
	        }
	        head = head.next;
	    }
	    return false;
	}*/
	
}

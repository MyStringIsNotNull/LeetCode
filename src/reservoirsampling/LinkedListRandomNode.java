package reservoirsampling;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a singly linked list, return a random node's value from the linked list. 
����һ������ʽ�б����з���һ������Ľڵ��ֵ
Each node must have the same probability of being chosen.
ÿһ���ڵ����Ҫ�ȿ��ܵı�ѡ��
Follow up:
���ţ�
What if the linked list is extremely large and its length is unknown to you? 
�����ʽ�б�ķǳ��ĳ��������ֲ�֪�����б�ĳ����أ�
Could you solve this efficiently without using extra space?
������û��ʹ�ö���ռ������£���Ч�Ľ�����������?
Example:
���磺
// Init a singly linked list [1,2,3].
//��ʼ��һ�������б�[1,2,3]
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
getRandom()Ӧ���������1��2��3�е�һ����ÿһ��Ԫ��Ӧ���еȿ��ܵĻ�����з���

 */
public class LinkedListRandomNode
{
	 // Definition for singly-linked list.
	 class ListNode 
	 {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 /** 
	 @param head The linked list's head.
     Note that the head is guaranteed to be not null, so it contains at least one node. 
     */
	 /**
	  	* �����˼·Ϊ:
	  	* һ�����˵, �����ȼ��������, Ȼ�����һ���ڳ��ȷ�Χ�ڵ�ֵ, 
	  	* �ߵ����ｫֵ���ؼ���. ��������������޴�, ���޷����㳤����,
	  	* ��������³�Ϊһ��ˮ�س������㷨, ��ԭ��Ϊһ�����Ķ�Ԫ��ȡ��,
	  	* �ڱ�����ÿ��Ԫ�ص�ʱ������и�����ѡȡ, ���߲�ѡȡ. 
	  	* ��Ϊ�����ѡȡһ����, �����൱��ˮ�ص�������1. ��Լ�һЩ.
		* ��ô���ȷ������ÿ��Ԫ�ض�����ȵĸ�����? �����õ��˸����۵�֪ʶ,
		* �ڱ�������i����ʱ����ѡȡ������ĸ���Ϊ1/i, Ȼ����֤��һ��ÿ������ѡ���ĸ���: 
		* ���ڵ�һ�����䱻ѡ��ĸ���Ϊ1/1*(1-1/2)*(1-1/3)*(1-1/4)*...*(1-1/n) = 1/n,
		* ����(1-1/n)����˼�ǲ�ѡ��n�ĸ���, Ҳ����ѡ��1�ĸ��ʳ��Բ�ѡ���������ĸ���. 
		* ��������һ����i��˵, �䱻ѡ��ĸ���Ϊ1/i*(1-1/(i+1))*...*(1-1/n), 
		* ������ÿһ������ʱ������ֻҪ�������һ���Ƿ���i�ı������ɾ����Ƿ�ȡ��ǰ������.
		* 
	  */
	 private ListNode head;
	 public LinkedListRandomNode(ListNode head) 
	 {
		 this.head=head;
	 }
 
	 /** 
	  * Returns a random node's value. 
	  */
	 public int getRandom() 
	 {
		 ListNode p=head;
		 int val=p.val;
		 java.util.Random r=new java.util.Random();  
	     for (int i = 1; p!=null; i++) 
        {  
            if (r.nextInt(i)==0) 
            {  
                val=p.val;  
            }  
            p=p.next;  
        }  
		 return val;
	 }
	 /**
	  * Your Solution object will be instantiated and called as such:
	  * Solution obj = new Solution(head);
	  * int param_1 = obj.getRandom();
	  *
	  *��Ľ�������Ķ��󽫻ᱻʵ�����������·�ʽ���е��ã�
	  *Solution obj=new Solution(head);
	  *int param_1=obj.getRandom();
	  *
	  */
	 
	 /**
	  * leetcode������ʱ����̵Ĵ���
	  * 
	  */
/*
	Random r = new Random();
	ListNode head;

	public Solution(ListNode head)
	{
		this.head = head;
	}

	public int getRandom()
	{
		ListNode p = head;
		int v = p.val;
		int count = 1;
		while (p.next != null)
		{
			if (r.nextInt(count + 1) == count)
				v = p.next.val;
			p = p.next;
			count++;
		}
		return v;
	}*/
	 
}

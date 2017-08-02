package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

����һ���������ж����Ƿ�Ϊ����

����:
������ʱ�临�Ӷ�ΪO(n)�ռ临�Ӷ�ΪO(1)������½�����������


 */
public class PalindromeLinkedList 
{
	/**
	 * ʹ�ø��㷨��ʱ����ʱ�䳬�����ύ����
	 */
	/*
	 public boolean isPalindrome(ListNode head) 
	{
        //���ڱ����Ϊ�������ڵ㻹��ż�����ڵ㣬Ϊ������Ϊtrue
        boolean odd=true;
		String order="";
		String disOrder="";
		ListNode temp=head;
		int length=0;
		while(temp!=null)
		{
			length++;
			temp=temp.next;
		}
        if(length%2==0)
            odd=false;
		temp=head;
		length=length/2;
		for(int i=0;i<length;i++)
		{
			temp=temp.next;
		}
		for(int i=0;i<length;i++)
		{
			order+=head.val;
			head=head.next;
			disOrder=temp.val+disOrder;
			temp=temp.next;
		}
        if(odd)
        {
            order+=head.val;
			head=head.next;
			disOrder=temp.val+disOrder;
			temp=temp.next;
        }
		return order.toString().equals(disOrder.toString());
    }
	 */
	
	 public boolean isPalindrome(ListNode head) 
	{
		 boolean result=true;
		 StringBuffer order=new StringBuffer();
		 while(head!=null)
		 {
			 order.append(head.val+" ");
			 head=head.next;
		 }
		 String[] c=order.toString().split(" ");
		 int low=0;
		 int high=c.length-1;
		 while(low<high)
		 {
			 if(!c[low].equals(c[high]))
			 {
				 result=false;
				 break;
			 }
			 low++;
			 high--;
		 }
		 return result;
	}
	 /**
	  * leetcode������ʱ����̵Ĵ���
	  * ��˼·Ϊ:��ת��������һ��Ľڵ㣬Ȼ�����ǰ�󲿷ֽ��бȽ�
	  * 
	  */
	 
	 /*
	 public boolean isPalindrome(ListNode head)
	 {
	        if(head == null) 
	        	return true;
	        ListNode p1 = head;
	        ListNode p2 = head;
	        ListNode temp =head;
	        //���ڽ�ǰ�벿�ֵ�����ڵ���з�ת����ԭ��Ϊp2ÿ����2������p1ÿ��ֻ��һ������p2����ȫ��
	        //��ʱ��p1��ת��һ�������
	        while(p2.next != null && p2.next.next != null)
	        {
	            p1 = p1.next;
	            p2 = p2.next.next;
	            temp.next = p1.next;
	            p1.next = head;
	            head = p1;
	            p1 = temp;
	        }
	        //�м�λ�õĽڵ�����м�λ�õĽڵ����һ��
	        ListNode p3 = p1.next;
	        //������Ϊ��������ʱ�����ڽ��м���Ǹ���ת�����ͷ����Ϊ�ˣ�����֤��ʱ����ȥ����
	        if(p2.next == null)
	        {
	            head = head.next;
	        }
	       //�����ж����Ƿ�Ϊ����
	        while(head!= null && p3!=null)
	        {
	            if(head.val != p3.val)
	            {
	                return false;
	            }
	            head = head.next;
	            p3 = p3.next;
	        }
	        return true;
	    }
	    */
	 
	 /**
	  * 
	  * leetcode������ʱ��ζ̵Ĵ���
	  * ��˼·Ϊ
	  * 
	  */
	 /*
	 public boolean isPalindrome(ListNode head) 
	 {
	        if(head == null || head.next==null)
	        	return true;
	        ListNode first = head;
	        ListNode slow = head;
	        ListNode fast = head;
	        //��һ����ָ���һ����ָ�룬�����ҳ���������м���Ǹ��ڵ㣬��Ϊ����ʱ��slowָ���м��Ǹ��ڵ㣬��Ϊż��ʱ����ָ�����
	        //֮һ���Ǹ��ڵ�
	        while(fast.next != null && fast.next.next != null) 
	        {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        //����ָ��ת��ĺ�벿�ֵĽڵ�
	        ListNode second = reverse(slow.next);
	        slow.next = null;
	        //�����жϽڵ��Ƿ�Ϊ����
	        //�˴���second!=null��Ϊѭ������������ô����ڣ�����˽ڵ�����Ϊ��ż�ĸ��š�ͬʱ��������ڷ�ת�˺�벿�ֵĽڵ�
	        while(second != null) 
	        {
	            if(first.val != second.val)
	             {
	                return false;
	            }
	            first = first.next;
	            second = second.next;
	        }
	        return true;
	    }
	    //���ڷ�ת��head����ʼ�Ľڵ�
	    private ListNode reverse(ListNode head) 
	    {
	        ListNode prev = null;
	        while(head != null) 
	        {
	            ListNode next = head.next;
	            head.next = prev;
	            prev = head;
	            head = next;
	        }
	        return prev;
	        
	    }
	    
	    */
}

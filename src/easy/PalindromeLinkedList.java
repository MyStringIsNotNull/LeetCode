package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

给定一个单链表，判断其是否为回文

继续:
你能在时间复杂度为O(n)空间复杂度为O(1)的情况下解决这个问题吗？


 */
public class PalindromeLinkedList 
{
	/**
	 * 使用该算法的时候，其时间超过，提交不了
	 */
	/*
	 public boolean isPalindrome(ListNode head) 
	{
        //用于标记其为奇数个节点还是偶数个节点，为奇数是为true
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
	  * leetcode上运行时间最短的代码
	  * 其思路为:翻转单链表中一半的节点，然后对其前后部分进行比较
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
	        //用于将前半部分的链表节点进行翻转，其原理为p2每次走2步，而p1每次只走一步，故p2走完全程
	        //的时候，p1翻转了一般的链表
	        while(p2.next != null && p2.next.next != null)
	        {
	            p1 = p1.next;
	            p2 = p2.next.next;
	            temp.next = p1.next;
	            p1.next = head;
	            head = p1;
	            p1 = temp;
	        }
	        //中间位置的节点或者中间位置的节点的下一个
	        ListNode p3 = p1.next;
	        //当链表为奇数个的时候，由于将中间的那个翻转到了最开头处，为此，在验证的时候将其去除掉
	        if(p2.next == null)
	        {
	            head = head.next;
	        }
	       //用于判断其是否为回文
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
	  * leetcode上运行时间次短的代码
	  * 其思路为
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
	        //用一个快指针和一个慢指针，用于找出其链表的中间的那个节点，当为奇数时，slow指向中间那个节点，当为偶数时，其指向二分
	        //之一的那个节点
	        while(fast.next != null && fast.next.next != null) 
	        {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        //用于指向翻转后的后半部分的节点
	        ListNode second = reverse(slow.next);
	        slow.next = null;
	        //用于判断节点是否为回文
	        //此处用second!=null作为循环的条件，其好处在于，免除了节点总数为奇偶的干扰。同时，其得益于翻转了后半部分的节点
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
	    //用于翻转从head处开始的节点
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

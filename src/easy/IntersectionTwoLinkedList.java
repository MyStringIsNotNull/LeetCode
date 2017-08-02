package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:   			a1 → a2
                   			↘
                     			c1 → c2 → c3
                   			↗            
B:  b1 → b2 → b3

begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

编写一个程序找出两个单独的链表开始交叉的节点
例如,如下的两个链表:
A:   			a1 → a2
                   			↘
                     			c1 → c2 → c3
                   			↗            
B:  b1 → b2 → b3
在节点c1开始进行交叉
注意：
如果两个链表没有进行交叉，返回null
在函数返回之后链表必须保留它们自身原始的结构
你必须假设在整个链表结构的任何位置中都没有循环的存在
你的代码必须要完美的运行在O(n)的时间复杂度上并使用O(1)的空间复杂度

 */
public class IntersectionTwoLinkedList 
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
	{
		ListNode result=null;
		//用于记录下两个链表的长度
		int lengthA=0;
		int lengthB=0;
		//用于暂时指向两个链表
		ListNode tempA=headA;
		ListNode tempB=headB;
		//用于计算两个链表的长度
		while(tempA!=null)
		{
			lengthA++;
			tempA=tempA.next;
		}
		while(tempB!=null)
		{
			lengthB++;
			tempB=tempB.next;
		}
		//用于将较长的链表缩短到与较小的那个链表的长度一致，即tempA和tempB指向链表1和链表2的距离末尾长度一致的那个节点
		tempA=headA;
		tempB=headB;
		while(lengthA!=lengthB)
		{
			if(lengthA>lengthB)
			{
				tempA=tempA.next;
				lengthA--;
			}
			else
			{
				tempB=tempB.next;
				lengthB--;
			}
		}
		while(tempA!=tempB)
		{
			tempA=tempA.next;
			tempB=tempB.next;
		}
		result=tempA;
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码不如自己所写的清晰，但是其思路和自己所写的那代码的思路保持一致
	 * 
	 */
	/*
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; 
        }
        ListNode iteA = headA; 
        ListNode iteB = headB; 
        int countA = 1; 
        int countB = 1; 
        while (iteA.next != null) {
            countA++; 
            iteA = iteA.next; 
        }
        while (iteB.next != null) {
            countB++; 
            iteB = iteB.next; 
        }
        if (iteA != iteB) {
            return null; 
        }
        iteA = headA; 
        iteB = headB; 
        while (countA > countB) {
            countA--; 
            iteA = iteA.next; 
        }
        while (countA < countB) {
            countB--; 
            iteB = iteB.next; 
        }
        while (iteA != iteB) {
            iteA = iteA.next; 
            iteB = iteB.next; 
        }
        
        return iteA; 
    }
	*/
}

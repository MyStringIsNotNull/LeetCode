package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:   			a1 �� a2
                   			�K
                     			c1 �� c2 �� c3
                   			�J            
B:  b1 �� b2 �� b3

begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

��дһ�������ҳ���������������ʼ����Ľڵ�
����,���µ���������:
A:   			a1 �� a2
                   			�K
                     			c1 �� c2 �� c3
                   			�J            
B:  b1 �� b2 �� b3
�ڽڵ�c1��ʼ���н���
ע�⣺
�����������û�н��н��棬����null
�ں�������֮��������뱣����������ԭʼ�Ľṹ
������������������ṹ���κ�λ���ж�û��ѭ���Ĵ���
��Ĵ������Ҫ������������O(n)��ʱ�临�Ӷ��ϲ�ʹ��O(1)�Ŀռ临�Ӷ�

 */
public class IntersectionTwoLinkedList 
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
	{
		ListNode result=null;
		//���ڼ�¼����������ĳ���
		int lengthA=0;
		int lengthB=0;
		//������ʱָ����������
		ListNode tempA=headA;
		ListNode tempB=headB;
		//���ڼ�����������ĳ���
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
		//���ڽ��ϳ����������̵����С���Ǹ�����ĳ���һ�£���tempA��tempBָ������1������2�ľ���ĩβ����һ�µ��Ǹ��ڵ�
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
	 * leetcode������ʱ����̵Ĵ���
	 * ����벻���Լ���д��������������˼·���Լ���д���Ǵ����˼·����һ��
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

package reservoirsampling;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a singly linked list, return a random node's value from the linked list. 
给定一个单链式列表，从中返回一个随机的节点的值
Each node must have the same probability of being chosen.
每一个节点必须要等可能的被选中
Follow up:
接着：
What if the linked list is extremely large and its length is unknown to you? 
如果链式列表的非常的长，而你又不知道其列表的长度呢？
Could you solve this efficiently without using extra space?
你能在没有使用额外空间的情况下，高效的解决这个问题吗?
Example:
例如：
// Init a singly linked list [1,2,3].
//初始化一个单链列表[1,2,3]
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
getRandom()应该随机返回1，2，3中的一个。每一个元素应该有等可能的机会进行返回

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
	  	* 代码的思路为:
	  	* 一般的来说, 可以先计算出长度, 然后随机一个在长度范围内的值, 
	  	* 走到那里将值返回即可. 但是如果长度无限大, 就无法计算长度了,
	  	* 这种情况下成为一个水池抽样的算法, 其原理为一个个的对元素取样,
	  	* 在遍历到每个元素的时候可以有个概率选取, 或者不选取. 
	  	* 因为是随机选取一个数, 所以相当于水池的容量是1. 相对简单一些.
		* 那么如何确保对于每个元素都有相等的概率呢? 这里用到了概率论的知识,
		* 在遍历到第i个数时设置选取这个数的概率为1/i, 然后来证明一下每个数被选到的概率: 
		* 对于第一个数其被选择的概率为1/1*(1-1/2)*(1-1/3)*(1-1/4)*...*(1-1/n) = 1/n,
		* 其中(1-1/n)的意思是不选择n的概率, 也就是选择1的概率乘以不选择其他数的概率. 
		* 对于任意一个数i来说, 其被选择的概率为1/i*(1-1/(i+1))*...*(1-1/n), 
		* 所以在每一个数的时候我们只要按照随机一个是否是i的倍数即可决定是否取当前数即可.
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
	  *你的解决方法的对象将会被实例化并按如下方式进行调用：
	  *Solution obj=new Solution(head);
	  *int param_1=obj.getRandom();
	  *
	  */
	 
	 /**
	  * leetcode上运行时间最短的代码
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

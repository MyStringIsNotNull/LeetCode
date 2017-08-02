package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

给定一个具有n+1个整数的数组，每个整数都在1到n(包括了n)之间

这证明其最小的重复出现的数必定存在，假设其只有一个重复的数,找到那个重复的数

提示:
你不能去改变数组(假设这个数组是只读的)
你必须使用常数即O(1)的空间复杂度
你的算法时间复杂度必须小于O(n^2)
在数组中只有一个重复的数，但它可能会重复出现多次

 */

public class FindDuplicateNumber 
{
	/**
	 * 该算法的思路为：
	 * 采用二分法加上抽屉分离，其时间复杂度为O(nlogn)
	 * 
	 */
	public int findDuplicate(int[] nums) 
	{
		//重复的数字出现的范围
		int low=1;
		int high=nums.length-1;
		//ps:当while循环结束时，low=high，此时该数字即为重复出现了的
		while(low<high)
		{
			int mid=(low+high)>>>1;
			int count=0;
			for(int i=0;i<nums.length;i++)
			{
				//统计小于等于mid的数字的个数
				if(nums[i]<=mid)
				{
					count++;
				}
			}
			//当小于等于中间值的个数大于mid的时候，其可能重复的数字的范围为[low,mid]
			//如果小于等于mid的数，每个数只出现了一次或者没有出现,则小于等于中间值的数字的个数理论上是小于等于mid的
			//当其大于mid的时候，其表明在[low,mid]的范围内出现了重复的数字
			if(count>mid)
			{
				high=mid;
			}
			//当小于等于中间值的个数小于mid的时候，说明其出现重复的数字是在mid往右的范围里，既其可能重复的数字的范围为[mid+1,high]
			else
			{
				low=mid+1;
			}
		}
		return low;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其思路为:
	 * 将数组看成编号为从0到n的n个节点，其数组对应下标所对应的数组元素的值表示从数组下标的节点
	 * 到数组元素的值的节点所对应的一条有向边，因为其第0号数组元素一定不会产生自环
	 * (因为0到n号元素所对应的值只能为1到n，所以不存在第0号元素的值为0的情况，当第0号元素的值为0，且拿第0号元素
	 * 作为起始节点的时候，其会出现自环的情况，而导致bug的出现
	 * )，
	 * 同时，由于其一定存在重复的元素，且其重复的元素的个数为1个，则该重复的元素在图中的表示有两种可能
	 * 第一:一个节点链接到该重复节点，该重复节点本身存在自环
	 * 第二:一个节点链接到该重复节点，该重复节点链接到另一节点，该另外的节点最终会链接会该重复的节点
	 * 无论以上那种情况，其均存在重复节点为起始节点和末尾节点的环
	 * 为此，采用快慢指针的走法，从而得到该重复的节点
	 * 
	 * ps：该题的思想同LinkedList的那题，只是将链表的数据结构改换成了数组
	 * 该算法的时间复杂度为O(n)
	 */
	/*
	public int findDuplicate(int[] nums) 
	{
        if (nums.length > 1)
        {
        	//关键点在于选择第0号节点为起始走快慢指针的节点
            int slow = nums[0];
            int fast = nums[nums[0]];
            //当其退出该循环的时候，其slow和fast均进入了循环的圈内
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            //用于找到该重复的节点的值
            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
	*/
}

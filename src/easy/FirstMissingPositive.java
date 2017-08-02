package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 

给定一个未排序的整型数组，找到其第一个丢失的正整数

例如:

给定[1,2,0] 返回3，

给定[3,4,-1,1] 返回2

你的算法必须运行具有O(n)的时间复杂度和具有O(1)的空间复杂度

 */
public class FirstMissingPositive 
{
	/**
	 * 此方法时间复杂度为O(n)，但是空间复杂度为O(n)
	 * 不符合题目的要求，为此采用如leetcode上的方法
	 */
	public int firstMissingPositive(int[] nums) 
	{
		int result=1;
		if(nums!=null&&nums.length!=0)
		{
			int max=nums[0];
			for(int i:nums)
			{
				if(max<i)
					max=i;
			}
			if(max>0)
			{
				result=max+1;
				boolean[] check=new boolean[max+1];
				for(int i:nums)
				{
					if(i>0&&!check[i])
						check[i]=true;
				}
				for(int i=1;i<=max;i++)
				{
					if(!check[i])
					{
						result=i;
						break;
					}
				}
			}
		}
		return result;
    }
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码，体会其思想。
	 * 其实现的时间复杂度为O(n)，符合题目的要求
	 *其核心的思想为:将第i个元素放置在第i-1元素的位置上
	 */
	/*
	public int firstMissingPositive(int[] nums) 
	{
        for(int i=0;i<nums.length;i++)
        {
        	//用于调整第i号元素上的值，将其放置到相应的位置，并在第i号位置上放置相应的值
        	while(nums[i]!=i+1)
        	{
        		//第i号元素应该放置的位置
                int sindex = nums[i]-1;
        		if(sindex<0||sindex>=nums.length)
        			break;
        		if(nums[i]==nums[sindex])
        			break;
        		int tmp = nums[i];
        		nums[i] = nums[sindex];
        		nums[sindex] = tmp;
        	}
        }
        for(int i=0;i<nums.length;i++)
        {
        	if(nums[i]!=i+1)
        		return i+1;
        }
        return nums.length+1;
    }
	*/
	
}

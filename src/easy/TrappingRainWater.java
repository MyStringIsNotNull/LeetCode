package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 
 compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 

给定n个非负的整数，其中每个整数以高低立位的形式进行展示，其宽度均为1

在下完雨之后，算出其套住了多少水

例如;
给定[0,1,0,2,1,0,1,3,2,1,2,1], 返回6.

 */
public class TrappingRainWater
{
	/**
	 * 其代码的思路为:
	 * 先找到其最大值(整个数组的最大值)的下标，然后在该最大值的左右两边分别向最大值的下标的这个元素进行靠拢
	 * 在靠拢的过程中记录下出现过的最大值者的值，出现大于等于当前最大值者，则进行更新，否则，捕获的雨水的数量加上
	 * 当前最大值者的值与当前该值的差，直到遍历到整个数组的最大值者所在的元素的下标，结束程序
	 * 
	 */
	public int trap(int[] height) 
	{
		if(height==null||height.length==0)
			return 0;
		int maxIndex=findMaxIndex(height);
		int result=0;
		int left=height[0];
		int right=height[height.length-1];
		for(int i=0,j=height.length-1;i<maxIndex||j>maxIndex;)
		{
			if(i<maxIndex)
			{
				if(height[i]<left)
					result+=left-height[i];
				else
					left=height[i];
				i++;
			}
			if(j>maxIndex)
			{
				if(height[j]<right)
					result+=right-height[j];
				else
					right=height[j];
				j--;
			}
		}
		return result;
    }
	private int findMaxIndex(int[] height)
	{
		int index=0;
		int max=height[0];
		for(int i=1;i<height.length;i++)
		{
			if(height[i]>max)
			{
				index=i;
				max=height[i];
			}
		}
		return index;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路同上，只不过更为简便，同时省去了查找最大值的时间
	 */
	/*
	public int trap(int[] height)
	{
		if (height == null || height.length < 3)
			return 0;

		int vol = 0;

		int l = 0;
		int r = height.length - 1;
		int highestL = -1;
		int highestR = -1;
		int highest = -1;

		while (l <= r)
		{
			if (highestL < highestR)
			{
				if (height[l] < highestL)
				{
					vol += highestL - height[l];
				}
				else
				{
					highestL = height[l];
				}
				l++;
			}
			else
			{
				if (height[r] < highestR)
				{
					vol += highestR - height[r];
				}
				else
				{
					highestR = height[r];
				}
				r--;
			}
		}

		return vol;
	}*/
	
	
}

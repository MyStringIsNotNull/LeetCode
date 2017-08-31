package reservoirsampling;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given an array of integers with possible duplicates, randomly output the index of a given target number. 
 给定一个可能有重复数字的整型数组，随意的输出给定目标值的索引
 You can assume that the given target number must exist in the array.
你可以假定给定的目标值一定存在数组中
Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.
注意：
数组可能是非常大的，解决这个问题如果使用了太多的额外空间是可能通过不了判断的

Example:
例如：
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);
pick(3)应当返回索引2，3，4当中的任意一个，每个索引都必须等可能的被返回

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
pick(1)应该返回0，因为在数组中，只有nums[0]的值等于1

 */
public class RandomPickIndex
{
	private Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
	public RandomPickIndex(int[] nums) 
	{
        for(int i=0;i<nums.length;i++)
        {
        	if(!map.containsKey(nums[i]))
        	{
        		List<Integer> index=new LinkedList<Integer>();
        		index.add(i);
        		map.put(nums[i],index);
        	}
        	else
        	{
        		map.get(nums[i]).add(i);
        	}
        }
    }
    
    public int pick(int target) 
    {
    	List<Integer> list=map.get(target);
    	int index=(int)(Math.random()*list.size());
        return list.get(index);
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     * 
     * 你的解决方案的目标程序将会被实例化并按如下方式进行调用：
     * Solution obj=new Solution(nums);
     * int param_1=obj.pick(target);
     */
    
    
    /**
     * leetcode上运行时间最短的代码
     * 
     */
    /*
	private int[] nums;
	private java.util.Random rand;

	public Solution(int[] nums)
	{
		this.nums = nums;
		this.rand = new java.util.Random();
	}

	public int pick(int target)
	{
		int candidate = -1, count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			//在第一次的时候，其将值赋值给candidate，之后，在此出现时，其看概率改变candidate的值
			if (nums[i] == target && rand.nextInt(++count) == 0)
			{
				candidate = i;
			}
		}
		return candidate;
	}
	*/
    
}

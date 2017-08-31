package reservoirsampling;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given an array of integers with possible duplicates, randomly output the index of a given target number. 
 ����һ���������ظ����ֵ��������飬������������Ŀ��ֵ������
 You can assume that the given target number must exist in the array.
����Լٶ�������Ŀ��ֵһ������������
Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.
ע�⣺
��������Ƿǳ���ģ��������������ʹ����̫��Ķ���ռ��ǿ���ͨ�������жϵ�

Example:
���磺
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);
pick(3)Ӧ����������2��3��4���е�����һ����ÿ������������ȿ��ܵı�����

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
pick(1)Ӧ�÷���0����Ϊ�������У�ֻ��nums[0]��ֵ����1

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
     * ��Ľ��������Ŀ����򽫻ᱻʵ�����������·�ʽ���е��ã�
     * Solution obj=new Solution(nums);
     * int param_1=obj.pick(target);
     */
    
    
    /**
     * leetcode������ʱ����̵Ĵ���
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
			//�ڵ�һ�ε�ʱ���佫ֵ��ֵ��candidate��֮���ڴ˳���ʱ���俴���ʸı�candidate��ֵ
			if (nums[i] == target && rand.nextInt(++count) == 0)
			{
				candidate = i;
			}
		}
		return candidate;
	}
	*/
    
}

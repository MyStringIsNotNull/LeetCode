package easy;

import java.util.Arrays;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

����һ���������飬�ҳ��������Ƿ�������κ��ظ���Ԫ��
���κ�ֵ�����������ٳ������ε�ʱ����ĺ������뷵��true
�������е��κ�ֵ���ǲ���ͬ��ʱ���亯�����뷵��false

 */

public class ContainsDuplicate 
{
	public boolean containsDuplicate(int[] nums) 
	{
		boolean result=false;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++)
		{
			if(nums[i]==nums[i+1])
			{
				result=true;
				break;
			}
		}
		return result;
    }
	
	/**
	 * 
	 * leetcode������ʱ����̵Ĵ���
	 * ���Ƽ���һ��д������ʵ��Ϊ���������㷨��һ��Ӧ��
	 * ��ռ临�Ӷȿ��ܻ�����ر�ߵ���������Բ����Ƽ�ʹ�ø�д��
	 * �䱾��Ϊһ���Կռ任ȡʱ��Ĳ���
	 * 
	 */
	
	/*
	public boolean containsDuplicate(int[] nums)
	{
        if(nums == null || nums.length == 1) 
        	return false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums)
        {
            if(num > max)
                max = num;
            if(num < min)
                min = num;
        }
        boolean[] bool = new boolean[max - min + 1];
        for(int num : nums)
        {
            if(bool[num - min])
                return true;
            else
                bool[num - min] = true;
        }
        return false;
    }
	*/
	
	/**
	 * 
	 * leetcode�ϵ�����һ�ݴ���
	 * �Ƽ���������ʹ����һ�����ϵ��Ǹ��㷨����ռ��ʱ�临�ӶȾ�ΪO(n)
	 * ��������������д����ʱ�临�Ӷ�Ҫ��(���������д����ʱ�临�Ӷ�ΪO(nlogn))��������ռ临�Ӷ�Ҫ��
	 * 
	 */
	
	/*
	public boolean containsDuplicate(int[] nums) 
	{
        // // Linear space and time solution
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0; i<nums.length; i++) {
        //     if(set.contains(nums[i]))
        //         return true;
        //     set.add(nums[i]);
        // }
        // return false;
        
        // Sorting method
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) 
        {
            if(nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
	*/
}

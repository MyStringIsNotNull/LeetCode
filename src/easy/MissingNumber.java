package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 

����һ��ȡ��[0,n]������n����ͬ���ֵ����飬�ҵ������ж�ʧ�ĵ��Ǹ���

����:
����num=[0,1,3]����2

ע��:
����㷨�������O(n)��ʱ�临�Ӷȡ����ܽ���ʹ�ó����Ŀռ临�Ӷ�ȥʵ������

 */
public class MissingNumber 
{
	/**
	 * ���㷨��ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(n)
	 */
	public int missingNumber(int[] nums) 
	{
		boolean[] number=new boolean[nums.length+1];
		for(int i:nums)
		{
			number[i]=true;
		}
		int i=0;
		for(;i<number.length;i++)
		{
			if(!number[i])
			{
				break;
			}
		}
		return i;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ���µ�ʵ�֣�����O(n)��ʱ�临�Ӷȡ�O(1)�Ŀռ临�Ӷ�
	 */
	
	/*
	public int missingNumber(int[] nums) 
	{
        int sum =0,val =0;
        for(int i=0; i<nums.length; i++)
        {
            sum+= i;
            val += nums[i];
        }
        sum += nums.length;
        return sum-val;
    }
	*/
}

package easy;

import java.util.Arrays;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
The set S originally contains numbers from 1 to n. But unfortunately, 
 
due to the data error, one of the numbers in the set got duplicated to another number in the set, 
 
which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. 

Your task is to firstly find the number occurs twice and then find the number that is missing. 

Return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Note:

The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

����s��ԭ��������1��n��д���֣����ҵ���
�������ݷ����˴���һ�������ڼ����б��������һ���ڼ����д��ڵ�����
�⵼����һ�������ظ����֣�����һ�����ֶ�ʧ�����
����һ������nums��ʾ������Ϸ�������֮���״̬�����
��������ǵ�һʱ���ҳ��Ǹ����������ε����ֺ��Ǹ���ʧ�˵�����
��һ���������ʽ��������
����:
���� nums=[1,2,2,4]
���:[2,3]

ע��:
���ڸ��������飬�佫����[2,10000]֮��
���ڸ��������飬�佫�����������


 */
public class SetMismatch
{
	/**
	 * ���㷨��ʱ�临�Ӷ�ΪO(n)
	 * �ռ临�Ӷ�ΪO(1)
	 */
	public int[] findErrorNums(int[] nums) 
	{
		int n=nums.length;
		int[] result=new int[2];
		boolean founded=false;
		//�����ҵ��ظ��˵���
		for(int i=0;i<n&&!founded;i++)
		{
			while(nums[i]!=i+1)
			{
				int needIndex=nums[i]-1;
				if(nums[needIndex]==nums[i])
				{
					//��¼���ظ�����
					result[0]=nums[i];
					founded=true;
					break;
				}
				nums[i]^=nums[needIndex];
				nums[needIndex]^=nums[i];
				nums[i]^=nums[needIndex];
			}
		}
		//�����ҵ�ȱʧ����
		long number=((1+n)*n)/2;
		long add=0;
		for(int i=0;i<n;i++)
		{
			add+=nums[i];
		}
		result[1]=(int)(number+result[0]-add);
        return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �ô����˼·Ϊ��¼��[1,n]֮������Ƿ��г���
	 * �����е�һ����������2�������£������Ϊ�ظ����Ǹ���
	 * ������������һ��֮�󣬵���������һ����û�г��ֵ�ʱ�������Ϊȱʧ����
	 * ��ʱ��Ϳռ临�ӶȾ�ΪO(n)
	 */
	/*
	public int[] findErrorNums(int[] nums)
	{
		int size = nums.length;
		int[] map = new int[size];
		int[] r = new int[2];
		for (int i = 0; i < size; i++)
		{
			int t = nums[i] - 1;
			if (map[t] == 0)
				map[t] = 1;
			else
				r[0] = t + 1;
		}
		for (int i = 0; i < size; i++)
		{
			if (map[i] == 0)
			{
				r[1] = i + 1;
				break;
			}
		}
		return r;
	}
	*/
}

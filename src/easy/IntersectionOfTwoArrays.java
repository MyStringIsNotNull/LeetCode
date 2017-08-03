package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

Each element in the result must be unique.
The result can be in any order.

�����������飬дһ������ȥ�����佻���

����:
����nums1=[1,2,2,1] nums2=[2,2] ����[2]

ע��:
�ڽ���е�Ԫ�ر���Ψһ
����������κ�˳���

 */
public class IntersectionOfTwoArrays
{
	public int[] intersection(int[] nums1, int[] nums2) 
	{
		int[] result=null;
		Set<Integer> set=new HashSet<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0;
		int j=0;
		while(i<nums1.length&&j<nums2.length)
		{
			if(nums1[i]>nums2[j])
				j++;
			else if(nums1[i]<nums2[j])
				i++;
			else
			{
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		result=new int[set.size()];
		int index=0;
		for(int z:set)
		{
			result[index++]=z;		
		}
		return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ����˼·ͬ�ϣ�ֻ�����䲻�˲��ã�Ϊ�˸�Ϊֱ�ӵ�
	 */
	/*
	public int[] intersection(int[] nums1, int[] nums2)
	{
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		int index = 0;
		int[] res = new int[Math.min(nums1.length, nums2.length)];
		while (i <= nums1.length - 1 && j <= nums2.length - 1)
		{
			if (nums1[i] > nums2[j])
			{
				j++;
			}
			else if (nums1[i] < nums2[j])
			{
				i++;
			}
			else
			{
				if (index == 0 || res[index - 1] != nums1[i])
					res[index++] = nums1[i];
				j++;
				i++;
			}
		}
		int[] result = new int[index];
		for (int k = 0; k < index; k++)
		{
			result[k] = res[k];
		}

		return result;
	}
	*/
}

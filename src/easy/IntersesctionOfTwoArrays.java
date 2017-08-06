package easy;

import java.util.Arrays;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * 
question:

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

�����������飬��дһ������ȥ�������ǵĽ���

����:
����nums1=[1,2,2,1],nums2=[2,2] ����[2,2]

ע��:
ÿ�������ڽ���е�Ԫ�صĴ�������ͬ�������������е�һ����
���صĽ������������˳���

����:
����������������Ѿ�������أ������ȥ��������㷨��ʹ����㷨�ﵽ���ţ�
���nums1�Ĵ�СС��nums2�Ĵ�С��ʲô�����㷨�����ŵģ�
���nums2��Ԫ���Ǵ洢��Ӳ���ϵģ����ڴ�Ĵ�С�����޵��������㲻��һ���Լ���ȫ����Ԫ�ص������ڴ����أ�


 */
public class IntersesctionOfTwoArrays
{
	public int[] intersect(int[] nums1, int[] nums2) 
	{
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int length=nums1.length>nums2.length?nums2.length:nums1.length;
		int[] result=new int[length];
		int n1=0,n2=0,index=0;
		while(n1<nums1.length&&n2<nums2.length)
		{
			if(nums1[n1]==nums2[n2])
			{
				result[index++]=nums1[n1];
				n1++;
				n2++;
			}
			else if(nums1[n1]>nums2[n2])
				n2++;
			else
				n1++;
		}
		int[] r=new int[index];
		for(int i=0;i<index;i++)
		{
			r[i]=result[i];
		}
		return r;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ���
	 * ���ϴ�����leetcode�Ĳ���������ʱ��϶�
	 * Ϊ������һ��leetcode������ʱ����Խ��ٵģ����ǿ����ṩһ��ѧϰ˼·�Ĵ���
	 * ������������ڴ治�㣬������Ӳ���ϵ������н϶��ظ������
	 * 
	 */
	/*
	public int[] intersect(int[] nums1, int[] nums2)
	{
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++)
			count.put(nums1[i], count.getOrDefault(nums1[i], 0) + 1);
		for (int i = 0; i < nums2.length; i++)
		{
			if (count.getOrDefault(nums2[i], 0) > 0)
			{
				list.add(nums2[i]);
				count.put(nums2[i], count.get(nums2[i]) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			res[i] = list.get(i);
		return res;
	}
*/
}

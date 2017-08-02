package easy;
/**
 * 
 * @author ѧͽ
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

����һ������n+1�����������飬ÿ����������1��n(������n)֮��

��֤������С���ظ����ֵ����ض����ڣ�������ֻ��һ���ظ�����,�ҵ��Ǹ��ظ�����

��ʾ:
�㲻��ȥ�ı�����(�������������ֻ����)
�����ʹ�ó�����O(1)�Ŀռ临�Ӷ�
����㷨ʱ�临�Ӷȱ���С��O(n^2)
��������ֻ��һ���ظ��������������ܻ��ظ����ֶ��

 */

public class FindDuplicateNumber 
{
	/**
	 * ���㷨��˼·Ϊ��
	 * ���ö��ַ����ϳ�����룬��ʱ�临�Ӷ�ΪO(nlogn)
	 * 
	 */
	public int findDuplicate(int[] nums) 
	{
		//�ظ������ֳ��ֵķ�Χ
		int low=1;
		int high=nums.length-1;
		//ps:��whileѭ������ʱ��low=high����ʱ�����ּ�Ϊ�ظ������˵�
		while(low<high)
		{
			int mid=(low+high)>>>1;
			int count=0;
			for(int i=0;i<nums.length;i++)
			{
				//ͳ��С�ڵ���mid�����ֵĸ���
				if(nums[i]<=mid)
				{
					count++;
				}
			}
			//��С�ڵ����м�ֵ�ĸ�������mid��ʱ��������ظ������ֵķ�ΧΪ[low,mid]
			//���С�ڵ���mid������ÿ����ֻ������һ�λ���û�г���,��С�ڵ����м�ֵ�����ֵĸ�����������С�ڵ���mid��
			//�������mid��ʱ���������[low,mid]�ķ�Χ�ڳ������ظ�������
			if(count>mid)
			{
				high=mid;
			}
			//��С�ڵ����м�ֵ�ĸ���С��mid��ʱ��˵��������ظ�����������mid���ҵķ�Χ���������ظ������ֵķ�ΧΪ[mid+1,high]
			else
			{
				low=mid+1;
			}
		}
		return low;
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·Ϊ:
	 * �����鿴�ɱ��Ϊ��0��n��n���ڵ㣬�������Ӧ�±�����Ӧ������Ԫ�ص�ֵ��ʾ�������±�Ľڵ�
	 * ������Ԫ�ص�ֵ�Ľڵ�����Ӧ��һ������ߣ���Ϊ���0������Ԫ��һ����������Ի�
	 * (��Ϊ0��n��Ԫ������Ӧ��ֵֻ��Ϊ1��n�����Բ����ڵ�0��Ԫ�ص�ֵΪ0�����������0��Ԫ�ص�ֵΪ0�����õ�0��Ԫ��
	 * ��Ϊ��ʼ�ڵ��ʱ���������Ի��������������bug�ĳ���
	 * )��
	 * ͬʱ��������һ�������ظ���Ԫ�أ������ظ���Ԫ�صĸ���Ϊ1��������ظ���Ԫ����ͼ�еı�ʾ�����ֿ���
	 * ��һ:һ���ڵ����ӵ����ظ��ڵ㣬���ظ��ڵ㱾������Ի�
	 * �ڶ�:һ���ڵ����ӵ����ظ��ڵ㣬���ظ��ڵ����ӵ���һ�ڵ㣬������Ľڵ����ջ����ӻ���ظ��Ľڵ�
	 * �������������������������ظ��ڵ�Ϊ��ʼ�ڵ��ĩβ�ڵ�Ļ�
	 * Ϊ�ˣ����ÿ���ָ����߷����Ӷ��õ����ظ��Ľڵ�
	 * 
	 * ps�������˼��ͬLinkedList�����⣬ֻ�ǽ���������ݽṹ�Ļ���������
	 * ���㷨��ʱ�临�Ӷ�ΪO(n)
	 */
	/*
	public int findDuplicate(int[] nums) 
	{
        if (nums.length > 1)
        {
        	//�ؼ�������ѡ���0�Žڵ�Ϊ��ʼ�߿���ָ��Ľڵ�
            int slow = nums[0];
            int fast = nums[nums[0]];
            //�����˳���ѭ����ʱ����slow��fast��������ѭ����Ȧ��
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            //�����ҵ����ظ��Ľڵ��ֵ
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

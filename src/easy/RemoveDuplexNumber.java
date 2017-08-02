package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 
����һ���ź�������飬�Ƴ����ظ���Ԫ�أ���ʹÿ������Ԫ��ֻ����һ�Σ������ظ�����ĳ���
������������Ŀռ���������飬������ڸ��������ڴ�ռ�������Ͻ��в���

����
����һ����������nums=[1,1,2]

��ĺ������뷵��length=2��ͬʱ���������ĵ�һ�͵ڶ���Ԫ�ر�Ϊ1��2��
����������������ռ�ĳ��ȳ���������ĳ�������²�����ν

 */
public class RemoveDuplexNumber 
{
	public int removeDuplicates(int[] nums) 
	{
		int low=0;
		int high=1;
		int length=1;
		//���ڼ�¼���ظ������ڵ�Ԫ�صĸ���
		int max=nums.length;
		while(high<max)
		{
			if(nums[low]==nums[high])
			{
				length--;
				//�������Ԫ����ǰ���ƶ����Ը��ǵ��ظ���Ԫ��
				for(int i=high+1;i<max;i++)
				{
					nums[i-1]=nums[i];
				}
				max--;
			}
			else
			{
				low=high;
				high++;
			}
			length++;
		}
		if(nums.length==0)
            length=0;
		return length;
    }
	
	/**
	 * leetcode�ϻ��ѵ�ʱ����С�Ĵ���
	 * �ܲ���Ĵ��룬����
	 */
	/*public int removeDuplicates(int[] nums) 
	{
        if(nums.length <= 1)
        {
            return nums.length;
        }
        int len = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[i-1])
            {
                nums[len++] = nums[i];
            }
        }
        return len;
    }*/
	
}

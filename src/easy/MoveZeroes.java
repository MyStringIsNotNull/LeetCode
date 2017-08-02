package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

You must do this in-place without making a copy of the array.

Minimize the total number of operations.

����һ������nums��дһ������ȥ�ƶ����е�0�������ĩβ��ͬʱ���ַ�0Ԫ�ؼ����Թ�ϵ

���磬����nums=[0,1,0,3,12],��������ĺ���֮��nums������[1,3,12,0,0]

��ʾ:
�������ԭ�����Ͻ��в���
���»�������Ĵ���


 */
public class MoveZeroes 
{
	public void moveZeroes(int[] nums) 
	{
		int zeroNumber=0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==0)
				zeroNumber++;
		}
		for(int i=0;i<zeroNumber;i++)
		{
			for(int index=0;index<nums.length-i;index++)
			{
				if(nums[index]==0)
				{
					for(int k=index;k<nums.length-1-i;k++)
					{
						int temp=nums[k];
						nums[k]=nums[k+1];
						nums[k+1]=temp;
					}
				}
			}
		}
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ���
	 * ����õ�˼·Ϊ:
	 * �������ұ�������Ԫ�أ�����Ϊ0ʱ���ú��治Ϊ0��Ԫ�ؽ��и���
	 * ֱ�����������飬֮�󽫺����Ԫ��ȫ����Ϊ0
	 * 
	 */
	
	/*
	public void moveZeroes(int[] nums) 
	{
        if (nums == null || nums.length == 0)
            return;
        int insPos = 0;
        for (int num : nums)
        {
            if (num!=0) 
                nums[insPos++] = num;
        }
        while(insPos < nums.length)
            nums[insPos++] = 0;
    }
	*/
	
}

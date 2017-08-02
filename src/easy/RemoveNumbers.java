package easy;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 *question:
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2. 

����һ�������ֵ���Ƴ������е��ڸ�ֵ��Ԫ�ز�����һ���µ����鳤��

������������Ŀռ���������飬�����������������ڴ��н��в���

Ԫ�ص�˳������ı䣬��������ĳ��ȳ�����Ч�ĳ�������£���������
 */
public class RemoveNumbers 
{
	 public int removeElement(int[] nums, int val)
	 {
		 int length=0;
		 if(nums.length<=0)
			 return length;
		 for(int i=0;i<nums.length;i++)
		 {
			 if(nums[i]!=val)
				 nums[length++]=nums[i];
		 }
		 return length;
	 }
	 
	 
	 /**
	  * leetcode������ʱ����̵Ĵ���
	  */
	/* public int removeElement(int[] nums, int val) 
	 {
	        if(nums.length == 0) 
	        	return 0;
	        int i = 0, j = nums.length - 1;
	        
	        while(i <= j) 
	        {
	        	if(nums[i] != val)//�����￪ʼ��˼·ֵ��ѧϰ
	            	i++;
	            else if(nums[j] == val)
	            	j--;
	            else 
	            	nums[i] = nums[j--];
	        }
	        return j + 1;
	 }*/
	 /**
	  * �����ϴ�������Ż���Ľ��
	  */
	/* 
	public int removeElement(int[] nums, int val) 
 	{
	        int i = 0, j = nums.length - 1;
	        while(i <= j) 
	        {
	            if(nums[i] != val)//�����￪ʼ��˼·ֵ��ѧϰ
	            	i++;
	            else if(nums[j] == val)
	            	j--;
	            else 
	            	nums[i] = nums[j--];
	        }
	        return i;
    }*/
	 
}

package easy;

/**
 * 
 * @author 学徒
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

给定一个数组和值，移除掉所有等于该值的元素并返回一个新的数组长度

不允许分配额外的空间给其它数组，你必须在这个连续的内存中进行操作

元素的顺序允许改变，对于数组的长度超过有效的长度这件事，并不关心
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
	  * leetcode上运行时间最短的代码
	  */
	/* public int removeElement(int[] nums, int val) 
	 {
	        if(nums.length == 0) 
	        	return 0;
	        int i = 0, j = nums.length - 1;
	        
	        while(i <= j) 
	        {
	        	if(nums[i] != val)//从这里开始的思路值得学习
	            	i++;
	            else if(nums[j] == val)
	            	j--;
	            else 
	            	nums[i] = nums[j--];
	        }
	        return j + 1;
	 }*/
	 /**
	  * 对以上代码进行优化后的结果
	  */
	/* 
	public int removeElement(int[] nums, int val) 
 	{
	        int i = 0, j = nums.length - 1;
	        while(i <= j) 
	        {
	            if(nums[i] != val)//从这里开始的思路值得学习
	            	i++;
	            else if(nums[j] == val)
	            	j--;
	            else 
	            	nums[i] = nums[j--];
	        }
	        return i;
    }*/
	 
}

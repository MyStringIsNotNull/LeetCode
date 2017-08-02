package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
question:
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6. 

寻找临近的子数组在这个最少包含一个数的数组中，使得该子数组的和最大
例如：
给定一个数组[-2,1,-3,4,-1,2,1,-5,4]
这个临近的子数组为[4,-1,2,1]，它有最大的和6

 */
public class FindMaxSubArray 
{
	public int maxSubArray(int[] nums) 
	{
        int sum=0;
        int max=nums[0];
        int length=nums.length;
        for(int i=0;i<length;i++)
        {
        	sum+=nums[i];
        	if(sum>max)
        	{
        		max=sum;
        	}
        	if(sum<0)
        		sum=0;
        }
        return max;
    }
	
	/**
	 * leetcode上和以上代码一样达到最短的时间的算法
	 */
	/*
	public int maxSubArray(int[] nums)
    {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(sum < 0)
                sum = nums[i];
            else 
                sum += nums[i];
            
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
    */
}

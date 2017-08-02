package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
After robbing those houses on that street, 

the thief has found himself a new place for his thievery so that he will not get too much attention. 

This time, all houses at this place are arranged in a circle. 

That means the first house is the neighbor of the last one. 

Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 

determine the maximum amount of money you can rob tonight without alerting the police.

在抢劫了那些沿街的房子之后

盗贼发现了一个新的可以进行盗窃的地方，这样他就不会被注意到了

这次，在这个地方的所有房子被安排成了一个圈

这意味着第一个房子和最后一个房子是相邻的

于此同时，这些房子的安全系统同上一条街的类似(即不能偷窃相邻的两户人家)

给定一个非负整数的列表代表每户人家所拥有的金额

在没有惊动警察的情况下，决定你能偷盗得到的最大的金额

 */

public class HouseRobberII 
{
	/**
	 * 该方法在leetcode上运行时时间超过
	 * 因此采用别的思路
	 */
	/*
	public int rob(int[] nums) 
	{
		if(nums==null||nums.length==0)
			return 0;
		int doRob=nums[0]+rob(nums,2,nums.length-2);
		int notRob=rob(nums,1,nums.length-1);
		return Math.max(doRob, notRob);
    }
	private int rob(int[] nums,int low,int high)
	{
		if(low>high)
			return 0;
		int doRob=nums[low]+rob(nums,low+2,high);
		int notRob=rob(nums,low+1,high);
		return Math.max(doRob, notRob);
	}
	*/
	
	/**
	 *采用非递归的方式进行书写，
	 *其对应两种情况，
	 *第一:有第一个元素，没有最后一个元素的数组，在其中进行抢劫
	 *第二:没有第一个元素，有最后一个元素的数组，在其中进行抢劫
	 *对于这以上的两种情况，抢劫的结果最大者，即为最后所能获得的最大金额
	 *其思路上和递归的方式的保持一致，只不过将其改成非递归形式
	 *
	 */
	 public int rob(int[] nums)
		{
			if(nums==null||nums.length==0)
				return 0;
			else if(nums.length==1)
				return nums[0];
			return Math.max(rob(nums,0,nums.length-2), rob(nums,1,nums.length-1));
		}
		public int rob(int[] nums,int low,int high)
	    {
			int length=high-low+1;
			if(nums==null||length==0)
				return 0;
			else if(length==1)
	            return nums[low];
			int pre=nums[low];
			int pren=Math.max(nums[low+1],nums[low]);
			for(int i=low+2;i<=high;i++)
			{
				int temp=pren;
				pren=Math.max(pren, pre+nums[i]);
				pre=temp;
			}
			return pren;
	    }
	
		
		/**
		 * leetcode上运行时间最短的代码
		 * 其代码的思路同上保持一致
		 */
		/*
		public int rob(int[] nums) 
		{
            if (nums == null || nums.length == 0)
                return 0;
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
        }
        
        private int robHelper(int[] nums, int start, int end)
         {
            int curr, prev, prev2;
            curr = prev = prev2 = 0;
            for (int i = start; i <= end; i++) 
            {
                curr = Math.max(prev2 + nums[i], prev);
                prev2 = prev;
                prev = curr;
            }
            return curr;
        }
		*/
		
		
}

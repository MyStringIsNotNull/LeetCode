package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
You are a professional robber planning to rob houses along a street. 

Each house has a certain amount of money stashed, 

the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 

and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 

determine the maximum amount of money you can rob tonight without alerting the police.

你是一个专业的强盗，而且正打算沿着这条街去抢劫这些房子

每一个房子拥有存储了一定的金额

唯一限制你去抢劫他们的是临近的房子有安全系统连接

并且其会自动的连接到警察局如果两个临近的房子在同一晚上被闯入

给定一个非负整数的列表代表每一户人家所拥有的金额

在没有惊动警察的情况下，确定你在今晚所能获取到的最大金额
 */
public class HouseRobber 
{
	/**
	 * 
	 * 此运行方式时，其时间超过
	 * 思路为:要么抢劫当前这户人家，要么不抢劫当前这户人家，
	 * 当抢劫这户人家的时候，只能从这户人家的下下户人家进行抢劫
	 * 当不抢劫这户人家的时候，可以从下一户人家之后开始进行抢劫
	 * 之后，比较抢和不抢的操作，哪种方案获得的金额更多，从而选择那种进行
	 * 为此，采用另一种思路
	 * 
	 */
	
	/*
	public int rob(int[] nums) 
    {
		if(nums==null||nums.length==0)
			return 0;
		int doRob=nums[0]+rob(nums,2,nums.length-1);
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
	 * 其思路为动态规划的想法
	 * 其状态方程为:maxV[i]表示到第i个房子位置，最大收益。
	 * 递推关系为maxV[i] = max(maxV[i-2]+num[i], maxV[i-1])
		注：可能会对上述递推关系产生疑问，是否存在如下可能性，maxV[i-1]并不含num[i-1]？
		结论是，在这种情况下maxV[i-1]等同于maxV[i-2]，因此前者更大。
	 * 
	 */
	public int rob(int[] nums) 
    {
		if(nums==null||nums.length==0)
			return 0;
		else if(nums.length==1)
            return nums[0];
	 	//该数组用于维护，到达第i个房子的时候，其最大的收益
		int[]  maxV=new int[nums.length];
	 	maxV[0]=nums[0];//按照思路的理解，其实际上为maxV[0]=Math.max(0,nums[0]);
	 	//按照思路上的理解，其实际上为maxV[1]=Math.max(nums[0],nums[1]+0);
	 	//即要么不抢劫自己所在的房子去抢劫前面相邻的那个房子的和
	 	//或者要么抢劫当前所在房子并抢劫前面不相邻的那个房子的和
	 	maxV[1] = Math.max(nums[0], nums[1]);
	 	for(int i = 2; i <nums.length; i ++)
            maxV[i] = Math.max(maxV[i-2]+nums[i], maxV[i-1]);
        return maxV[nums.length-1];
    }
	
	/**
	 * 
	 * 对以上的思路进行改进之后的代码
	 * 
	 */
	/*
	public int rob(int[] nums) 
    {
		if(nums==null||nums.length==0)
			return 0;
		else if(nums.length==1)
            return nums[0];
		int pre=nums[0];
		int pren=Math.max(nums[1],nums[0]);
		for(int i=2;i<nums.length;i++)
		{
			int temp=pren;
			pren=Math.max(pren, pre+nums[i]);
			pre=temp;
		}
		return pren;
    }*/
	/**
	 * leetcode上运行时间较短的代码
	 * 同时是再度进行简化之后的代码
	 * 其思路同上
	 */
	/*
	 public int rob(int[] num) 
	 {
		    int prevMax = 0;
		    int currMax = 0;
		    for (int x : num) 
		    {
		        int temp = currMax;
		        currMax = Math.max(prevMax + x, currMax);
		        prevMax = temp;
		    }
		    return currMax;
		}*/
}

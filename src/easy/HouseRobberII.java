package easy;
/**
 * 
 * @author ѧͽ
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

����������Щ�ؽֵķ���֮��

����������һ���µĿ��Խ��е��Եĵط����������Ͳ��ᱻע�⵽��

��Σ�������ط������з��ӱ����ų���һ��Ȧ

����ζ�ŵ�һ�����Ӻ����һ�����������ڵ�

�ڴ�ͬʱ����Щ���ӵİ�ȫϵͳͬ��һ���ֵ�����(������͵�����ڵ������˼�)

����һ���Ǹ��������б����ÿ���˼���ӵ�еĽ��

��û�о������������£���������͵���õ������Ľ��

 */

public class HouseRobberII 
{
	/**
	 * �÷�����leetcode������ʱʱ�䳬��
	 * ��˲��ñ��˼·
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
	 *���÷ǵݹ�ķ�ʽ������д��
	 *���Ӧ���������
	 *��һ:�е�һ��Ԫ�أ�û�����һ��Ԫ�ص����飬�����н�������
	 *�ڶ�:û�е�һ��Ԫ�أ������һ��Ԫ�ص����飬�����н�������
	 *���������ϵ�������������ٵĽ������ߣ���Ϊ������ܻ�õ������
	 *��˼·�Ϻ͵ݹ�ķ�ʽ�ı���һ�£�ֻ��������ĳɷǵݹ���ʽ
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
		 * leetcode������ʱ����̵Ĵ���
		 * ������˼·ͬ�ϱ���һ��
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

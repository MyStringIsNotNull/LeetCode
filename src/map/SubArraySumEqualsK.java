package map;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
给定一个整型数组及一个整数k，你需要去找到全部的连续的数的子集和使其和为k
Example 1:
例子1：
Input:nums = [1,1,1], k = 2
输入:nums=[1,1,1],k=2
Output: 2
输出:2
Note:
注意：
The length of the array is in range [1, 20,000].
数组的长度在[1,20,000]之间
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
数组中数字的范围在[-1000，1000]之间，并且其k的值的范围在[-1e7,1e7]之间

 */
public class SubArraySumEqualsK
{
	public int subarraySum(int[] nums, int k)
	{
      int result=0;
      //用于遍历起始的元素位置
      for(int s=0;s<nums.length;s++)
      {
    	  int add=nums[s];
    	  if(add==k)
    	  {
    		  result++;
    	  }
    	  //用于遍历往后的元素的，因其元素为乱序的，为此，考虑加上该元素之后其值相等和不相等的情况
    	  for(int end=s+1;end<nums.length;end++)
    	  {
    		  if(add+nums[end]==k)
    		  {
    			 result++;
    		  }
			  add+=nums[end];
    	  }
      }
      return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路为：
	 * 如果当前位置之前有相加和为sum-k的位置，则这两个位置之间的数字相加和为k，
	 * 以当前位置结尾的相加和为k的子数组个数为hash[sum-k]，这样遍历整个数组即可得出满足条件的子数组个数。
	 */
	/*
	public int subarraySum(int[] nums, int k)
	{
		int[] sum = new int[nums.length + 1];
		int res = 0;
		// map<sum, number of subarrays addup to sum>
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//sum[i]中存放的为nums数组的前i-1个元素的和的值
		for (int i = 1; i < sum.length; i++)
		{
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		//用于遍历sum数组中的元素，同时记录下子串的个数
		for (int i = 0; i < sum.length; i++)
		{
			if (map.containsKey(sum[i] - k))
			{
				res += map.get(sum[i] - k);
			}
			//将sum[i]的值作为键，其出现的次数作为值保存在map数组中
			map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
		}
		return res;
	}
	*/
	
	
	
}

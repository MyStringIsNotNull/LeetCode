package map;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
����һ���������鼰һ������k������Ҫȥ�ҵ�ȫ���������������Ӽ���ʹ���Ϊk
Example 1:
����1��
Input:nums = [1,1,1], k = 2
����:nums=[1,1,1],k=2
Output: 2
���:2
Note:
ע�⣺
The length of the array is in range [1, 20,000].
����ĳ�����[1,20,000]֮��
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
���������ֵķ�Χ��[-1000��1000]֮�䣬������k��ֵ�ķ�Χ��[-1e7,1e7]֮��

 */
public class SubArraySumEqualsK
{
	public int subarraySum(int[] nums, int k)
	{
      int result=0;
      //���ڱ�����ʼ��Ԫ��λ��
      for(int s=0;s<nums.length;s++)
      {
    	  int add=nums[s];
    	  if(add==k)
    	  {
    		  result++;
    	  }
    	  //���ڱ��������Ԫ�صģ�����Ԫ��Ϊ����ģ�Ϊ�ˣ����Ǽ��ϸ�Ԫ��֮����ֵ��ȺͲ���ȵ����
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
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·Ϊ��
	 * �����ǰλ��֮ǰ����Ӻ�Ϊsum-k��λ�ã���������λ��֮���������Ӻ�Ϊk��
	 * �Ե�ǰλ�ý�β����Ӻ�Ϊk�����������Ϊhash[sum-k]�����������������鼴�ɵó����������������������
	 */
	/*
	public int subarraySum(int[] nums, int k)
	{
		int[] sum = new int[nums.length + 1];
		int res = 0;
		// map<sum, number of subarrays addup to sum>
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//sum[i]�д�ŵ�Ϊnums�����ǰi-1��Ԫ�صĺ͵�ֵ
		for (int i = 1; i < sum.length; i++)
		{
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		//���ڱ���sum�����е�Ԫ�أ�ͬʱ��¼���Ӵ��ĸ���
		for (int i = 0; i < sum.length; i++)
		{
			if (map.containsKey(sum[i] - k))
			{
				res += map.get(sum[i] - k);
			}
			//��sum[i]��ֵ��Ϊ��������ֵĴ�����Ϊֵ������map������
			map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
		}
		return res;
	}
	*/
	
	
	
}

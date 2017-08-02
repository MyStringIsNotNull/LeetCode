package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of size n, find the majority element. The majority element is the element that appears more than Math.floor(n/2)(即向下取正) times.

You may assume that the array is non-empty and the majority element always exist in the array.

给定一个拥有n个数组元素的数组，找到那个多数的数组元素。

那个多数的元素是在数组中出现的次数多于Math.floor(n/2)(即向下取正)次的元素

你必须假设该数组不为空，并且其多数的数组元素存在数组中




 */
public class MajorityElement 
{
	public int majorityElement(int[] nums) 
	{
		Deque<Integer> s=new ArrayDeque<Integer>();
		//用于统计次数，键为数组元素，值为出现在数组中的次数
		Map<Integer,Integer> statistic=new HashMap<Integer,Integer>();
		//其为对应的出现次数最多的元素的值
		int result=nums[0];
		for(int tem:nums)
		{
			if(statistic.containsKey(tem))
			{
				statistic.put(tem, statistic.get(tem)+1);
				//当找到那个元素的值时，
				if(statistic.get(tem)>=nums.length/2+1)
				{
					result=tem;
					break;
				}
			}
			else
				statistic.put(tem, 1);
		}
		return result;
    }
	
	/**
	 * 
	 * 解决MajorityElement的一个算法为Moore's Voting Algorithm
	 * 该算法的思路为:
	 * 由于重复频率超过 floor(n/2)的数字只有一个，等价于与其余数字出现频率的差大于零。
	 * 当遍历整个数组时，使用变量candidate记录当前重复次数最多的数，count计算candidate重复多余的次数。
	 * 以下为具体实现：
	 * 在遍历过程中，当前元素与candidate相同则投支持票，否则投反对票。
	 * 当count状态为0时，说明之前的子数组中不存在重复次数超过一半的数，遍历余下的数组成为原问题的子问题。
	 * 若该数不一定存在，那么需要再一次遍历数组，鉴证找到的元素是否符合条件。
	 * 鉴于该题，其代码如下:
	 * 
	 * ps:该问题的扩展，详见博文: http://blog.csdn.net/wenyusuran/article/details/40780253
	 * 
	 */
	
	/*
	public int majorityElement(int[] nums) 
	{
		int candidate=nums[0];
		int count=1;
		for(int i=1;i<nums.length;i++)
		{
			if(count==0)
			{
				count=1;
				candidate=nums[i];
			}
			else if(candidate==nums[i])
				count++;
			else
				count--;
		}
		return candidate;
	}
	*/
	
	/**
	 * 
	 * leetcode上运行时间最短的代码
	 * 
	 * 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。 
	 * 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。
	 * 当然，最后剩下的元素也可能并没有出现半数以上。比如说数组是[1, 2, 3]，最后剩下的3显然只出现了1次，并不到半数。
	 * 排除这种false positive情况的方法也很简单，只要保存下原始数组，最后扫描一遍验证一下就可以了。
	 * 
	 */
	/*
	public int majorityElement(int[] nums) 
	{
        return maj(nums, nums.length);
    }
    
    public int maj(int[] nums, int n) 
    {
        if (n == 1 || n == 2) 
        	return nums[0];
        int p = 0;
        *
        *
        *其做法为将相邻的两个元素中，相同的话保留下其中一个，不相同的话，对两个元素都进行消去处理
        *因其数组中，有一个元素出现的次数超过了Math.floor(nums.length/2)次，为此，最终留下来的数组元素
        *一定为出现的次数超过了Math.floor(nums.length/2)次的那个数组元素
        *
        for (int i = 0 ; i < n; i = i + 2) 
        {
            if (i == n - 1 || nums[i] == nums[i + 1]) 
            {
                nums[p++] = nums[i];
            }        
        }
        return maj(nums,p);
	}*/
}

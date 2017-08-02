package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

给定一个整数数组，除了其中一个元素之外，其余每个元素出现两次。请找出那个单独的数

注意:
你的算法必须是O(n)的时间复杂度。你能够在没有使用额外的空间的情况下实现它吗？
 */
public class FindSingleNumber 
{
	/**
	 * 以下代码的时间复杂度为O(n)，空间复杂度也为O(n)
	 */
	public int singleNumber(int[] nums) 
	{
		int result=nums[0];
		Map<Integer,Integer> record=new HashMap<Integer,Integer>();
		for(int tem:nums)
		{
			if(record.get(tem)==null)
				record.put(tem, 1);
			else
				record.put(tem, record.get(tem)+1);
		}
		//此处的Map进行遍历的速度会优于使用下面进行注释的方式对Map进行遍历的方式
		//其速度比先取出键再取出值的速度会更快
		Iterator it=record.entrySet().iterator();
		while(it.hasNext())
		{
			java.util.Map.Entry<Integer,Integer> entry=(java.util.Map.Entry<Integer,Integer>)it.next();
			if(entry.getValue()==1)
				result=entry.getKey();
		}
		/*
		Iterator<Integer> its=record.keySet().iterator();
		while(its.hasNext())
		{
			Integer key=its.next();
			Integer value=record.get(key);
			if(value==1)
				result=key;
		}
		*/
		
		return result;
    }
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码，主要是体会其思想，此代码的思路，非常的清晰，并且代码简短，时间复杂度和空间复杂度很低
	 * 同时，由于使用了位运算的方式，其速度会很快
	 * 其原理同两个数进行交换的^运算的方法，即有两个数
	 * a，b则
	 * a^=b;
	 * b^=a;
	 * a^=b;
	 * 的方式
	 * 
	 * 对多个数进行异或(^)运算时，当该数进行异或时，第一次是将值加入到其中，第二次对该数进行异或运算是将该数从中进行消除
	 * 得到的结果为其它数进行异或运算的结果
	 * 
	 */
	/*
	 public int singleNumber(int[] nums) 
	{
        int result = 0;
        for (int num: nums)
        {
             result ^=num;
        }
        return result;
    }*/
	
}

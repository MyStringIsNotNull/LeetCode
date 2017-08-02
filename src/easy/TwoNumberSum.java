package easy;
/**
 * @author 学徒
 */
/*
question:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

给定一个数组，返回该数组的两个下标，使得这两个下标的和相加为指定的那个值
你必须假设每一个输入的数都有正确的解，并且要求你不能使用相同的数两次

ps：陷阱就在，没有说给出的那个数组是排序好的数组，然后给出的数组为有序的。同时要考虑数组中的元素的值有可能为负的情况
*/


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class TwoNumberSum 
{
    public int[] twoSum(int[] nums, int target)
    {
		Map<String,Integer> result=getMap(nums);
		Arrays.sort(nums);
		return getIndices(nums,result,target);
        
    }
	/**
		用于将数组元素所对应的下标存入Map中,当有相同的值的时候，将后一个值存为对应的值加一个空格的形式
		@param nums 给定的数组
		@return Map<String,Integer> 键为数组的元素，值为该元素所对应的下标
	*/
    /*
		使用了Map，会使得具有相同值的情况下其只存入后一个值的情况，使得出现重复引用数组的值的情况，
		为此改变相同的值的存储方式，即在相同值的后一个值中存入的时候，加入一个空格！
		否则会出现如下情况:
		Input:[3,3]
		6
		Output:[1,1]
		Expected:[0,1]
	*/
	public Map<String,Integer> getMap(int[] nums)
	{
		Map<String,Integer> result = new HashMap<String,Integer>();
		for(int index=0;index<nums.length;index++)
		{
			if(result.get(String.valueOf(nums[index]))==null)
				result.put(String.valueOf(nums[index]),index);
			else
				result.put(String.valueOf(nums[index]+" "), index);
		}
		return result;
	}
    /**
    	该方法用于获取数组的下标值
        @param nums 排序后的数组
		@param reverse Map的键为数组的元素，Map值为该元素所对应的下标
        @param target 想查找的数
        @return 所查找的数的下标组成的数组元素
    */
    public int[] getIndices(int[] nums,Map<String,Integer> reverse,int target)
    {
        int low=0;
        int high=nums.length-1;
        int[] result=null;
        while(low<high)
        {
			int sum=nums[low]+nums[high];
            if(sum>target)
            {
                high--;
            }
            else if(sum<target)
            {
                low++;
			}
            else
            {
            	String lowstring=String.valueOf(nums[low]);
            	String highstring=String.valueOf(nums[high]);
            	if(lowstring.equals(highstring))
            		highstring+=" ";
                result=new int[]{reverse.get(lowstring),reverse.get(highstring)};
                break;
            }
        }
        return result;
    }
    
    
    /**
     * leetcode上所花费时间最少的写法
     */
    /*
     * 其采用了一个Map的情况，其思路比较清晰，采用不对无序的数组先进行排序的情况，并且其在执行的过程中，
     * 边执行边构造Map映射
     * 其一个缺点就是，在数组中有两个相同的元素的时候，其保留的只能是最后查看到的数组的元素的下标
     */
   /* public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) 
        {
            int complement = target - nums[i];
            if (map.containsKey(complement)) 
            {
                return new int[] {map.get(complement), i };
            }
            map.put(nums[i], i);
       }
        throw new IllegalArgumentException("No two sum solution");
    }*/
}









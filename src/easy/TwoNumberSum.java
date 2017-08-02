package easy;
/**
 * @author ѧͽ
 */
/*
question:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

����һ�����飬���ظ�����������±꣬ʹ���������±�ĺ����Ϊָ�����Ǹ�ֵ
��������ÿһ���������������ȷ�Ľ⣬����Ҫ���㲻��ʹ����ͬ��������

ps��������ڣ�û��˵�������Ǹ�����������õ����飬Ȼ�����������Ϊ����ġ�ͬʱҪ���������е�Ԫ�ص�ֵ�п���Ϊ�������
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
		���ڽ�����Ԫ������Ӧ���±����Map��,������ͬ��ֵ��ʱ�򣬽���һ��ֵ��Ϊ��Ӧ��ֵ��һ���ո����ʽ
		@param nums ����������
		@return Map<String,Integer> ��Ϊ�����Ԫ�أ�ֵΪ��Ԫ������Ӧ���±�
	*/
    /*
		ʹ����Map����ʹ�þ�����ֵͬ���������ֻ�����һ��ֵ�������ʹ�ó����ظ����������ֵ�������
		Ϊ�˸ı���ͬ��ֵ�Ĵ洢��ʽ��������ֵͬ�ĺ�һ��ֵ�д����ʱ�򣬼���һ���ո�
		���������������:
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
    	�÷������ڻ�ȡ������±�ֵ
        @param nums ����������
		@param reverse Map�ļ�Ϊ�����Ԫ�أ�MapֵΪ��Ԫ������Ӧ���±�
        @param target ����ҵ���
        @return �����ҵ������±���ɵ�����Ԫ��
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
     * leetcode��������ʱ�����ٵ�д��
     */
    /*
     * �������һ��Map���������˼·�Ƚ����������ò�������������Ƚ���������������������ִ�еĹ����У�
     * ��ִ�б߹���Mapӳ��
     * ��һ��ȱ����ǣ�����������������ͬ��Ԫ�ص�ʱ���䱣����ֻ�������鿴���������Ԫ�ص��±�
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









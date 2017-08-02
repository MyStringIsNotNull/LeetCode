package easy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array of integers, 
find out whether there are two distinct indices i and j in the array 
such that the absolute difference between nums[i] and nums[j] is at most t 
and the absolute difference between i and j is at most k. 

����һ���������飬
�ҳ������������Ƿ���������ͬ������i��j
ʹ��nums[i]��nums[j]��ֵ�ľ���ֵ֮�����Ϊt
ͬʱʹ������i��j�ľ���ֵ֮�����Ϊk

 */
public class ContainsDuplicateIII 
{
	/**
	 * ������ʱ�䳬ʱ
	 * ��Ϊ�����ƽ��һ�ַ�����Ϊ�ˣ���������һ�ַ���
	 * 
	 */
	
	/*
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
    {
		boolean result=false;
       for(int i=1;i<=k&&!result;i++)
       {
    	   for(int tem=0;tem<nums.length-i;tem++)
    	   {
    		   if(Math.abs((double)nums[tem]-nums[tem+i])<=t)
    		   {
    			   result=true;
    			   break;
    		   }
    	   }
       }
       return result;
    }
	*/
	
	/**
	 * �����˼·Ϊά��һ����СΪk�Ļ������ڣ��䴰���е�Ԫ���ж��Ƿ�Ϊ��nums[i]+t��nums[i]-t֮��
	 * 
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
    {
	     if (nums == null || nums.length == 0 || k <= 0)
	        return false;
	     TreeSet<Long> ts = new TreeSet();
	     for (int i = 0; i < nums.length; ++i) 
	     {
	        Long right = ts.floor((long) nums[i] + t);//��ȡ��TreeSet��С�ڵ���nums[i]+t��Ԫ�أ�û��ʱ����null
	        Long left = ts.ceiling((long) nums[i] - t);//��ȡ��TreeSet�д��ڵ���nums[i]-t��Ԫ��,û��ʱ����null
	        if (right != null && left != null && right >= left)
	            return true;
	        ts.add((long) nums[i]);
	        if (i >= k)
	            ts.remove((long) nums[i-k]);
	
	     }
	     return false;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·Ϊ��ÿ��ȡ������k��Ԫ�أ����������Ƿ��������Ԫ��֮��Ĳ����k��Ԫ��
	 * 
	 */
	/*
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
	{
        int size = nums.length;
        if(size >= 20000)return false;
        if (k >= size) 
        {
            return containsNearbyAlmostDuplicate(nums, t);
        }
        if (k > 0 && size > 1) 
        {
            int i = 0;
            while (i < size - k) 
            {
            	//Arrays.copyOfRange(T[ ] original,int from,int to)	��һ��ԭʼ������original�����±�from��ʼ���ƣ�
            	// ���Ƶ��±�to������һ���µ����顣ע����������±�from���������±�to��
                if (containsNearbyAlmostDuplicate(Arrays.copyOfRange(nums, i, i + k + 1), t))
                    return true;
                i++;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int t) 
    {
        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < size; i++) 
        {
        	//��������֮������������ڵ���������Ԫ�أ���Ϊ���ڵ���������Ԫ��֮��Ĳ�Ϊ��С��(����ڸ���Ԫ�ض���)
            int result = nums[i] - nums[i - 1];
            if (result <= t && result >= 0)
            {
                return true;
            }
        }
        return false;
    }
	*/
	
}

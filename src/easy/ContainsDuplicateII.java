package easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the absolute difference between i and j is at most k. 

����һ�����������һ������k
�ҳ����Ƿ����������ͬ������Ԫ������i��jʹ��nums[i]==nums[j]
����������i��j�Ĳ�ľ���ֵ�����Ϊk

 */
public class ContainsDuplicateII 
{
	/**
	 * ���ύ����leetcode��ʱ���䳬ʱ
	 * ��ʱ�临�Ӷ�ΪO(kn),�ռ临�Ӷ�ΪO(0)Ϊ�ˣ��ʲ��������һ�ַ���
	 * 
	 */
	
	/*
	public boolean containsNearbyDuplicate(int[] nums, int k) 
	{
		boolean result=false;
		for(int i=1;i<=k&&!result;i++)
		{
			for(int tem=0;tem<nums.length-i;tem++)
			{
				if(nums[tem]==nums[tem+i])
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
	 * ���ڸ��㷨����ʱ�临�ӶȺͿռ临�ӶȾ�ΪO(n)
	 */
	
	
	public boolean containsNearbyDuplicate(int[] nums, int k) 
	{
		boolean result=false;
		Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(!map.containsKey(nums[i])||Math.abs(map.get(nums[i])-i)>k)
				map.put(nums[i], i);
			else
			{
				result=true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��ʱ�临�Ӷ�ΪO(n),�ռ临�Ӷ�ΪO(1)
	 * �������Ȼͨ����leetcode�ϴ�����ύ���飬����������bug��˵����leetcode�ϵĴ����ύ�ɹ��Ĳ�һ���ǰٷְ���ȷ��
	 * �ʲ��Ƽ��������
	 * 
	 */
	
	/*
	 public boolean containsNearbyDuplicate(int[] nums, int k) 
	 {
	        if(k==0) 
	        	return false;
	        int l = 0;
	        int r = 1;
	        while(r < nums.length) 
	        {
	            if(l < r && nums[r] == nums[l]) 
	            	return true;
	            if(r - l == k) 
	            {
	                l++;
	            } 
	            else 
	            {
	                r++;
	            }
	        }
	        while(l < r-1) 
	        {
	            if(nums[l++] == nums[r-1]) 
	            	return true;
	        }
	        return false;
	  }
	*/
	/**
	 * leetcode�Ͽ����ģ���Ϊû��bug�ģ�������ʱ����Խ��ٵ�һ�ݴ���
	 *��˼·ͬ����д�Ĵ��룬��������Ϊ���
	 *
	 */
	/*
	 public boolean containsNearbyDuplicate(int[] nums, int k) 
	 {
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 0; i < nums.length; i++)
	        {
	            if(i > k) 
	            	set.remove(nums[i-1-k]);
	            if(!set.add(nums[i])) //set.add����false�����Ϊ���ڼ����д�����Ԫ��nums[i]��ֵ
	            	return true;
	        }
	        return false;
	    }
	*/
	
	/**
	 * 
	 * ���Ͽ�������һ�ݴ��룬��˼·�Ƚ�����
	 * �ʽ�����ڴ˴���Ϊ�ο�
	 * ������˼·Ϊ������Numά��һ��������k��Ԫ�ص����ݽṹ
	 * �ڼ���Num�е���k��Ԫ�أ����ǲ��ظ���
	 * (
	 * �ɽ�����Numά����k��Ԫ�صļ��Ͽ���һ���������ڣ��ڼ���Num�еģ�Ϊ����������1~k֮�������Ԫ��
	 * ͨ�����ϵ��ƶ��û������ڣ��Բ鿴����������������1~k֮���Ԫ��ֵ��ȵ�����Ԫ��
	 * )
	 */
	/*
	public boolean containsNearbyDuplicate(int[] nums, int k) 
	{
        Set<Integer> Num = new HashSet<Integer>();
        int left=0,right=0;
        if(nums.length==0)return false;
        for(int i=0;i<nums.length;i++){
            if(!Num.contains(nums[i])){
                Num.add(nums[i]);
                right++;
            }else return true;
            if(right - left > k){
                Num.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
	*/
	
	
	
}

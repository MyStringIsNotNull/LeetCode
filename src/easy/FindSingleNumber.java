package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

����һ���������飬��������һ��Ԫ��֮�⣬����ÿ��Ԫ�س������Ρ����ҳ��Ǹ���������

ע��:
����㷨������O(n)��ʱ�临�Ӷȡ����ܹ���û��ʹ�ö���Ŀռ�������ʵ������
 */
public class FindSingleNumber 
{
	/**
	 * ���´����ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ҲΪO(n)
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
		//�˴���Map���б������ٶȻ�����ʹ���������ע�͵ķ�ʽ��Map���б����ķ�ʽ
		//���ٶȱ���ȡ������ȡ��ֵ���ٶȻ����
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
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ��룬��Ҫ�������˼�룬�˴����˼·���ǳ������������Ҵ����̣�ʱ�临�ӶȺͿռ临�ӶȺܵ�
	 * ͬʱ������ʹ����λ����ķ�ʽ�����ٶȻ�ܿ�
	 * ��ԭ��ͬ���������н�����^����ķ���������������
	 * a��b��
	 * a^=b;
	 * b^=a;
	 * a^=b;
	 * �ķ�ʽ
	 * 
	 * �Զ�����������(^)����ʱ���������������ʱ����һ���ǽ�ֵ���뵽���У��ڶ��ζԸ���������������ǽ��������н�������
	 * �õ��Ľ��Ϊ�����������������Ľ��
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

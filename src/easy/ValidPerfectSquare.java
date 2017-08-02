package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True

Example 2:

Input: 14
Returns: False

����һ����������дһ������������һ��������ƽ������ʱ�򣬷���true�����򣬷���false��

ע��:
��ʹ���κ����õĺ����⣬����sqrt

����:
����:16
����:True

����:14
����:False
 */
public class ValidPerfectSquare 
{
	/**
	 * �÷�����leetcode���ύʱ������ʱ�䳬��
	 * Ϊ�˲������µķ���
	 */
	 /*
	public boolean isPerfectSquare(int num) 
	{
        int i=0;
        while(num>i*i)
        {
        	i++;
        }
        if(i*i==num)
        	return true;
        else
        	return false;
    }
    */
	
	/**
	 * �˴������˶��ֲ��ҵ�˼��
	 */
	public boolean isPerfectSquare(int num)
	{
		if(num < 1) 
			return false;  
        if(num == 1) 
        	return true;  
        int left = 0, right = num/2;  
        while(left <= right)  
        {  
            int mid = (left+right)/2;  
            //���ｫmid��int����ת��Ϊlong���ͣ�Ȼ���ٽ�����ˣ�Ϊ���Ƿ�ֹ��������������������´�������г���
            long val =(long)mid*(long)mid;  
            if(val == num) 
            	return true;  
            else if(val > num) 
            	right = mid-1;  
            else 
            	left = mid+1;  
        }  
        return false;  
    }  
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·ͬ�ϱ���һ��
	 */
	/*
	 public boolean isPerfectSquare(int num) 
	 {
        if(num < 2)
         	return true;
        long left = 0, right = (long)num;
        while(left < right)
        {
            long mid = left + (right - left) / 2;
            if(mid * mid == (long) num) 
            	return true;
            else if(mid * mid < (long)num) 
            	left = mid + 1;
            else 
            	right = mid - 1;
        }
        return left*left == (long)num;
    }
	 */
	
}

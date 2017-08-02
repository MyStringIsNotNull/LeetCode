package easy;
/**
 * 
 * @author 学徒
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

给定一个正整数，写一个函数当其是一个完美的平方数的时候，返回true，否则，返回false；

注意:
不使用任何内置的函数库，例如sqrt

例如:
输入:16
返回:True

输入:14
返回:False
 */
public class ValidPerfectSquare 
{
	/**
	 * 该方法在leetcode上提交时，运行时间超过
	 * 为此采用如下的方法
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
	 * 此处采用了二分查找的思想
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
            //这里将mid从int类型转化为long类型，然后再进行相乘，为的是防止其出现溢出的情况，而导致代码的运行出错
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
	 * leetcode上运行时间最短的代码
	 * 其思路同上保持一致
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

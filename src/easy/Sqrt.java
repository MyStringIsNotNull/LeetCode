package easy;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * question:

Implement int sqrt(int x).

Compute and return the square root of x.

实现int sqrt(int x)

计算并返回sqrt的平方根
 */
public class Sqrt 
{
	public static void main(String[] args)
	{
		Sqrt n=new Sqrt();
		System.out.println(n.mySqrt(2147395600));
	}
	
	
	/*
	 *对于这道简单的题目，实际上要进行考虑的是溢出的问题
	 *如过使用int类型的时候，mySqrt(2147395600)这样的写法会使得result*result的结果产生溢出
	 *
	 */
	/*public int mySqrt(int x) 
	{
		if(x<0)
			return -1;
		else if(x==0)
			return 0;
		int result=1;
		while(result*result<=x)
		{
			result++;
		}
		return result-1;
    }*/
	
	/*
	 * 这样的写法，不会产生溢出
	 */
/*	public int mySqrt(int x) 
	{
		if(x<0)
			return -1;
		else if(x==0)
			return 0;
		long result=1;
		long multiply=result*result;
		while(multiply<=x)
		{
			result++;
			multiply=result*result;
		}
		return (int)result-1;
    }*/
	
	/**
	 * leetcode上运行时间最少的代码
	 * 推荐阅读的代码，采用的思路为二分查找的思路，使其时间复杂度降低了很多
	 * 
	 */
	
	
    public int mySqrt(int x) 
    {
    	if( x == 0)
    		return 0;
    	int left = 0;
    	int right = Integer.MAX_VALUE;
        while(true)
        {
            int mid = left + (right - left)/2;
            if(mid > x/mid)
            {
                right = mid - 1;
            }
            else
            {
                if(mid + 1 > x/(mid+1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    
}

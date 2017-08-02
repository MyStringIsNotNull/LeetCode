package easy;
/*
 * 
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows. 

用于倒置一个数，如上例子
 */
public class ReverseNumber 
{
	public int reverse(int x) 
	{
		int result=0;
		result=Integer.parseInt(reverseString(x));
        return result;
    }
	/**
	 * 用于倒置一个数
	 * @param x 需要进行倒置的那个数
	 * @return 倒置结果
	 */
	public String reverseString(int x)
	{
		String result="0";
		final int MAX=Integer.MAX_VALUE;
		final int MIN=Integer.MIN_VALUE;
		String value=String.valueOf(x);
		int index=0;
		if(x<0)
			index=1;
		for(int i=value.length()-1;i>=index;i--)
		{
			char s=value.charAt(i);
			result+=String.valueOf(s);
		}
		if(index==1)
			result="-"+result;
		try
		{
			Integer.parseInt(result);
		}
		catch(Exception e)
		{
			result="0";
		}
		return result;
	}
	
	 /**
     * 
     * leetcode上所花费时间最少的写法
     * 
     */
	/*public int reverse(int x) 
	{
        long result=0;
		long tem=x;
        while(tem!=0)
        {
            result=result*10+tem%10;
            tem/=10;
		}
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) 
	    {
	        result=0;
	    }
       	return (int)result;
    }*/
	
}

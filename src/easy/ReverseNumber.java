package easy;
/*
 * 
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows. 

���ڵ���һ��������������
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
	 * ���ڵ���һ����
	 * @param x ��Ҫ���е��õ��Ǹ���
	 * @return ���ý��
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
     * leetcode��������ʱ�����ٵ�д��
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

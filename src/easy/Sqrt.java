package easy;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * question:

Implement int sqrt(int x).

Compute and return the square root of x.

ʵ��int sqrt(int x)

���㲢����sqrt��ƽ����
 */
public class Sqrt 
{
	public static void main(String[] args)
	{
		Sqrt n=new Sqrt();
		System.out.println(n.mySqrt(2147395600));
	}
	
	
	/*
	 *��������򵥵���Ŀ��ʵ����Ҫ���п��ǵ������������
	 *���ʹ��int���͵�ʱ��mySqrt(2147395600)������д����ʹ��result*result�Ľ���������
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
	 * ������д��������������
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
	 * leetcode������ʱ�����ٵĴ���
	 * �Ƽ��Ķ��Ĵ��룬���õ�˼·Ϊ���ֲ��ҵ�˼·��ʹ��ʱ�临�ӶȽ����˺ܶ�
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

package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. 

编写一个程序，判断一个给定的数是否为丑数

丑数为一个正整数，且其素数因子只包括2，3,5

例如，6,8为一个丑数而14并不是一个丑数，因为它包含了其它的素数因子7

提示：

1是一个典型的丑数

 */
public class UglyNumber 
{
	public boolean isUgly(int num)
	{
		boolean result=true;
		if(num>=1)
		{
			//构建该factors的目的在于，任何丑数，都可以分解为2,3,5这五个数的乘积
			int[] factors=new int[3];
			factors[0]=2;
			factors[1]=3;
			factors[2]=5;
			while(num!=1)
			{
				boolean divid=false;
				for(int factor:factors)
				{
					if(num%factor==0)
					{
						divid=true;
						num/=factor;
					}
				}
				if(!divid)
				{
					result=false;
					break;
				}
			}
		}
		else
			result=false;
		return result;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路同上
	 * 
	 */
	
	/*
	public boolean isUgly(int num) 
	{
        if(num <= 0) 
        	return false;
        while(num % 5 == 0) 
        {
            num /= 5;
        }
        while(num % 3 == 0) 
        {
            num /= 3;
        }
        while(num % 2 == 0) 
        {
            num /= 2;
        }
        return num == 1;
    }
    */
}

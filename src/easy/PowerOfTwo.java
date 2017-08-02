package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an integer, write a function to determine if it is a power of two. 

给定一个整数，编写一个函数判断其是否为2的幂次
 */
public class PowerOfTwo 
{
	public boolean isPowerOfTwo(int n)
	{
		boolean result=true;
		if(n>0)
		{
			while(n!=1)
			{
				if(n%2!=0)
				{
					result=false;
					break;
				}
				n/=2;
			}
		}
		else
			result=false;
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码\
	 * 推荐阅读的代码
	 * 其思路为
	 * 2的次方数的二进制写法的特点：
		1     2       4         8         16 　　....
		1    10    100    1000    10000　....
		那么我们很容易看出来2的次方数都只有一个1，剩下的都是0
		
		如果一个数是2的次方数的话，根据上面分析，那么它的二进数必然是最高位为1，其它都为0，那么如果此时我们减1的话，
		
		则最高位会降一位，其余为0的位现在都为变为1，那么我们把两数相与，就会得到0，用这个性质也能来解题
	 */
	/*
	public boolean isPowerOfTwo(int n) 
	{
        return n>0&&(n & (n - 1)) == 0;
    }
	*/
	
}

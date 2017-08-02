package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion? 

给定一个32位的符号整数，编写一个函数检查其是否为4的幂次

例如:
给定num=16，返回true。给定num=5,返回false；

接着:
你能不使用循环和递归吗？

 */
public class PowerOfFour 
{
	public boolean isPowerOfFour(int num) 
	{
		return (num>0)&&((num&(num-1))==0)&&(Integer.toBinaryString(num).length()%2==1);
    }
	
	/**
	 * 
	 * leetcode上运行时间最短的代码
	 * 十六进制数0x55555555，其转化为二进制时，其奇数位上为全为1，偶数位上全为0(从1开始算起)
	 * 对于一个数，若该数为4的幂次，则该数转化为2进制时，其1处于奇数位上
	 * 
	 */
	
	/*
	 public boolean isPowerOfFour(int num) 
	 {
	       return (((num & (num-1))==0) && ((num & 0x55555555)!=0));
	  }
	*/
	
}

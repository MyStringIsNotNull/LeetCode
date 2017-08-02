package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime? 

给定一个非负整数num，重复的加上其各位数字之和，直到其只剩下一个数字
例如:
给定num = 38，执行的过程为3 + 8 = 11, 1 + 1 = 2，因为2只有一个数字，所以返回它
接着:
你能不用任何循环/递归并在时间复杂度为O(1)的情况下完成吗？

 */
public class AddDigits
{
	public int addDigits(int num)
	{
		if(num<10)
			return num;
		int number=0;
		while(num!=0)
		{
			number+=num%10;
			num/=10;
		}
		return addDigits(number);
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其思路为:
	 * 假设输入的数字是一个5位数字num，则num的各位分别为a、b、c、d、e。

		有如下关系：num = a * 10000 + b * 1000 + c * 100 + d * 10 + e

		即：num = (a + b + c + d + e) + (a * 9999 + b * 999 + c * 99 + d * 9)

		因为 a * 9999 + b * 999 + c * 99 + d * 9 一定可以被9整除，因此num模除9的结果与 a + b + c + d + e 模除9的结果是一样的
		（其中num在模9之后。a + b + c + d + e部分一定小于9）。
	 * 
	 */
	
	/*
	public int addDigits(int num) 
	{
        if (num == 0) 
        	return 0;
        if (num % 9 == 0) 
        	return 9;
        return num % 9;
    }
	*/
	
	/**
	 *
	 *blog上最简便的代码，其代码的思路同上
	 *
	 */
	/*
	public int addDigits(int num)
	{
        return (num - 1) % 9 + 1;
    }
	*/
	
}

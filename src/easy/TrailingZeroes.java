package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

给定一个整数，返回n!的末尾0的个数
注意:你的答案必须是对数的时间复杂度

 */
public class TrailingZeroes 
{
	/**
	 * 注意到，n!中尾数0的个数由n!中所有因子组合中2*5的组合所组成
	 * 由于n!中分解出来的2的个数多于分解出来5的个数，为此，只需计算5的个数即可
	 * 对于5的个数的计算，注意到
	 * 5!有1个5
	 * 10!有2个5
	 * 15!有3个5
	 * ...
	 * 25!有6个5(分别为1*5中的5，2*5中的5.....而5*5中的5的个数算2个)
	 * 为此，要计算n!中5的个数，应计算Sum(N/5^1,N/5^2,N/5^3.....)
	 * 
	 */
	public int trailingZeroes(int n) 
    {
		if(n<1) 
			return 0;   
        int number = 0;   
        while(n/5 != 0) {    
            n /= 5;   
            number += n;   
        }   
        return number;   
    }
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路同上
	 * 
	 */
	
	/*public int trailingZeroes(int n)
	{
        int sum = 0;
        while(n > 0) {
            n /= 5;
            sum += n;
        }
        return sum;
    }*/
	
}

package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3. 

计算两数，a和b的和，但是不运行使用+和-操作符

例如:
给定 a=1和b=2，返回3

 */
public class SumOfTwoInteger
{
	/**
	 * 对a和b进行按位运算
	 * 对于位运算，xor(^)得到的结果相当于两个数对应位的和，AND(&)得到的结果如果对应位为1则相当于他们在改为上有进位
	 */
	public int getSum(int a, int b) 
	{
		//用于记录进位
		int carry=(a&b)<<1;
		//用于记录和
		int result=a^b;
		//证明其上有进位
		while(carry!=0)
		{
			int temp=result;
			//加上进位得到结果
			result^=carry;
			//获取加上进位前两数的进位情况
			carry&=temp;
			carry<<=1;
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码由于不符合题意，所以使用了博客上的写得还好的代码
	 * 推荐阅读的代码
	 * 其思路同上
	 */
	/*
	public int getSum(int a, int b) 
	{
        while (b != 0) 
        {
        	//用于得到其和
            int c = a ^ b;
            //用于得到进位
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
	*/
	
	/**
	 * 博客上的另外的一个解题思路
	 * 思路为:位运算（Bit Manipulation) 模拟加法
	 *该方法的思路同上，一样是按位运算，但是，其每次只是运算一位
	 */
	/*
	public int getSum(int a, int b)
	{
		//r用于存储运算的结果，c用于记录进位情况，p用于控制目前进行运算的是第几位(即p中只有一个二进制位为1，且该1所在的位即为第几位进行运算)
		int r = 0, c = 0, p = 1;
		//其停止的条件为a，b，c中均没有二进制位为1了
		while ((a | b | c) != 0)
		{
			if (((a ^ b ^ c) & 1) != 0)
				r |= p;
			p <<= 1;
			c = (a & b | b & c | a & c) & 1;
			a >>>= 1;
			b >>>= 1;
		}
		return r;
	}
	*/
}

package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100)

return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it? 

颠倒给定的32位的无符号整数的各位

例如，给定输入43261596 (对应的二进制为 00000010100101000001111010011100)

返回964176192 (对应的二进制为 00111001011110000010100101000000).

继续:
如果这个功能估计很多时间，如何使其最优化？

 */
public class ReverseBits 
{
	// you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
    	return Integer.reverse(n);
    }
    
    /**
     * leetcode上运行时间最短的代码
     * ps,java中的位运算符如下:
     * <<按位左移，低位补0
     * >>按位右移，高位补符号位(0为正，1为负)
     * >>>无符号右移，高位补0
     * |按位或运算
     * &按位与运算
     * 其中,n>>=1表示的为n=n>>1（其相当于n+=1那样的运算）
     */
    
    /*
    public int reverseBits(int n) 
    {
        int res = 0;
        for(int i = 0; i < 32; ++i, n >>= 1) 
        {
        	//n&1的作用为取其n的最低位
        	//res<<1的作用为将其res往左移动一位
        	//res<<1|(n&1)的作用为，将n的最低位放置在res的最低位
            res = res << 1 | (n & 1) ;
            
        }
        return res;
    }
    */
}

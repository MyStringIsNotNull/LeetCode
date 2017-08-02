package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function should return 3.

写一个函数用于计算并返回32位无符号整数中二进制形式的1的位数(也成为加权平均)

例如，32位整数11其二进制表示形式为00000000000000000000000000001011，所以，你的函数必须返回值3

 */
public class NumberOfOneBits
{
	// you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
    	int numbers=0;
    	int temp=0;
    	for(int index=0;index<32;index++,n>>>=1)
    	{
    		temp=n&1;
    		if(temp==1)
    		{
    			temp=0;
    			numbers++;
    		}
    	}
    	return numbers;
    }
    /**
     * leetcode上运行时间最短的代码
     */
    
    /*
    public int hammingWeight(int n) 
    {
        return Integer.bitCount(n);
    }
    */
    
}

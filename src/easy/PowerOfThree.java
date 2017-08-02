package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 

给定一个整数，编写一个函数，判断其是否为3的幂次

继续:
你能不使用循环和递归吗？

 */
public class PowerOfThree
{
	public boolean isPowerOfThree(int n) 
	{
        boolean result=true;
        if(n>0)
        {
        	while(n!=1)
        	{
        		if(n%3!=0)
        		{
        			result=false;
        			break;
        		}
        		n/=3;
        	}
        }
        else 
        	result=false;
        return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其思路如下:
	 * 假设一个数Num是3的幂，那么所有Num的约数都是3的幂，如果一个数n小于Num且是3的幂，那么这个数n一定是Num的约数。
		了解上述性质，我们只需要找到一个最大的3的幂，看看参数n是不是此最大的幂的约数就行了
	 */
	/*
	public boolean isPowerOfThree(int n)
	{
		int maxPower = (int) Math.pow(3,(int)(Math.log(Integer.MAX_VALUE)/Math.log(3)));  
	    // 1162261467 is 3^19,  3^20 is bigger than int
	    return ( n>0 &&  maxPower%n==0);
	}
	*/
	
}

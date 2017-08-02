package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer. 

你正在攀爬楼梯，你有n步后到达顶端

每次你可以攀爬1到2步，你有多少种方式去爬到顶端？

注意:n是一个正整数
 */
public class ClimbingStairs 
{
	/*
	 * 
	 *思路:当楼梯数目分别为0，1，2,3,4,5，6的时候，对应的爬楼梯的种类数目为:0,1,2,3,5,8,13呈现斐波那契数列的形式增长
	 *
	 */
	public int climbStairs(int n) 
	{
        int f1=0,f2=1;
        int tem=0;
        int result=0;
        while(tem<n)
        {
        	result=f1+f2;
        	f1=f2;
        	f2=result;
        	tem++;
        }
        return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码如上一样
	 */
}

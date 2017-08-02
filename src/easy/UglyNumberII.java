package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. 

写一个程序去找出第n个丑数

丑数是一个其素数因子只有2,3,5的正整数

例如:1,2,3,4,5,6,8,9,10,12是前10个丑数序列

注意，1被当成一个典型的丑数来对待，并且n的值不超过1690

 */
public class UglyNumberII 
{
	/**
	 * 该方法在leetcode上运行时，出现时间超过的情况
	 * 其方式为暴力破解
	 * 为此考虑使用以下的方式获得第n个丑数
	 * 
	 */
	/*public int nthUglyNumber(int n) 
	{
		int number=1;
		int count=0;
		while(count!=n)
		{
			if(isUgly(number++))
				count++;
		}
		return --number;
	}
	private boolean isUgly(int n)
	{
		while(n%2==0)
			n/=2;		
		while(n%3==0)
			n/=3;
		while(n%5==0)
			n/=5;
		return n==1;
	}*/
	/**
	 * 
	 * 一个丑数为前一个丑数乘以2或者3或者5得到的，第n个丑数为所有丑数中从小到大排序的所有丑数中的第n个元素
	 *因此，可以用三个队列用于存储是2的倍数的丑数，3的倍数的丑数，5的倍数的丑数
	 * 同时，让队列中维持着最靠近当前第i个丑数的那个丑数
	 * 
	 */
	public int nthUglyNumber(int n) 
	{  
        int u = 0;  
        Queue<Integer> l1 = new LinkedList<Integer>();  
        Queue<Integer> l2 = new LinkedList<Integer>();  
        Queue<Integer> l3 = new LinkedList<Integer>();  
        l1.add(1);  
        l2.add(1);  
        l3.add(1);  
        for(int i=0; i<n; i++) 
        {  
            u = Math.min( Math.min(l1.peek(), l2.peek()), l3.peek());  
            if(l1.peek() == u) 
            	l1.poll();  
            if(l2.peek()== u) 
            	l2.poll();  
            if(l3.peek() == u) 
            	l3.poll();  
            l1.add(u*2);  
            l2.add(u*3);  
            l3.add(u*5);  
        }  
        return u;  
    }  
	
	/**
	 * 网上的另外一种实现，代码更为直观
	 * SortedSet数据结果为一个按从小到大排序的集合
	 * 
	 */
	/*
    public int nthUglyNumber(int n) 
    {  
        SortedSet<Long> s1 = new TreeSet<>();  
        s1.add((long)1);  
        long result = s1.first();  
        for(int i=0;i<n;i++)
        {  
            result = s1.first();  
            s1.add(result * 2);  
            s1.add(result * 3);  
            s1.add(result * 5); 
            //此语句的目的在于使集合中的第一个丑数为最靠近当前的第i个丑数的丑数
            s1.remove(result);  
        }  
        return (int)result;  
    }  
	*/
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路同上未注释的所写，只不过采用了不同的数据结构
	 * 
	 */
	
	/*
	public int nthUglyNumber(int n) 
	 {
        // the idea used here is that
        // every ugly no. multiplied by 2/3/5 produces an ugly number
        int ugly[]=new int[n];
        ugly[0]=1;
        // these indices keep track of which ugly no. needs to be multipied by 2/3/5
        int index2=0, index3=0, index5=0;
        // update factors to actual ugly numbers
        int factor2=2, factor3=3, factor5=5;
        for(int i=1; i<n; i++)
        {
            // since we need ugly numbers in ascending order
            int min=Math.min(Math.min(factor2, factor3), factor5);
            ugly[i]=min;
            // every ugly no. multiplied by 2/3/5 produces an ugly number
            if(min==factor2) 
            	factor2=2*ugly[++index2];
            if(min==factor3) 
            	factor3=3*ugly[++index3];
            if(min==factor5) 
            	factor5=5*ugly[++index5];
        }
        return ugly[n-1];
     }
	*/
	
	
	
}

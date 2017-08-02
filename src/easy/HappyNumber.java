package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 

Starting with any positive integer, replace the number by the sum of the squares of its digits,

and repeat the process until the number equals 1 (where it will stay), 

or it loops endlessly in a cycle which does not include 1. 

Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

写一个算法，去判断一个数是否是"happy"的

一个"happy"的数被定义为如下过程:

开始为一个正整数，取代该数用其各位数的平方和

重复该过程，直到该数等于1(在此停留下来)

或者当其无法等于1的时候，它会无止境的在此循环

那些最终以1结束的数就是happy数

 */
public class HappyNumber 
{
	public boolean isHappy(int n)
	{
		//集合set用于判断是否相加的和曾经出现过，避免了死循环的出现
		Set<Integer> set=new HashSet<Integer>();
		boolean result=false;
		while(n!=1)
		{
			int number=0;
			while(n!=0)
			{
				number+=Math.pow((n%10),2);
				n/=10;
			}
			if(set.contains(number))
				break;
			set.add(number);
			n=number;
		}
		if(n==1)
			result=true;
		return result;
    }
	/**
	 * leetcode上运行时间最短的代码
	 * 其避免死循环的关键在于n>6进入循环，否则，不进入循环
	 * 因为从2-6这5个数字的结果均不为happy数
	 * 查看另外一种代码如下，其采用了不一样的思路
	 * 
	 */
	
	/*
	public boolean isHappy(int n) 
	{
        if(n == 0)
        {
            return false;
        }
        while(n > 6)
        {
            int sum = 0;
            while(n > 0)
            {
                int num = n % 10;
                sum += num * num;
                n = n/10;
            }
            if(sum == 1)
            {
                return true;
            }
            n = sum;
        }
        return n==1;
    }
	*/
	
	/**
	 * leetcode上的另外一种代码的思路
	 * 其采用一个快指针和一个慢指针，采用进行跑圈的方式，
	 * 当快慢指针指向同一个值的时候，其可能出现的情况为
	 * low==fast==1，或者low==fast！=1
	 * 当无论哪种，最终fast和low总会相等(一个原因是因为1^2==1)
	 * 
	 */
	
	/*
	public boolean isHappy(int n) 
	{
        int slow, fast;
        slow = fast = n;
        do
        {
            slow = countsum(slow);
            fast = countsum(fast);
            fast = countsum(fast);
        }while(slow!=fast);
        if(slow == 1) 
        	return true;
        return false;
    }
    private int countsum(int n)
    {
        int sum = 0;
        while(n!=0)
        {
            int temp = n%10;
            sum += temp*temp;
            n = n / 10;
        }
        return sum;
    }
	*/
}

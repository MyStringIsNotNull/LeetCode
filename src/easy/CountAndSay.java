package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
The count-and-say sequence is the sequence of integers with the first five terms as following:



1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"

Example 2:

Input: 4
Output: "1211"

题意是n=1时输出字符串1；
n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；
n=3时，由于上次字符是11，有2个1，所以输出21；
n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211
 */
public class CountAndSay 
{

	public String countAndSay(int n) 
	{
		int number=1;
		String numberString="1";
		if(n<=0)
			return null;
		while(number<n)
		{
			numberString=toSay(numberString);
			number++;
		}
		return numberString;
    }
	/**
	 * 该方法用于实现将一个字符串进行say的功能
	 */
	public static String toSay(String s)
	{
		char[] tables=new char[]{'0','1','2','3','4','5','6','7','8','9'};
		Map<Character,Integer> table=new HashMap<Character,Integer>();
		for(int i=0;i<10;i++)
		{
			table.put(tables[i],i);
		}
		String result="";
		int[] count=new int[10];
		char previous=s.charAt(0);
		char c=s.charAt(0);
		count[table.get(previous)]++;
		for(int i=1;i<s.length();i++)
		{
			previous=c;
			c=s.charAt(i);
			//当读到不连续的数字时，将其读出并让其重新计算
			if(previous!=c)
			{	
				int number=table.get(previous);
				result+=count[number];
				count[number]=0;
				result+=previous;
			}
			count[table.get(c)]++;
		}
		for(int i=0;i<count.length;i++)
		{
			if(count[i]!=0)
			{
				result+=count[i];
				result+=i;
			}
		}
		return result;
	}
	
	
	/**
	 * leetcode上运行时间最次短的代码，最短的那个目前惨不忍睹。。时间:2017年7月2日
	 * 此问题解决的思路同上面自己所写的代码，只是实现的过程所使用的方式不同而已
	 */
	/*public String countAndSay(int n)
	{
	     String s="1";  
	    for(int i=2;i<=n;i++)
	    {
	            s=count(s);
	    }
		return s;
	}
	    
    private String count(String s)
    {
        int count=1;
        StringBuilder sb=new StringBuilder();
        for(int j=1;j<=s.length();j++)
        {
            if(j==s.length()||s.charAt(j)!=s.charAt(j-1))
            {
                sb.append(count);
                sb.append(s.charAt(j-1));
                count=1;
            }
            else
            {
               count++;
            }
        }
        return sb.toString();
    }*/
}

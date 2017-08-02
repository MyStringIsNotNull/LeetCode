package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ѧͽ
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

������n=1ʱ����ַ���1��
n=2ʱ�����ϴ��ַ����е���ֵ��������Ϊ�ϴ��ַ�����1��1���������11��
n=3ʱ�������ϴ��ַ���11����2��1���������21��
n=4ʱ�������ϴ��ַ�����21����1��2��1��1���������1211
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
	 * �÷�������ʵ�ֽ�һ���ַ�������say�Ĺ���
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
			//������������������ʱ������������������¼���
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
	 * leetcode������ʱ����ζ̵Ĵ��룬��̵��Ǹ�Ŀǰ�Ҳ��̶á���ʱ��:2017��7��2��
	 * ����������˼·ͬ�����Լ���д�Ĵ��룬ֻ��ʵ�ֵĹ�����ʹ�õķ�ʽ��ͬ����
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

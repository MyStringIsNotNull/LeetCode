package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. 

If there are less than k characters left, reverse all of them.

If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:

The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

给定一个字符串和一个整数k，每2k个字符翻转前k个字符。如果剩余字符不足k个，则全部翻转。

如果剩余字符在k(包括k)到2k之间，则翻转前k个字符，剩余字符保持原样。

约束:
字符串中只存在小写字母
给定的字符串和k的大小在[1,10000]的范围内

 */
public class ReverseStringII
{
	public static void main(String[] args)
	{
		String s="krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";
		ReverseStringII a=new ReverseStringII();
		System.out.println(a.reverseStr(s,20));
		int i=1;
		for(char c:s.toCharArray())
		{
			if(i%40==0)
			{
				System.out.println();
				i=0;
			}
			System.out.print(c);
			i++;
		}
	}
	public String reverseStr(String s, int k) 
	{
		char[] word=s.toCharArray();
		int length=word.length;
		int low=0;
		int high=low+2*k-1;
		while(high<length)
		{
			reverse(word,low,low+k-1);
			low=high+1;
			high=low+2*k-1;
		}
		if((low+k)>=length)
		{
			reverse(word,low,length-1);
		}
		else
		{
			reverse(word,low,low+k-1);
		}
		return new String(word);
    }
	
	private void reverse(char[] word,int low,int high)
	{
		while(low<high)
		{
			char c=word[low];
			word[low]=word[high];
			word[high]=c;
			low++;
			high--;
		}
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 
	 */
/*
	public String reverseStr(String s, int k)
	{
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i += 2 * k)
		{
			//证明其剩余的字符小于等于k个
			if (i + k > arr.length)
				reverse(arr, i, arr.length - 1);
			else
				reverse(arr, i, i + k - 1);
		}
		return new String(arr);
	}

	public void reverse(char[] arr, int begin, int end)
	{
		while (begin < end)
		{
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
	}*/
	
}

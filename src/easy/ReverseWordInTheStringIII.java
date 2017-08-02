package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string. 

给定一个字符串，你需要去颠倒句子中的每个单词的字符的顺序，同时保持空格和单词的初始顺序

例如:
输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"

注意:
在字符串中，每个单词由一个空格所分隔开，同时，在字符串中不会有多余的空格

 */
public class ReverseWordInTheStringIII
{
	public String reverseWords(String s) 
	{
		StringBuilder result=new StringBuilder();
		String[] rep=s.split(" ");
		for(int i=0;i<rep.length;i++)
		{
			result.append(reverseString(rep[i])+" ");
		}
		return result.toString().trim();
    }
	private String reverseString(String s)
	{
		char[] c=s.toCharArray();
		int low=0;
		int high=c.length-1;
		while(low<high)
		{
			char tem=c[low];
			c[low]=c[high];
			c[high]=tem;
			low++;
			high--;
		}
		return new String(c);
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码，其代码的思路同上，但是其使用的是indexOf里面的重载方法
	 * 推荐阅读的原因是，了解使用indexOf方法的重载方法
	 */
/*
	public String reverseWords(String s)
	{
		char[] chars = s.toCharArray();
		int begin = 0;
		int end = s.indexOf(' ', begin);
		while (end != -1)
		{
			reverseWord(chars, begin, end - 1);
			begin = end + 1;
			end = s.indexOf(' ', begin);
		}
		reverseWord(chars, begin, chars.length - 1);
		return new String(chars);
	}

	private void reverseWord(char[] word, int begin, int end)
	{
		while (begin < end)
		{
			char temp = word[begin];
			word[begin] = word[end];
			word[end] = temp;
			begin++;
			end--;
		}
	}*/
	
}

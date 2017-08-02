package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string. 

����һ���ַ���������Ҫȥ�ߵ������е�ÿ�����ʵ��ַ���˳��ͬʱ���ֿո�͵��ʵĳ�ʼ˳��

����:
����: "Let's take LeetCode contest"
���: "s'teL ekat edoCteeL tsetnoc"

ע��:
���ַ����У�ÿ��������һ���ո����ָ�����ͬʱ�����ַ����в����ж���Ŀո�

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
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ��룬������˼·ͬ�ϣ�������ʹ�õ���indexOf��������ط���
	 * �Ƽ��Ķ���ԭ���ǣ��˽�ʹ��indexOf���������ط���
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

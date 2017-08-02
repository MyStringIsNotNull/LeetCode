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
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y". 

编写一个函数，去颠倒字符串中的元音字母

例子1:
给定 s="hello" 返回 holle

例子2:
给定 s="leetcode" 返回 "leotcede"

ps:元音字母分别有 u a e o i

 */
public class ReverseVowelsOfString
{
	public String reverseVowels(String s) 
	{
		Set<Character> vowels=new HashSet<Character>();
		vowels.add('u');
		vowels.add('a');
		vowels.add('e');
		vowels.add('o');
		vowels.add('i');
		vowels.add('U');
		vowels.add('A');
		vowels.add('E');
		vowels.add('O');
		vowels.add('I');
        char[] word=s.toCharArray();
        int length=word.length;
        int low=0;
        int high=length-1;
        while(low<high)
        {
        	if(!vowels.contains(word[low]))
        		low++;
        	if(!vowels.contains(word[high]))
        		high--;
        	if(vowels.contains(word[high])&&vowels.contains(word[low]))
        	{
        		char c=word[high];
        		word[high]=word[low];
        		word[low]=c;
        		low++;
        		high--;
        	}
        }
        return new String(word);
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 
	 */
	/*
	public String reverseVowels(String s)
	{
		if (s.length() == 0)
			return "";
		char[] res = s.toCharArray();
		int st = 0, end = res.length - 1;
		boolean[] isv = new boolean[256];
		isv['a'] = true;
		isv['e'] = true;
		isv['i'] = true;
		isv['o'] = true;
		isv['u'] = true;
		isv['A'] = true;
		isv['E'] = true;
		isv['I'] = true;
		isv['O'] = true;
		isv['U'] = true;
		while (true)
		{
			while (st < end && !isv[res[st]])
				st++;
			while (st < end && !isv[res[end]])
				end--;
			if (st >= end)
				break;
			char temp = res[st];
			res[st] = res[end];
			res[end] = temp;
			st++;
			end--;
		}
		return new String(res);
	}*/
	
}

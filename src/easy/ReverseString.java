package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh". 

编写一个函数，其接收一个字符串，并将其颠倒之后返回

 */
public class ReverseString
{
	/**
	 * 该算法的时间和空间复杂度均为O(n)
	 */
	public String reverseString(String s)
	{
		if(s==null)
			return null;
		StringBuilder result=new StringBuilder();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++)
			stack.push(s.charAt(i));
		while(!stack.isEmpty())
			result.append(stack.pop());
		return result.toString();
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 该算法的时间和空间复杂度也为O(n)，但是由于其使用的是基本数据类型
	 * 并没有使用集合，为此其运行的时间会较上面的短
	 */
	
	/*
	public String reverseString(String s)
	{
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) 
        {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }*/
	
}

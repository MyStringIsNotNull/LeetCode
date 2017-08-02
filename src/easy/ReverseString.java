package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh". 

��дһ�������������һ���ַ�����������ߵ�֮�󷵻�

 */
public class ReverseString
{
	/**
	 * ���㷨��ʱ��Ϳռ临�ӶȾ�ΪO(n)
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
	 * leetcode������ʱ����̵Ĵ���
	 * ���㷨��ʱ��Ϳռ临�Ӷ�ҲΪO(n)������������ʹ�õ��ǻ�����������
	 * ��û��ʹ�ü��ϣ�Ϊ�������е�ʱ��������Ķ�
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

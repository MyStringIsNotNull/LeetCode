package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, '()' and '()[]{}' are all valid but '(]' and '([)]' are not.

给一串字符，里面只是包括了 '(', ')', '{', '}', '[' ']'这三种括号类型而已，判断输入的字符是不是有效的
括弧必须是按照正确的顺序进行关闭的，像'()' 和 '()[]{}' 这样的括弧字符串是有效的，而像'(]' 和 '([)]'这样的字符串是无效的
 */
public class BracketsClose 
{
	public boolean isValid(String s) 
	{
		boolean result=true;
		if(s.length()%2==1)
			result=false;
		else
		{
			Map<Character,Integer> table=new HashMap<Character,Integer>();
			table.put('(',1);
			table.put(')', 1);
			table.put('[', 2);
			table.put(']', 2);
			table.put('{', 3);
			table.put('}', 3);
			Stack stack=new Stack();
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				switch(c)
				{
					case '(':
					case '[':
					case '{':
						stack.push(c);
						break;
					default:
						if(stack.isEmpty())
                            result=false;
						else if(table.get(c)!=table.get(stack.pop()))
							result=false;
				}
				if(!result)
					break;
			}
			if(!stack.isEmpty()&&result)
                result=false;
		}
		return result;
    }
	
	
	/**
	 * leetcode上运行时间较少的代码
	 */
	/*public boolean isValid(String s) 
	{
		//用于维护一个栈
        char[] stack = new char[s.length()];
        int stackTop = -1;
        int i=0;
        while(i<s.length())
        {
            char next = s.charAt(i);
            if(next == '(' || next == '[' || next == '{')
            {
                stack[++stackTop] = next;
            }
            else 
            {
                if(stackTop == -1 || getClosingPair(stack[stackTop]) != next)
                {
                    return false;
                }
                else 
                {
                    stackTop--;
                }
            }
            i++;
        }
        if(stackTop == -1)
        {
            return true;
        }
        return false;
    }
    
    public char getClosingPair(char c)
    {
        switch(c)
        {
            case '{': return '}';
            case '(': return ')';
            case '[': return ']';
        }
        return 'a';
    }*/
	
}

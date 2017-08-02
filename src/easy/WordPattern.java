package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:

pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 

给定一个模式和一个字符串str，查找其是否和相应的模式匹配
这意味着全匹配，这在不为空的字符串str和模式中，其为一个双射的(既满射又单射)

例如:
pattern = "abba", str = "dog cat cat dog" 必须返回true.
pattern = "abba", str = "dog cat cat fish" 必须返回 false.
pattern = "aaaa", str = "dog cat cat dog" 必须返回 false.
pattern = "abba", str = "dog dog dog dog" 必须返回 false.

提示:
你必须假设模式字符只包含小写字母，和str也只包含小写字母，其str中的各个单词由空格进行分隔

*/
 
public class WordPattern 
{
	public boolean wordPattern(String pattern, String str) 
	{
		boolean result=true;
		//用于记录从pattern到str的映射
		Map<Character,String> word=new HashMap<Character,String>();
		//用于记录从str到pattern的映射
		Map<String,Character> patterns=new HashMap<String,Character>();
		String[] strArray=str.split(" ");
		if(pattern.length()!=strArray.length)
			result=false;
		else
		{
			
			for(int index=0;index<pattern.length();index++)
			{
				char c=pattern.charAt(index);
				String s=strArray[index];
				if(!word.containsKey(c)&&!patterns.containsKey(s))
				{
					patterns.put(s,c);
					word.put(c, s);
				}
				else if(word.containsKey(c))
				{
					if(!word.get(c).equals(s))
					{
						result=false;
						break;
					}
				}
				else if(!word.containsKey(c)&&patterns.containsKey(s))
				{
					result=false;
					break;
				}
			}
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路为利用模式串中的，最多只能为26个字母的特点，将每一个字母映射到成每一个数字
	 * 之后，每一个数字和str中的每一个单词进行映射,但其不好的地方在于其只能为单词之间的，若出现
	 * 了26个小写字母之外的，其会出现错误的情况
	 * 推荐阅读的代码，体会其思路
	 */
	/*
	public boolean wordPattern(String pattern, String str)
	{
        String[] hm=new String[26];
        char[] cp=pattern.toCharArray();
        Set<String> sets=new HashSet<String>();
        String[] strp=str.split(" ");
        if(cp.length!=strp.length) 
        	return false;
        for(int i=0;i<cp.length;i++)
        {
            if(hm[cp[i]-'a']!=null)
            {
                if(!hm[cp[i]-'a'].equals(strp[i])) 
                	return false;
            }
            else
            {
                hm[cp[i]-'a'] = strp[i];
                //对于HashSet实例，当其add的那个元素存在的时候，会返回一个false
                //其集合的作用为用于记录下存在映射的str中的单词
                if(!sets.add(strp[i])) 
                	return false;
            }    
        }
        return true;
        
    }
	*/
	
}

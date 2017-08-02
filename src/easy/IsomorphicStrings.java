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
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.

No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

给定两个字符串s和t，判断其是否为同构的
两个字符串为同构的，当且仅当s中的字符能够用t中的字符进行代替
当字符串的序列保持不变的时候，所有出现的字符必须能被其它的字符所代替
并不是两个字符串必须映射成相同的字符，而是一个字符必须映射成其自身

例如:
给定"egg", "add", 返回true
给定"foo", "bar",返回false
给定"paper", "title"返回true


 */
public class IsomorphicStrings 
{
	//用于构造一个双向的映射，将s看为模式，将t看为需要进行匹配的字符串
	public boolean isIsomorphic(String s, String t) 
	{
		boolean result=true;
		//用于记录从pattern到str的映射
		Map<Character,Character> word=new HashMap<Character,Character>();
		//用于记录从str到pattern的映射
		Map<Character,Character> patterns=new HashMap<Character,Character>();
		for(int index=0;index<s.length();index++)
		{
			char sc=s.charAt(index);
			char tc=t.charAt(index);
			if(!word.containsKey(sc)&&!patterns.containsKey(tc))
			{
				patterns.put(tc,sc);
				word.put(sc, tc);
			}
			else if(word.containsKey(sc))
			{
				if(!word.get(sc).equals(tc))
				{
					result=false;
					break;
				}
			}
			else if(!word.containsKey(sc)&&patterns.containsKey(tc))
			{
				result=false;
				break;
			}
		}
		return result;
    }
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码，体会其思路
	 * 其中smap和tmap的长度均设置为256的原因是因为ascii码总共有256个字符
	 * 其思路为将s中的每一个元素和t中的每一个元素进行映射配对
	 * 将相互匹配的两个字符设置为同样的值
	 * 
	 */
	/*
	public boolean isIsomorphic(String s, String t) 
    {
        if (s.length() != t.length()) 
        	return false; 
        int[] smap = new int[256];
        int[] tmap = new int[256];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        
        
        for (int i = 0; i < cs.length; i++) 
        {
            if (smap[cs[i]] != tmap[ct[i]]) 
            	return false;
            smap[cs[i]] = tmap[ct[i]] = i+1;
        }

        
//        for (int i = 0; i < s.length(); i++) 
//        {
//            if (smap[s.charAt(i)] != tmap[t.charAt(i)]) 
//                return false;
//            smap[s.charAt(i)] = tmap[t.charAt(i)] = i+1;
//        }
        return true;
    }
        
    
    public boolean isIsomorphicHash(String s, String t) 
    {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        if(s.length() != t.length()) 
        	return false;
        for(int i = 0; i < s.length(); i++)
        {
            char sc = s.charAt(i), tc = t.charAt(i);
            if(map.containsKey(sc))
            {
                // 如果已经给s中的字符建立了映射，检查该映射是否和当前t中字符相同
                if(tc != map.get(sc))
                 	return false;
            } 
            else 
            {
                // 如果已经给t中的字符建立了映射，就返回假，因为出现了多对一映射
                if(set.contains(tc)) 
                	return false;
                map.put(sc, tc);
                set.add(tc);
            }
        }
        return true;    
    }
	*/
	
}

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
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

给定两个字符串s和t，写一个函数，判断t是不是s由颠倒字母顺序而构成的

例如:
s="anagram",t="nagaram",返回true
s="rat",t="car",返回false

提示:
你必须假设字符串只包含了小写的字母

接着:
如果输入的字符串包含了unicode字符呢？你将怎么调整你的解决方案去适应这种情况?

 */
public class ValidAnagram 
{
	public boolean isAnagram(String s, String t) 
	{
		if(s.length()!=t.length())
			return false;
		Map<Character,Integer> table=new HashMap<Character,Integer>();
		boolean result=true;
		for(int i=0;i<s.length();i++)
		{
			char key=s.charAt(i);
			if(!table.containsKey(key))
				table.put(key, 1);
			else
				table.put(key,table.get(key)+1);
		}
		for(int i=0;i<t.length();i++)
		{
			char key=t.charAt(i);
			if(!table.containsKey(key)||table.get(key)==0)
			{
				result=false;
				break;
			}
			else
			{
				table.put(key, table.get(key)-1);
			}
		}
		return result;
    }
	
	/**
	 * 
	 * leetcode上运行时间最短的代码
	 *其代码的思路为，统计s字符中26个小写字母出现的次数
	 *然后在字符串t中进行匹配以查看其是否对应其出现的次数
	 *其存在两个bug
	 *第一:当字符串特别长的时候，其int类型可能会装不下，导致其出现溢出的情况，其为隐形bug
	 *第二:当字符串中的字母不全为小写英文字母的时候，其会出现数组下标越界的情况
	 *
	 */
	
	/*
	public boolean isAnagram(String s, String t) 
	{
        if (s.length() != t.length())
         	return false;
        int[] count = new int[26];
        for (char c: s.toCharArray()) 
        	count[c - 'a']++;
        for (char c: t.toCharArray()) 
        {
            if (count[c - 'a']-- == 0) 
            	return false;
        }
        return true;
    }*/
}

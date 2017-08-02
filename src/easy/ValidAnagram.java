package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ѧͽ
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

���������ַ���s��t��дһ���������ж�t�ǲ���s�ɵߵ���ĸ˳������ɵ�

����:
s="anagram",t="nagaram",����true
s="rat",t="car",����false

��ʾ:
���������ַ���ֻ������Сд����ĸ

����:
���������ַ���������unicode�ַ��أ��㽫��ô������Ľ������ȥ��Ӧ�������?

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
	 * leetcode������ʱ����̵Ĵ���
	 *������˼·Ϊ��ͳ��s�ַ���26��Сд��ĸ���ֵĴ���
	 *Ȼ�����ַ���t�н���ƥ���Բ鿴���Ƿ��Ӧ����ֵĴ���
	 *���������bug
	 *��һ:���ַ����ر𳤵�ʱ����int���Ϳ��ܻ�װ���£����������������������Ϊ����bug
	 *�ڶ�:���ַ����е���ĸ��ȫΪСдӢ����ĸ��ʱ�������������±�Խ������
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

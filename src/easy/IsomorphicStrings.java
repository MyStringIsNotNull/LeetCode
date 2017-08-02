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

���������ַ���s��t���ж����Ƿ�Ϊͬ����
�����ַ���Ϊͬ���ģ����ҽ���s�е��ַ��ܹ���t�е��ַ����д���
���ַ��������б��ֲ����ʱ�����г��ֵ��ַ������ܱ��������ַ�������
�����������ַ�������ӳ�����ͬ���ַ�������һ���ַ�����ӳ���������

����:
����"egg", "add", ����true
����"foo", "bar",����false
����"paper", "title"����true


 */
public class IsomorphicStrings 
{
	//���ڹ���һ��˫���ӳ�䣬��s��Ϊģʽ����t��Ϊ��Ҫ����ƥ����ַ���
	public boolean isIsomorphic(String s, String t) 
	{
		boolean result=true;
		//���ڼ�¼��pattern��str��ӳ��
		Map<Character,Character> word=new HashMap<Character,Character>();
		//���ڼ�¼��str��pattern��ӳ��
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
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ��룬�����˼·
	 * ����smap��tmap�ĳ��Ⱦ�����Ϊ256��ԭ������Ϊascii���ܹ���256���ַ�
	 * ��˼·Ϊ��s�е�ÿһ��Ԫ�غ�t�е�ÿһ��Ԫ�ؽ���ӳ�����
	 * ���໥ƥ��������ַ�����Ϊͬ����ֵ
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
                // ����Ѿ���s�е��ַ�������ӳ�䣬����ӳ���Ƿ�͵�ǰt���ַ���ͬ
                if(tc != map.get(sc))
                 	return false;
            } 
            else 
            {
                // ����Ѿ���t�е��ַ�������ӳ�䣬�ͷ��ؼ٣���Ϊ�����˶��һӳ��
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

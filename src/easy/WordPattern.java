package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author ѧͽ
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

����һ��ģʽ��һ���ַ���str���������Ƿ����Ӧ��ģʽƥ��
����ζ��ȫƥ�䣬���ڲ�Ϊ�յ��ַ���str��ģʽ�У���Ϊһ��˫���(�������ֵ���)

����:
pattern = "abba", str = "dog cat cat dog" ���뷵��true.
pattern = "abba", str = "dog cat cat fish" ���뷵�� false.
pattern = "aaaa", str = "dog cat cat dog" ���뷵�� false.
pattern = "abba", str = "dog dog dog dog" ���뷵�� false.

��ʾ:
��������ģʽ�ַ�ֻ����Сд��ĸ����strҲֻ����Сд��ĸ����str�еĸ��������ɿո���зָ�

*/
 
public class WordPattern 
{
	public boolean wordPattern(String pattern, String str) 
	{
		boolean result=true;
		//���ڼ�¼��pattern��str��ӳ��
		Map<Character,String> word=new HashMap<Character,String>();
		//���ڼ�¼��str��pattern��ӳ��
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
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·Ϊ����ģʽ���еģ����ֻ��Ϊ26����ĸ���ص㣬��ÿһ����ĸӳ�䵽��ÿһ������
	 * ֮��ÿһ�����ֺ�str�е�ÿһ�����ʽ���ӳ��,���䲻�õĵط�������ֻ��Ϊ����֮��ģ�������
	 * ��26��Сд��ĸ֮��ģ������ִ�������
	 * �Ƽ��Ķ��Ĵ��룬�����˼·
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
                //����HashSetʵ��������add���Ǹ�Ԫ�ش��ڵ�ʱ�򣬻᷵��һ��false
                //�伯�ϵ�����Ϊ���ڼ�¼�´���ӳ���str�еĵ���
                if(!sets.add(strp[i])) 
                	return false;
            }    
        }
        return true;
        
    }
	*/
	
}

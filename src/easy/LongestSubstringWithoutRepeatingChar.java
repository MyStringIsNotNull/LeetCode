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
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

����һ���ַ������ҵ���û���ظ����ַ�����Ӵ��ĳ���

����:
����"abcabcbb" ��Ϊ"abc"���䳤��Ϊ3

����"bbbb"����Ϊ"b",�䳤��Ϊ1

����"pwwkew"����Ϊ"wke",�䳤��Ϊ3��ע�⣬��𰸱���Ϊ�Ӵ���"pwke"��һ�����У���������һ���Ӵ�

 */
public class LongestSubstringWithoutRepeatingChar
{
	/**
	 * ���㷨��leetcode������ʱ��ʱ�䳬��
	 * Ϊ�ˣ�����������㷨
	 * 
	 */
	/*
	public int lengthOfLongestSubstring(String s) 
	{
		//���ڼ�¼������Ӵ��ĳ���
        int length=0;
        if(s==null||s.length()==0)
        	return length;
        int spare=0;
        Map<Character,Integer> set=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
        	char c=s.charAt(i);
        	//�������ظ����ַ���ʱ
        	if(set.get(c)!=null)
        	{
        		if(spare>length)
        			length=spare;
        		spare=1;
        		i=set.get(c)+1;
        		set.clear();
        		set.put(s.charAt(i),i);
       		}
        	//��û���ظ����ַ������ֵ�ʱ��
        	else
        	{
        		spare++;
        		set.put(c,i);
        	}
        }
        if(spare>length)
        	length=spare;
        return length;
    }*/
	
	
	public int lengthOfLongestSubstring(String s) 
	{
		int ans=0, start=0, end =0;
		Map<Character,Integer> countDic=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			end += 1;
			if(countDic.get(c)==null)
				countDic.put(c,1);
			else
				countDic.put(c,countDic.get(c)+1);
			//ͨ�������ķ�ʽ��ȥ�ƽ��ظ����ֵ��ַ�����������ѭ����ʱ��start�պ�ָ���ظ��ַ�����һ��
		    while(countDic.get(c)==2)
		    {
		       countDic.put(s.charAt(start),countDic.get(s.charAt(start))-1);     
	           start += 1;
		    }
		    //���䳤�������˵�ʱ������£����򲻽��и���(end-start��ʾ���ǵ�ǰû�г����ظ��ַ����ַ����ĳ���)
		    ans = Math.max(ans, end - start);
		}
		return ans;
	}
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·ͬ�ϵĴ��룬ֻ�������Ϊ֮���
	 * 
	 * 
	 */
	/*
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null)
		{
			return 0;
		}
		int start = 0;
		int result = 0;
		//���ڼ�¼�ַ��Ƿ���ֹ�����Ϊtrueʱ��ʾ���ֹ������򣬱�ʾδ���ֹ�
		boolean[] flag = new boolean[256];
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++)
		{
			char c = arr[i];
			//���ַ����ֹ�ʱ
			if (flag[c])
			{
				result = Math.max(result, i - start);
				//��Ŀ�������ҵ��ظ����ַ�����һ���ַ������꣬�����䱣����start�У�ͬʱ������ǰһ��startֵ��ʼ���ַ�
				//���ظ��ַ���ǰ��������ַ�(������û�а������δ�ظ��ַ��Ӵ��ڵ������ַ���flagֵ����Ϊfalse����ʾû�г��ֹ�)
				for (int k = start; k < i; k++)
				{
					if (arr[k] == c)
					{
						start = k + 1;
						break;
					}
					flag[arr[k]] = false;
				}
			}
			//���ַ���û�г��ֹ�ʱ�������־Ϊ�ѳ���
			else
			{
				flag[c] = true;
			}
		}

		return Math.max(result, arr.length - start);
	}*/
	
	/**
	 * leetcode�ϵĴ˷ݴ���˼·ͬ������
	 */
	/*
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null || s.length() == 0)
			return 0;
		int maxLen = 0, startIdx = 0;
		int[] idxRecord = new int[255];
		//������������idxRecord������Ԫ��ֵȫ��Ϊ-1
		Arrays.fill(idxRecord, -1);
		for (int i = 0; i < s.length(); i++)
		{
			//������ָ����������ʱ��֤���ַ�s.charAt(i)��������startIdx����ǰi���ڵ��ַ�����
			if (idxRecord[s.charAt(i)] >= startIdx)
			{
				maxLen = Math.max(maxLen, i - startIdx);
				startIdx = idxRecord[s.charAt(i)] + 1;
			}
			//��Ŀ�����ڱ�ʶ���ַ�������s.charAt(i)��������startIdx����ǰi���ڵ��ַ�����
			idxRecord[s.charAt(i)] = i;
		}
		maxLen = Math.max(maxLen, s.length() - startIdx);
		return maxLen;
	}*/
	
	
}

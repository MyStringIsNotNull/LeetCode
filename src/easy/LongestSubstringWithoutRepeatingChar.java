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
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

给定一个字符串，找到其没有重复的字符的最长子串的长度

例如:
给定"abcabcbb" 答案为"abc"，其长度为3

给定"bbbb"，答案为"b",其长度为1

给定"pwwkew"，答案为"wke",其长度为3，注意，其答案必须为子串，"pwke"是一个序列，而并非是一个子串

 */
public class LongestSubstringWithoutRepeatingChar
{
	/**
	 * 该算法在leetcode上运行时，时间超过
	 * 为此，考虑下面的算法
	 * 
	 */
	/*
	public int lengthOfLongestSubstring(String s) 
	{
		//用于记录下最长的子串的长度
        int length=0;
        if(s==null||s.length()==0)
        	return length;
        int spare=0;
        Map<Character,Integer> set=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
        	char c=s.charAt(i);
        	//当出现重复的字符串时
        	if(set.get(c)!=null)
        	{
        		if(spare>length)
        			length=spare;
        		spare=1;
        		i=set.get(c)+1;
        		set.clear();
        		set.put(s.charAt(i),i);
       		}
        	//当没有重复的字符串出现的时候
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
			//通过这样的方式，去逼近重复出现的字符，当其跳出循环的时候，start刚好指向重复字符的下一个
		    while(countDic.get(c)==2)
		    {
		       countDic.put(s.charAt(start),countDic.get(s.charAt(start))-1);     
	           start += 1;
		    }
		    //当其长度扩大了的时候，则更新，否则不进行更新(end-start表示的是当前没有出现重复字符的字符串的长度)
		    ans = Math.max(ans, end - start);
		}
		return ans;
	}
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路同上的代码，只不过其更为之简便
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
		//用于记录字符是否出现过，当为true时表示出现过，否则，表示未出现过
		boolean[] flag = new boolean[256];
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++)
		{
			char c = arr[i];
			//当字符出现过时
			if (flag[c])
			{
				result = Math.max(result, i - start);
				//其目的在于找到重复的字符的下一个字符的坐标，并将其保存在start中，同时，将从前一个start值开始的字符
				//到重复字符的前面的所有字符(即所有没有包含在最长未重复字符子串内的所有字符的flag值设置为false，表示没有出现过)
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
			//当字符并没有出现过时，将其标志为已出现
			else
			{
				flag[c] = true;
			}
		}

		return Math.max(result, arr.length - start);
	}*/
	
	/**
	 * leetcode上的此份代码思路同样清晰
	 */
	/*
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null || s.length() == 0)
			return 0;
		int maxLen = 0, startIdx = 0;
		int[] idxRecord = new int[255];
		//用于设置数组idxRecord的数组元素值全部为-1
		Arrays.fill(idxRecord, -1);
		for (int i = 0; i < s.length(); i++)
		{
			//当其出现该情况成立的时候，证明字符s.charAt(i)包含在了startIdx到当前i所在的字符串中
			if (idxRecord[s.charAt(i)] >= startIdx)
			{
				maxLen = Math.max(maxLen, i - startIdx);
				startIdx = idxRecord[s.charAt(i)] + 1;
			}
			//其目的在于标识其字符包含在s.charAt(i)包含在了startIdx到当前i所在的字符串中
			idxRecord[s.charAt(i)] = i;
		}
		maxLen = Math.max(maxLen, s.length() - startIdx);
		return maxLen;
	}*/
	
	
}

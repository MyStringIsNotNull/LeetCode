package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 
 Write a function to find the longest common prefix string amongst an array of strings. 
 
 写一个函数在字符串数组中寻找最大的公共前缀字符串
 *
 */
public class FindPrefixString 
{
	public String longestCommonPrefix(String[] strs) 
	{
		String result="";
		if(strs.length>=1)
		{
			result=strs[0];
			for(int i=1;i<strs.length;i++)
			{
				int index=result.length()>strs[i].length()?strs[i].length():result.length();
				String temp="";
				for(int tem=0;tem<index;tem++)
				{
					char resultc=result.charAt(tem);
					char strsc=strs[i].charAt(tem);
					if(resultc==strsc)
					{
						temp+=resultc;
					}
					else
						break;
				}
				result=temp;
			}
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最小的
	 */
	/*public String longestCommonPrefix(String[] strs) 
	{
        if(strs == null || strs.length == 0) 
        	return "";
        String pre = strs[0]; // the longest prefix cannot be longer than any element in the string array
        int i = 1;
        while(i < strs.length)
        {
            while(strs[i].indexOf(pre) != 0)
                // if current pre is not the prefix of current string, cut the pre one char shorter each time to find the correct matching pre - longest common prefix cannot be longer than any prefix of strings in the array
                pre = pre.substring(0, pre.length() - 1);//相当于每次删除去末尾一个元素
            i++;
        }
        return pre;
    }*/
}

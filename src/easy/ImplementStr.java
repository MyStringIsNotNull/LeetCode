package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * 
question:
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 

实现strStr()方法
返回needle这个字符串第一次出现在haystack字符串的索引位置，当needle不存在haystack中的时候，返回-1
 */
public class ImplementStr 
{
	/*
	 * 此处实现暴力查找的办法，实际上，应该实现KMP算法进行字符串的匹配会更加快
	 */
	public int strStr(String haystack, String needle) 
	{
		int result=-1;
		if(needle.length()<=haystack.length())
		{
			//需要进行查找的字符串，对其每一个字符进行迭代
			for(int i=0;i<haystack.length()-needle.length()+1;i++)
			{
				int needleLength=0;
				while(needleLength<needle.length())
				{
					char hayc=haystack.charAt(i+needleLength);
					char needlec=needle.charAt(needleLength);
					if(hayc==needlec)
						needleLength++;
					else
						break;
				}
				if(needleLength==needle.length())
				{
					result=i;
					break;
				}
			}
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最小的是直接使用String对象的indexOf()方法的，故选择运行时间第二小的作为参考
	 */
	/*
	 * 
	 public int strStr(String haystack, String needle) 
	 {
        int l1 = haystack.length(),l2= needle.length();
        if(l1<l2)
            return -1;
        else if(l2==0)
            return 0;
        int offset = l1 -l2;
        for(int i=0;i<=offset;i++)
        {
            if(haystack.substring(i,i+l2).equals(needle))//此处为实现的关键
                return i;
        }
        return -1;
            
     }
	 */
}

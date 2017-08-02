package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a strings consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5. 

给定一个由大/小写和空格组成的字符串，返回字符串中最后一个单词的长度

如果最后一个单词不存在，则返回0

一个单词被定义为仅由非空格组成字符序列
 */
public class LengthOfLastWord 
{
	public int lengthOfLastWord(String s) 
	{
		int lastSpace=s.lastIndexOf(" ");
		//当查找到的最后一个空格在的字符串的末尾的时候
		//这段代码的目的是去掉末尾的空格
		while(s.length()>0&&lastSpace==s.length()-1)
		{
			s=s.substring(0, lastSpace);
			lastSpace=s.lastIndexOf(" ");
		}
		System.out.println(s);
		return length(s);
    }
	/**
	 * 用于将字符串传入，计算出其最后一个单词的长度
	 * @param s 最后一个单词后面没有空格的字符串
	 * @return 最后一个单词的长度
	 */
	private int length(String s)
	{
		int result=0;
		//获取最后一个空格的位置
		int lastSpace=s.lastIndexOf(" ");
        result=s.length()-1-lastSpace;
        return result;
	}
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 对于这代码，推荐阅读
	 */
	/*
	public int lengthOfLastWord(String s) 
	{
	       int len=s.length()-1;
	       //用于记录下长度
	        int res=0;
	        while(len>=0&&s.charAt(len)==' ')
	        	len--;
	        while(len>=0&&s.charAt(len)!=' ')
	        {
	        	len--;
	        	res++;
	        }
	         return res;
	}*/
	
}

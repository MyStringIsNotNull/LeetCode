package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 

与Excel Sheet Column Title这个问题相关联
给定出现在Excel中的一列的标题，返回其对应列的数字

例如:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 

 */
public class ExcelSheetNumber 
{
	/**
	 * 该题的本质为将26进制转化为10进制
	 */
	public int titleToNumber(String s) 
	{
		int result=0;
		for(int i=s.length()-1;i>=0;i--)
		{
			int number=s.charAt(i)-'A'+1;
			result+=number*Math.pow(26,s.length()-1-i);
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码，主要学习的思想在于for循环里面的那个语句
	 */
	/*
	public int titleToNumber(String s) 
	{
        if(s==null || s.length()==0) 
        	return 0;
        char[] chs = s.toCharArray();
        int res = 0;
        for(int i=0; i<chs.length; i++)
        {
            res = res*26 + chs[i]-'A'+ 1;
        }
        return res;
    }
	*/
}

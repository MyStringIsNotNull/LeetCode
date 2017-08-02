package easy;
/**
 * 
 * @author ѧͽ
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

��Excel Sheet Column Title������������
����������Excel�е�һ�еı��⣬�������Ӧ�е�����

����:
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
	 * ����ı���Ϊ��26����ת��Ϊ10����
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
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ��룬��Ҫѧϰ��˼������forѭ��������Ǹ����
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

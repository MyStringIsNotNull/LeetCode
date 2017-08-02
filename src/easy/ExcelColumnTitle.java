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
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 

����һ������������������excel����Ӧ�еı���

����:
1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 

 */

public class ExcelColumnTitle 
{
	/**
	 * ����ı���Ϊ��10����ת��Ϊ26���ƣ�����ƫ����Ϊ1
	 */
	public String convertToTitle(int n) 
	{
		//����һ��ӳ���
		Map<Integer,String> table=new HashMap<Integer,String>();
		for(int i=0;i<26;i++)
		{
			table.put(i, String.valueOf((char)('A'+i)));
		}
		String result="";
		while(n!=0)
		{
			result=table.get((n-1)%26)+result;
			n=(n-1)/26;
		}
		return result;
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * 
	 */
	
    public String convertToTitle1(int n) 
    {  
        String result = "";  
        while(n>0)
        {  
            result = (char)((n-1)%26 +'A')+result;  
            n = (n-1)/26;  
        }  
        return result;  
    }  
	
}

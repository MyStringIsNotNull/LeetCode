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
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 

给定一个正整数，返回其在excel中相应列的标题

例如:
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
	 * 该题的本质为将10进制转化为26进制，其中偏移量为1
	 */
	public String convertToTitle(int n) 
	{
		//创建一个映射表
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
	 * leetcode上运行时间最短的代码
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

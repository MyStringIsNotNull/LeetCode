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
 Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". 

给定两个二进制的字符串，返回他们的和(同样以二进制字符串的形式返回)
例如:
a="11"
b="1"
返回 "100"

 */
public class AddBinary 
{
	public String addBinary(String a, String b) 
	{
		//用于构造一个全加器的表格,数字1和0表示其本位和，进位为0，数字2表示有本位和为0，进位为1，数字3表示本位和为1，进位为1
		Map<String,Integer> table=new HashMap<String,Integer>();
		table.put("000", 0);
		table.put("001", 1);
		table.put("010", 1);
		table.put("011", 2);
		table.put("100", 1);
		table.put("101", 2);
		table.put("110", 2);
		table.put("111", 3);
		String result="";	//对于字符串，记得此处不能用null，因为当像result+="2"的运算出现的时候，其得到的结果是result=="null2",而不是"2"
		//低位向高位的进位
		String carryFlag="0";
		int indexA=a.length()-1;
		int indexB=b.length()-1;
		if(indexA==-1)
			return b;
		else if(indexB==-1)
			return a;
		else
		{
			while(indexA>=0&&indexB>=0)
			{
				int sum=table.get(String.valueOf(a.charAt(indexA))+String.valueOf(b.charAt(indexB))+carryFlag);
				if(sum==2)
				{
					carryFlag="1";
					result="0"+result;
				}
				else if(sum==3)
				{
					carryFlag="1";
					result="1"+result;
				}
				else
				{
					carryFlag="0";
					result=String.valueOf(sum)+result;
				}
				indexA--;
				indexB--;
			}
			while(indexA>=0)
			{
				int sum=table.get(String.valueOf(a.charAt(indexA))+"0"+carryFlag);
				if(sum==2)
				{
					carryFlag="1";
					result="0"+result;
				}
				else
				{
					carryFlag="0";
					result=String.valueOf(sum)+result;
				}
				indexA--;
			}
			while(indexB>=0)
			{
				int sum=table.get(String.valueOf(b.charAt(indexB))+"0"+carryFlag);
				if(sum==2)
				{
					carryFlag="1";
					result="0"+result;
				}
				else
				{
					carryFlag="0";
					result=String.valueOf(sum)+result;
				}
				indexB--;
			}
			if(carryFlag.equals("1"))
				result="1"+result;
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最少的代码
	 * 其思路同上，只是代码的操作上更加简洁
	 */
	/*public String addBinary(String a, String b)
	{
    	int la = a.length();
        int lb = b.length();
        if(la == 0 && lb == 0) 
        	return "0";
        else if(la == 0) 
        	return b;
        else if(lb == 0) 
        	return a;
        
        char[] chs = new char[Math.max(la, lb)+1];
        int ptra = la-1;
        int ptrb = lb-1;
        int widx = chs.length-1;
        int carry = 0;
     
        while(ptra>=0 || ptrb>=0) 
        {
     		int va = 0;
            int vb = 0;
            if(ptra >= 0) 
            {
                va = a.charAt(ptra--)-'0';
            }
            
            if(ptrb >= 0) 
            {
                vb = b.charAt(ptrb--)-'0';
            }
            
            int sum = va+vb+carry;
            if(sum > 1)
            {
                chs[widx] = (char)(sum-2+'0');
                carry = 1;
            }
            else 
            {
                chs[widx] = (char)(sum+'0');
                carry = 0;
            }
            widx--;
        }
        
        if(carry == 1) 
        {
            chs[0] = '1';
            return new String(chs);
        }
        else 
        {
            return new String(chs, 1, chs.length-1);
        }
    }*/
}

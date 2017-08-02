package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * 
question:
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.


����һ���Ǹ���������һ���ǿյ���������չʾ,���ҽ������������������ʾ��ֵ���м�һ
��������������ǰ�治�����κ�0������0����
���������ź���ģ�������������������б��ǰ���


 */
public class PlusOne 
{
	public int[] plusOne(int[] digits) 
	{
		Stack<Integer> s=new Stack<Integer>();
		int[] result=null;
		int divid=0;
		digits[digits.length-1]++;
		if(digits[digits.length-1]>=10)
		{
			divid=digits[digits.length-1]/10;
		}
        s.push(digits[digits.length-1]%10);
		for(int i=digits.length-2;i>=0;i--)
		{
			if(divid!=0)
			{
				digits[i]=digits[i]+divid;
				if(digits[i]>=10)
					divid=digits[i]/10;
				else
					divid=0;
			}
			s.push(digits[i]%10);
		}
		if(divid!=0)
			s.push(divid);
		result=new int[s.size()];
		for(int i=0;i<result.length;i++)
		{
			result[i]=s.pop();
		}
		return result;
    }
	
	
	
	/**
	 * 
	 * leetcode������ʱ����̵Ĵ���
	 *�Ƽ��Ķ��Ĵ���
	 */
	/*
	 public int[] plusOne(int[] digits) 
	{
        int i=digits.length-1;
        while(i>=0 && digits[i]==9)
        {
            digits[i]=0;
            i--;
        }
        if(i<0) 
        {
        	int[] ans=new int[len+1];
            ans[0]=1;
            //System.arraycopy(digits,0,ans,1,len);
            return ans;
        }
        else 
        {
            digits[i]++;
        	return digits;    
        }	
    }*/
	
	
}

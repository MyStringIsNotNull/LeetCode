package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

�����������ַ�����ʽ��ʾ�ķǸ�����num1��num2������num1��num2�ĳ˻�

ע��:
num1��num2�ĳ��Ⱦ�С��110
num1��num2��ֻ������0-9��Щ����
num1��num2���������κ�ǰ�õ�0
����벻��ȥʹ���κδ���������߽�������ַ�ֱ��ת���������Ŀ�

 */
public class MultiplyString
{
	public String multiply(String num1, String num2) 
	{
		if(num1.equals("0")||num2.equals("0"))
            return "0";
		if(num1.length()<num2.length())
		{
			String num=num2;
			num2=num1;
			num1=num;
		}
		String result="";
		StringBuilder zero=new StringBuilder("0");
		for(int i=num2.length()-1;i>=0;i--,zero.append("0"))
		{
			int c=num2.charAt(i)-'0';
			String temp=multiply(num1,c)+zero.toString();
			result=addStrings(temp,result);
		}
		return result;
    }
	private String multiply(String num1,int c)
	{
		int carry=0;
		StringBuilder result=new StringBuilder();
		for(int i=num1.length()-1;i>=0;i--)
		{
			int n=num1.charAt(i)-'0';
			int multiply=n*c+carry;
			result.append(multiply%10);
			carry=multiply/10;
		}
		if(carry>0)
			result.append(carry);
		return result.reverse().toString();
	}
	
	private String addStrings(String num1, String num2)
	{
		// make sure num1 is longer if numbers are not of same length
		if (num2.length() > num1.length())
		{
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}

		// result will be of the longer number's length or +1 digit
		int num1Length = num1.length();
		char[] resultDigits = new char[num1Length + 1];

		// copy value of num1 to result
		resultDigits[0] = '0';
		num1.getChars(0, num1Length, resultDigits, 1);

		// add num2 digits
		int remainder = 0;
		int resultPos = num1Length;
		for (int num2Pos = num2.length() - 1; num2Pos >= 0 || remainder > 0; num2Pos--, resultPos--)
		{
			int num2Digit = num2Pos < 0 ? 0 : num2.charAt(num2Pos) - 48;
			resultDigits[resultPos] += num2Digit + remainder;
			if (resultDigits[resultPos] < 58)
			{
				remainder = 0;
				continue;
			}
			remainder = 1;
			resultDigits[resultPos] -= 10;
		}
		//�䷵�ص��ַ����У�1-result[0]%16��num1Length+result[0]%16��result[0]%16��Ŀ������
		//������λΪ1ʱ����������(�ַ�'1'��ascii��Ϊ49����%16֮���Ϊ1,)����Ϊ'0'ʱȥ����ǰ��0
		//ps:����������ӣ����λ���Ϊ1
		return String.valueOf(resultDigits, 1 - resultDigits[0] % 16,num1Length + resultDigits[0] % 16);
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·:�μ�����http://blog.csdn.net/qq_14821023/article/details/50822207
	 * ���ճ���ⷨ�����ַ���������ģ��˷��Ĳ��������ʵ���ַ����߾��ȼӷ����ٽ��ӷ����õ��˷������С�
	 * ���ַ����򵥵��Ǻ�ʱ�Ƚϴ��������һ�ֱȽ�����ķ��������LeetCode�ϵ�һ�ݸ�Ʊ���롣 
	 *
	 * index1:			|  |,|  |,|1|,|2|,|3|	index i
	 * index0:			|  |,|  |,|  |,|4|,|5|	index j
	 * 						----------------------------
	 * 			    		|  |,|  |,|  |,|1|,|5|
	 * 			    		|  |,|  |,|1|,|0|,|  |
	 * 			    		|  |,|0|,|5|,|  |,|  |
	 * 			    		|  |,|  |,|1|,|2|,|  |
	 *indices[1,2]	|  |,|0|,|8|,|  |,|  |	indices[i+j,i+j+1]
	 * 			    		|0|,|4|,|  |,|  |,|  |
	 * index:   		|0|,|1|,|2|,|3|,|4|
	 * �ۿ���ͼ���������������Ǽ���˷��Ĺ��̡���ϸ�������Է��֣�
	 * ����ԭ���������ַ������±�Ϊ1�ġ�2�����������ַ������±�Ϊ0�ġ�4������˽��08��������
	 * ���ĳ˷�����ַ������±�1��2������һ����������±������ͬ���������±�i���±�j��˵ĸ�λ���λ���±�i+j����
	 * ��λλ���±�i+j+1����������������ʵ�ָ߾��ȵĳ˷��ͱ�ü��ˡ�
	 * 
	 * 
	 * 
	 */
	/*
	public String multiply(String num1, String num2)
	{
		int m = num1.length(), n = num2.length(), zero = 0;
		int[] a = new int[m], c = new int[m + n];
		for (int i = 0, k = m; i < m; i++)
			a[--k] = num1.charAt(i) - '0'; // reverse the first number
		for (int i = n - 1; i >= 0; i--)
			add(c, a, num2.charAt(i) - '0', zero++); // multiply each digits of
														// num2 to num1
		carry(c); // handle all carry operation together
		int i = m + n;
		while (i > 0 && c[--i] == 0)
			; // find the highest digit
		i++;
		StringBuilder ret = new StringBuilder(i);
		while (i > 0)
			ret.append((char) (c[--i] + '0'));
		return ret.toString();
	}

	void carry(int[] a)
	{
		int i;
		for (int k = 0, d = 0; k < a.length; k++)
		{
			i = a[k] + d;
			a[k] = i % 10;
			d = i / 10;
		}
	}

	void add(int[] c, int[] a, int b, int zero)
	{
		for (int i = zero, j = 0; j < a.length; j++, i++)
			c[i] += a[j] * b;
	}*/
	
	
}

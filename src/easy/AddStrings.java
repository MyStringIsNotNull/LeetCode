package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

给定两个用字符串形式表示的非负的整数num1和num2，返回num1和num2的和

注意:
num1和num2的长度均小于5100
num1和num2均只包含了0-9这些数字
num1和num2均不包含任何前置0
你不能使用任何内置的大整数库或者直接把数字(字符形式)转换成整数



 */
public class AddStrings
{
	public String addStrings(String num1, String num2) 
	{
		//用于记录进位
		int carry=0;
		String result="";
		char[] s1=num1.toCharArray();
		char[] s2=num2.toCharArray();
		int lengthString1=s1.length;
		int lengthString2=s2.length;
		int index=Math.min(lengthString1, lengthString2);
		int count=index;
		for(int i1=lengthString1-1,i2=lengthString2-1;count>0;count--,i1--,i2--)
		{
			int n1=s1[i1]-'0';
			int n2=s2[i2]-'0';
			int add=n1+n2+carry;
			result=add%10+result;
			carry=add/10;
		}
		count=Math.max(lengthString2, lengthString1);
		char[] max=count==lengthString2?s2:s1;
		index=count-index-1;
		for(;index>=0;index--)
		{
			int num=max[index]-'0';
			int add=num+carry;
			result=add%10+result;
			carry=add/10;
		}
		if(carry>0)
			result=carry+result;
		return result;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 */
	/*
	public String addStrings(String num1, String num2)
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
		//其返回的字符串中，1-result[0]%16和num1Length+result[0]%16中result[0]%16的目的在于
		//如果最高位为1时，保留下来(字符'1'的ascii码为49，在%16之后变为1,)当其为'0'时去掉该前置0
		//ps:两个数字相加，其进位最多为1
		return String.valueOf(resultDigits, 1 - resultDigits[0] % 16,num1Length + resultDigits[0] % 16);
	}*/
	
}

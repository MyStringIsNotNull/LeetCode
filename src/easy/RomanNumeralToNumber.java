package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 学徒
 *
 */
/*
 * 
question: 
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

给定一个罗马字符串，将其转化为整数
输入的是在1-3999之间的数字

罗马数字规则如下：
罗马数字是阿拉伯数字传入之前使用的一种数码。罗马数字采用七个罗马字母作数字、
即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）、 M（1000）。记数的方法：

相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
在一个数的上面画一条横线，表示这个数增值 1,000 倍
 *
 */
public class RomanNumeralToNumber 
{
	public static void main(String[] args)
	{
		RomanNumeralToNumber n=new RomanNumeralToNumber();
		System.out.println(n.romanToInt("MMCCCVII"));
	}
	
	public int romanToInt(String s) 
    {
		//构建一张查询表
		Map<Character,Integer> table=new HashMap<Character,Integer>();
		table.put('I', 1);
		table.put('V', 5);
		table.put('X', 10);
		table.put('L', 50);
		table.put('C', 100);
		table.put('D',500);
		table.put('M',1000);
		int result=0;
		int index=0;
		int maxIndex=s.length()-1;
		while(index<=maxIndex)
		{
			char c=s.charAt(index);
			int get=table.get(c);
			switch(c)
			{
				case 'I':
						if(index+1<=maxIndex)
						{
							get=-get;
							if(s.charAt(index+1)=='I')
								get=-1*get;//负数变为整数，不能写为get=+get,这样的做法并没有用，所以，只能使用Math.abs()或者乘上个-1的方法实现
						}
						result+=get;
						break;
				case 'X':
					if(index+1<=maxIndex)
					{
						switch(s.charAt(index+1))
						{
							case 'L':
							case 'C':
							case 'D':
							case 'M':
									get=-get;
						}
					}
					result+=get;
					break;
				case 'C':
					if(index+1<=maxIndex)
					{
						switch(s.charAt(index+1))
						{
							case 'D':
							case 'M':
									get=-get;
						}
					}
					result+=get;
					break;
				default:
					result+=get;
			}
			index++;
		}
		return result;
    }
}

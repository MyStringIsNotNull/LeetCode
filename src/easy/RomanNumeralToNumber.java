package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * 
question: 
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

����һ�������ַ���������ת��Ϊ����
���������1-3999֮�������

�������ֹ������£�
���������ǰ��������ִ���֮ǰʹ�õ�һ�����롣�������ֲ����߸�������ĸ�����֡�
��I��1����V��5����X��10����L��50����C��100����D��500���� M��1000���������ķ�����

��ͬ��������д������ʾ����������Щ������ӵõ��������� ��=3��
С�������ڴ�����ֵ��ұߣ�����ʾ����������Щ������ӵõ��������� ��=8����=12��
С�����֣����� ��X �� C���ڴ�����ֵ���ߣ�����ʾ�������ڴ�����С���õ��������� ��=4����=9��
��һ���������滭һ�����ߣ���ʾ�������ֵ 1,000 ��
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
		//����һ�Ų�ѯ��
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
								get=-1*get;//������Ϊ����������дΪget=+get,������������û���ã����ԣ�ֻ��ʹ��Math.abs()���߳��ϸ�-1�ķ���ʵ��
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

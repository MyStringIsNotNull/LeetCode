package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. 

判断给定的字符串是否为数字

一些例子:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

注意:
问题的描述故意做得模糊不清，在实现之前你必须收集所有所需的情况


 */
/**
 *
这道题的判定种类很多
用有限状态机，非常简洁，不需要复杂的各种判断！
先枚举一下各种合法的输入情况：
1.空格+ 数字 +空格
2.空格+ 点 + 数字 +空格
3.空格+ 符号 + 数字 +　空格
4.空格 + 符号 + 点 +　数字　＋空格
5.空格 + (1, 2, 3, 4） + e +　(1, 2, 3, 4) +空格
ps:合法的输入可能5中的(1,2,3,4)代表的是合法的输入情况1-4
组后合法的字符可以是：
1.数字
2.空格
ps:有限状态机中，其难点在于构造各种可能的输入状态

有限状态机中的各种可能的输入状态如下:
0 初始无输入或者只有space的状态
1 输入了数字之后的状态
2 前面无数字，只输入了dot的状态
3 输入了+/-状态
4 前面有数字和有dot的状态
5 'e' or 'E'输入后的状态
6 输入e之后输入+/-的状态
7 输入e后输入数字的状态
8 前面有有效数输入之后，输入space的状态

有限状态机的状态转移过程：
起始为0：
　　当输入空格时，状态仍为0，

　　输入为符号时，状态转为3，3的转换和0是一样的，除了不能再接受符号，故在0的状态的基础上，把接受符号置为-1；

　　当输入为数字时，状态转为1, 状态1的转换在于无法再接受符号，可以接受空格，数字，点，指数；状态1为合法的结束状态；

　　当输入为点时，状态转为2，状态2必须再接受数字，接受其他均为非法；

　　当输入为指数时，非法；

状态1：
　　接受数字时仍转为状态1，

　　接受点时，转为状态4，可以接受空格，数字，指数，状态4为合法的结束状态，

　　接受指数时，转为状态5，可以接受符号，数字，不能再接受点，因为指数必须为整数，而且必须再接受数字；

状态2：
　　接受数字转为状态4；

状态3：
　　和0一样，只是不能接受符号；

状态4：
　　接受空格，合法接受；

　　接受数字，仍为状态4；

　　接受指数，转为状态5，

状态5：
　　接受符号，转为状态6，状态6和状态5一样，只是不能再接受符号，

　　接受数字，转为状态7，状态7只能接受空格或数字；状态7为合法的结束状态；

状态6：
　　只能接受数字，转为状态7；

状态7：
　　接受空格，转为状态8，状态7为合法的结束状态；

　　接受数字，仍为状态7；

状态8：
　　接受空格，转为状态8，状态8为合法的结束状态； 

详情请参看图片ValidNumber.jpg
图片来源:https://zhuanlan.zhihu.com/p/20042325?columnSlug=simons

 *
 */

public class ValidNumber
{
	//此题判断类型太多，为此，采用了别人的分析以此写出代码
	public boolean isNumber(String s)
	{
		//去掉首尾空格，其对是否为数字的判断没有影响
		s=s.trim();
        if(s==null||s.length()==0)
            return false;
        int i = 0;
		// 处理正负号
		if ('+' == s.charAt(i) || '-' == s.charAt(i))
			i++;
		// 处理后面数字部分
		//用于标识是否出现过(数字，点，指数)
		boolean digit = false, dot = false, exp = false;
		for (; i < s.length(); i++)
		{
			// '.'不能出现2次，'.'前面能够没有数字
			if ('.' == s.charAt(i) && !dot) 
				dot = true;
			// 'e'不能出现2次，'e'前面必须有数字
			else if ('e' == s.charAt(i) && !exp && digit) 
			{
				// 'e'后面不能出现'.'，'e'后面必须是整数（能够是正的或负的）
				dot = exp = true;
				if (i + 1 < s.length()&& ('+' == s.charAt(i + 1) || '-' == s.charAt(i + 1)))
					++i;
				if (i + 1 >= s.length()|| !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))
					return false;
			}
			else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				digit = true;
			else
				break;
		}
		return digit && i == s.length();
	}
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读，其代码的思路同上
	 */
	/*
	 public boolean isNumber(String s)
	{
		s = s.trim();
		boolean num = false, dot = false, e = false, numAfterE = false;
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c == '+' || c == '-')
			{
				if (i != 0 && s.charAt(i - 1) != 'e')
				{
					return false;
				}
			}
			else if (c >= '0' && c <= '9')
			{
				num = true;
				if (e)
				{
					numAfterE = true;
				}
			}
			else if (c == '.')
			{
				if (dot || e)
				{
					return false;
				}
				dot = true;
			}
			else if (c == 'e')
			{
				if (e || !num)
				{
					return false;
				}
				e = true;
			}
			else
			{ // other char
				return false;
			}
		}
		return e ? numAfterE : num;
	}
	 */
}

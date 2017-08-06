package easy;
/**
 * 
 * @author ѧͽ
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

�жϸ������ַ����Ƿ�Ϊ����

һЩ����:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

ע��:
�����������������ģ�����壬��ʵ��֮ǰ������ռ�������������


 */
/**
 *
�������ж�����ܶ�
������״̬�����ǳ���࣬����Ҫ���ӵĸ����жϣ�
��ö��һ�¸��ֺϷ������������
1.�ո�+ ���� +�ո�
2.�ո�+ �� + ���� +�ո�
3.�ո�+ ���� + ���� +���ո�
4.�ո� + ���� + �� +�����֡����ո�
5.�ո� + (1, 2, 3, 4�� + e +��(1, 2, 3, 4) +�ո�
ps:�Ϸ����������5�е�(1,2,3,4)������ǺϷ����������1-4
���Ϸ����ַ������ǣ�
1.����
2.�ո�
ps:����״̬���У����ѵ����ڹ�����ֿ��ܵ�����״̬

����״̬���еĸ��ֿ��ܵ�����״̬����:
0 ��ʼ���������ֻ��space��״̬
1 ����������֮���״̬
2 ǰ�������֣�ֻ������dot��״̬
3 ������+/-״̬
4 ǰ�������ֺ���dot��״̬
5 'e' or 'E'������״̬
6 ����e֮������+/-��״̬
7 ����e���������ֵ�״̬
8 ǰ������Ч������֮������space��״̬

����״̬����״̬ת�ƹ��̣�
��ʼΪ0��
����������ո�ʱ��״̬��Ϊ0��

��������Ϊ����ʱ��״̬תΪ3��3��ת����0��һ���ģ����˲����ٽ��ܷ��ţ�����0��״̬�Ļ����ϣ��ѽ��ܷ�����Ϊ-1��

����������Ϊ����ʱ��״̬תΪ1, ״̬1��ת�������޷��ٽ��ܷ��ţ����Խ��ܿո����֣��㣬ָ����״̬1Ϊ�Ϸ��Ľ���״̬��

����������Ϊ��ʱ��״̬תΪ2��״̬2�����ٽ������֣�����������Ϊ�Ƿ���

����������Ϊָ��ʱ���Ƿ���

״̬1��
������������ʱ��תΪ״̬1��

�������ܵ�ʱ��תΪ״̬4�����Խ��ܿո����֣�ָ����״̬4Ϊ�Ϸ��Ľ���״̬��

��������ָ��ʱ��תΪ״̬5�����Խ��ܷ��ţ����֣������ٽ��ܵ㣬��Ϊָ������Ϊ���������ұ����ٽ������֣�

״̬2��
������������תΪ״̬4��

״̬3��
������0һ����ֻ�ǲ��ܽ��ܷ��ţ�

״̬4��
�������ܿո񣬺Ϸ����ܣ�

�����������֣���Ϊ״̬4��

��������ָ����תΪ״̬5��

״̬5��
�������ܷ��ţ�תΪ״̬6��״̬6��״̬5һ����ֻ�ǲ����ٽ��ܷ��ţ�

�����������֣�תΪ״̬7��״̬7ֻ�ܽ��ܿո�����֣�״̬7Ϊ�Ϸ��Ľ���״̬��

״̬6��
����ֻ�ܽ������֣�תΪ״̬7��

״̬7��
�������ܿո�תΪ״̬8��״̬7Ϊ�Ϸ��Ľ���״̬��

�����������֣���Ϊ״̬7��

״̬8��
�������ܿո�תΪ״̬8��״̬8Ϊ�Ϸ��Ľ���״̬�� 

������ο�ͼƬValidNumber.jpg
ͼƬ��Դ:https://zhuanlan.zhihu.com/p/20042325?columnSlug=simons

 *
 */

public class ValidNumber
{
	//�����ж�����̫�࣬Ϊ�ˣ������˱��˵ķ����Դ�д������
	public boolean isNumber(String s)
	{
		//ȥ����β�ո�����Ƿ�Ϊ���ֵ��ж�û��Ӱ��
		s=s.trim();
        if(s==null||s.length()==0)
            return false;
        int i = 0;
		// ����������
		if ('+' == s.charAt(i) || '-' == s.charAt(i))
			i++;
		// ����������ֲ���
		//���ڱ�ʶ�Ƿ���ֹ�(���֣��㣬ָ��)
		boolean digit = false, dot = false, exp = false;
		for (; i < s.length(); i++)
		{
			// '.'���ܳ���2�Σ�'.'ǰ���ܹ�û������
			if ('.' == s.charAt(i) && !dot) 
				dot = true;
			// 'e'���ܳ���2�Σ�'e'ǰ�����������
			else if ('e' == s.charAt(i) && !exp && digit) 
			{
				// 'e'���治�ܳ���'.'��'e'����������������ܹ������Ļ򸺵ģ�
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
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ���������˼·ͬ��
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

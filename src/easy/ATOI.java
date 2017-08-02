package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Implement atoi to convert a string to an integer.

Hint: 

Carefully consider all possible input cases. 

If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes:
It is intended for this problem to be specified vaguely (ie, no given input specs). 

You are responsible to gather all the input requirements up front.

ʵ��atoi�����ַ���ת��Ϊ����

��ʾ:
��ϸ˼�����еĿ��ܵ��������
�������Ҫ��ս�£��벻Ҫ���������ʾ��ֱ��˼�����п��ܵ���������

ע��:
���������������������������Ŀ��֮һ(���磬û�и��������˵��)

���������Ѽ����еĿ��ܵ��������


ps:������leetcode��������������ͣ��䲢û��˵�����ֳ��ֵ����Ӧ�����δ������ԣ�������ȥ������

 */
public class ATOI 
{
	public int myAtoi(String str) 
    {
		int result=0;
		String resultString="";
       //���ڼ�¼�·��ŵĸ���
       int sign=0;
       String signString="";
       str=str.trim();
       if(str==null||str.length()==0)
    	   return 0;
       for(int i=0;i<str.length();i++)
       {
    	   char c=str.charAt(i);
    	   int number=c-'0';
    	   if(number<=9&&number>=0)
    		   resultString+=number;
    	   else if(resultString.equals("")&&(c=='+'||c=='-'))
    	   {
    		   if(sign>1)
    			   break;
    		   signString=String.valueOf(c);
    		   sign++;
    	   }
    	   else
    		   break;
       }
       if(sign>1)
       {
    	   result=0;
       }
       else
       {
    	   try
    	   {
    		   result=Integer.parseInt(signString+resultString);
    	   }
    	   catch(Exception e)
    	   {
    		   if(signString.equals("-")&&!resultString.equals(""))
    			   result=Integer.MIN_VALUE;
    		   else if((signString.equals("+")||signString.equals(""))&&!resultString.equals(""))
    			   result=Integer.MAX_VALUE;
    	   }
       }
       return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 */
	/*
	public int myAtoi(String str) 
	{
        str = str.trim();
        boolean isPos = true;
        int res = 0;
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if(i == 0 && (c == '+' || c == '-')) 
            {
                isPos = c == '+' ? true : false;
            } 
            else if(c >= '0' && c <= '9') 
            {
                if(res > (Integer.MAX_VALUE - (c - '0')) / 10)//�˴�Ϊֵ��ѧϰ�ĵط��������ַ�ʽ���Ƿ���������ж�
                {
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10;
                res = res + (c - '0');
            } 
            else 
            {
                return isPos ? res : -res;
            }
        }
        return isPos ? res : -res;
    }*/
	
}

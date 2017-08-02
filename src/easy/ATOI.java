package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
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

实现atoi，将字符串转化为整数

提示:
仔细思考所有的可能的输入情况
如果你想要挑战下，请不要看下面的提示并直接思考所有可能的输入的情况

注意:
含糊不清的描述是这个问题的特殊目的之一(例如，没有给出输入的说明)

你有责任搜集所有的可能的输入情况


ps:此题在leetcode上属于烂题的类型，其并没有说出各种出现的情况应该作何处理，所以，不建议去做该题

 */
public class ATOI 
{
	public int myAtoi(String str) 
    {
		int result=0;
		String resultString="";
       //用于记录下符号的个数
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
	 * leetcode上运行时间最短的代码
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
                if(res > (Integer.MAX_VALUE - (c - '0')) / 10)//此处为值得学习的地方，用这种方式对是否溢出进行判断
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

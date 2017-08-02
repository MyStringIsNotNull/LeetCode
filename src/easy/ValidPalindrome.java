package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 *question:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 
给定一个字符串，判断其是否为回文字符串，只考虑其中只包含英文和数字的(其意思为只包含英文的字符，不考虑其它的，例如汉字等)，
并忽略大小写

例如:
"A man, a plan, a canal: Panama" 是一个回文字符串 
"race a car" 并不是一个回文字符串

注意:
你是否考虑了字符串为空的情况，这是面试过程中的一个好问题
对于这个特定的问题，我们定义空字符串为一个有效的回文字符串


 */
public class ValidPalindrome 
{
	public boolean isPalindrome(String s) 
	{
		boolean result=true;
		//将其字符全部转化为小写的情况
		s=s.toLowerCase();
		if(s.equals(""))
			return true;
		//a和z对应的ascii码
		int zNumber=(int)'z';
		int aNumber=(int)'a';
		//0和9对应的ascii码
		int zeroNumber=(int)'0';
		int nineNumber=(int)'9';
		
		for(int high=s.length()-1,low=0;low<high&&result;high--,low++)
		{
			int lowCharNumber=(int)s.charAt(low);
			int highCharNumber=(int)s.charAt(high);
			//当不为英文字符和数字的时候，继续执行
			boolean lowBoolean=(lowCharNumber>=aNumber&&lowCharNumber<=zNumber)||(lowCharNumber>=zeroNumber&&lowCharNumber<=nineNumber);
			boolean highBoolean=(highCharNumber>=aNumber&&highCharNumber<=zNumber)||(highCharNumber>=zeroNumber&&highCharNumber<=nineNumber);
			//low那个字符为英文字符或数字，high那个字符不为英文字符或数字
			if(lowBoolean&&!highBoolean)
				low--;
			//high那个字符为英文字符或数字，low那个字符不为英文字符或数字
			else if(!lowBoolean&&highBoolean)
				high++;
			//两个字符均不为英文字符或数字
			else if(!lowBoolean&&!highBoolean)
				continue;
			//当都为小写字符的时候，并且其不相等的时候
			else if(s.charAt(high)!=s.charAt(low))
				result=false;
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路与上面的相同，不推荐阅读
	 */
	/*public boolean isPalindrome(String s) 
	{
        if(s.equals(""))
        	return true;
        int length = s.length();
        int j=0;
        int k=length-1;
        while(j<k)
        {
            int a = s.charAt(j);
            int b = s.charAt(k);
            if((a<65||a>90)&&(a<97||a>122)&&(a<48||a>57)) 
            {
                j++;
                continue;
            }
            if((b<65||b>90)&&(b<97||b>122)&&(b<48||b>57)) 
            {
                k--;
                continue;
            }
            if(a!=b)
            {
                if(a>=65&&a<=90)
                {
                    return (a-'A')==(b-'a');
                }
                if(a>=97&&a<=122)
                {
                    return (a-'a')==(b-'A');
                }
                return false;
            }
            j++;
            k--;
        }
        return true;
    }*/
}

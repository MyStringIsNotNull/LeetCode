package easy;
/**
 * 
 * @author ѧͽ
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
����һ���ַ������ж����Ƿ�Ϊ�����ַ�����ֻ��������ֻ����Ӣ�ĺ����ֵ�(����˼Ϊֻ����Ӣ�ĵ��ַ��������������ģ����纺�ֵ�)��
�����Դ�Сд

����:
"A man, a plan, a canal: Panama" ��һ�������ַ��� 
"race a car" ������һ�������ַ���

ע��:
���Ƿ������ַ���Ϊ�յ�������������Թ����е�һ��������
��������ض������⣬���Ƕ�����ַ���Ϊһ����Ч�Ļ����ַ���


 */
public class ValidPalindrome 
{
	public boolean isPalindrome(String s) 
	{
		boolean result=true;
		//�����ַ�ȫ��ת��ΪСд�����
		s=s.toLowerCase();
		if(s.equals(""))
			return true;
		//a��z��Ӧ��ascii��
		int zNumber=(int)'z';
		int aNumber=(int)'a';
		//0��9��Ӧ��ascii��
		int zeroNumber=(int)'0';
		int nineNumber=(int)'9';
		
		for(int high=s.length()-1,low=0;low<high&&result;high--,low++)
		{
			int lowCharNumber=(int)s.charAt(low);
			int highCharNumber=(int)s.charAt(high);
			//����ΪӢ���ַ������ֵ�ʱ�򣬼���ִ��
			boolean lowBoolean=(lowCharNumber>=aNumber&&lowCharNumber<=zNumber)||(lowCharNumber>=zeroNumber&&lowCharNumber<=nineNumber);
			boolean highBoolean=(highCharNumber>=aNumber&&highCharNumber<=zNumber)||(highCharNumber>=zeroNumber&&highCharNumber<=nineNumber);
			//low�Ǹ��ַ�ΪӢ���ַ������֣�high�Ǹ��ַ���ΪӢ���ַ�������
			if(lowBoolean&&!highBoolean)
				low--;
			//high�Ǹ��ַ�ΪӢ���ַ������֣�low�Ǹ��ַ���ΪӢ���ַ�������
			else if(!lowBoolean&&highBoolean)
				high++;
			//�����ַ�����ΪӢ���ַ�������
			else if(!lowBoolean&&!highBoolean)
				continue;
			//����ΪСд�ַ���ʱ�򣬲����䲻��ȵ�ʱ��
			else if(s.charAt(high)!=s.charAt(low))
				result=false;
		}
		return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·���������ͬ�����Ƽ��Ķ�
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

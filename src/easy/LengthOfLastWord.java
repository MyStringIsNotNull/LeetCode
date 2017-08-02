package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a strings consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5. 

����һ���ɴ�/Сд�Ϳո���ɵ��ַ����������ַ��������һ�����ʵĳ���

������һ�����ʲ����ڣ��򷵻�0

һ�����ʱ�����Ϊ���ɷǿո�����ַ�����
 */
public class LengthOfLastWord 
{
	public int lengthOfLastWord(String s) 
	{
		int lastSpace=s.lastIndexOf(" ");
		//�����ҵ������һ���ո��ڵ��ַ�����ĩβ��ʱ��
		//��δ����Ŀ����ȥ��ĩβ�Ŀո�
		while(s.length()>0&&lastSpace==s.length()-1)
		{
			s=s.substring(0, lastSpace);
			lastSpace=s.lastIndexOf(" ");
		}
		System.out.println(s);
		return length(s);
    }
	/**
	 * ���ڽ��ַ������룬����������һ�����ʵĳ���
	 * @param s ���һ�����ʺ���û�пո���ַ���
	 * @return ���һ�����ʵĳ���
	 */
	private int length(String s)
	{
		int result=0;
		//��ȡ���һ���ո��λ��
		int lastSpace=s.lastIndexOf(" ");
        result=s.length()-1-lastSpace;
        return result;
	}
	
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��������룬�Ƽ��Ķ�
	 */
	/*
	public int lengthOfLastWord(String s) 
	{
	       int len=s.length()-1;
	       //���ڼ�¼�³���
	        int res=0;
	        while(len>=0&&s.charAt(len)==' ')
	        	len--;
	        while(len>=0&&s.charAt(len)!=' ')
	        {
	        	len--;
	        	res++;
	        }
	         return res;
	}*/
	
}

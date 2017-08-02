package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Determine whether an integer is a palindrome. Do this without extra space.

�ж�һ�������Ƿ��ǻ��������ڴ����Ͻ��в��������ö���Ŀռ�
 */
public class Palindrome 
{
	 public boolean isPalindrome(int x) 
	 {
		boolean result=true;
		String xString=String.valueOf(x);
		int low=0;
		int high=String.valueOf(x).length()-1;
		while(low<high)
		{
			char lowC=xString.charAt(low);
			char highC=xString.charAt(high);
			if(lowC!=highC)
			{
				result=false;
				break;
			}
			else
			{
				low++;
				high--;
			}
				
		}
		return result;
	 }
	 
	 /**
	  * leetcode������ʱ�����ٵĴ���
	  */
	/* public boolean isPalindrome(int x) 
	 {
		 Ϊ������ʱ���䲻Ϊ������
	        if (x < 0)
	        {
	            return false;
	        }
	        int tempX = x;
	        int reverse = 0;
	        // ��tempXʣ��һλ����ʱ��ͣ����
	        
	         * ������൱�ڽ�x���������ת�����൱��ʹ����ReverseNumber�е��Ǹ��㷨
	         * ���ǣ�����Ҫ���ǵ��ǣ�ת����������������ֵ�������������������ԣ�����㷨��������Ч��
	         
	        while (tempX >= 10)
	        {
	            reverse = reverse * 10 + tempX % 10;
	            tempX /= 10;
	        }
	        //�Ա�����x��ͷβ��λ���Լ��м�����λreverse�Ժ��Ƿ��벻reverserʱһ��
	        return tempX == x % 10 && reverse == x / 10;
	    }*/
}

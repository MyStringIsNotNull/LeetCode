package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * 
question:
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 

ʵ��strStr()����
����needle����ַ�����һ�γ�����haystack�ַ���������λ�ã���needle������haystack�е�ʱ�򣬷���-1
 */
public class ImplementStr 
{
	/*
	 * �˴�ʵ�ֱ������ҵİ취��ʵ���ϣ�Ӧ��ʵ��KMP�㷨�����ַ�����ƥ�����ӿ�
	 */
	public int strStr(String haystack, String needle) 
	{
		int result=-1;
		if(needle.length()<=haystack.length())
		{
			//��Ҫ���в��ҵ��ַ���������ÿһ���ַ����е���
			for(int i=0;i<haystack.length()-needle.length()+1;i++)
			{
				int needleLength=0;
				while(needleLength<needle.length())
				{
					char hayc=haystack.charAt(i+needleLength);
					char needlec=needle.charAt(needleLength);
					if(hayc==needlec)
						needleLength++;
					else
						break;
				}
				if(needleLength==needle.length())
				{
					result=i;
					break;
				}
			}
		}
		return result;
    }
	
	/**
	 * leetcode������ʱ����С����ֱ��ʹ��String�����indexOf()�����ģ���ѡ������ʱ��ڶ�С����Ϊ�ο�
	 */
	/*
	 * 
	 public int strStr(String haystack, String needle) 
	 {
        int l1 = haystack.length(),l2= needle.length();
        if(l1<l2)
            return -1;
        else if(l2==0)
            return 0;
        int offset = l1 -l2;
        for(int i=0;i<=offset;i++)
        {
            if(haystack.substring(i,i+l2).equals(needle))//�˴�Ϊʵ�ֵĹؼ�
                return i;
        }
        return -1;
            
     }
	 */
}

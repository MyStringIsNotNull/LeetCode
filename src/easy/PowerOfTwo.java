package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an integer, write a function to determine if it is a power of two. 

����һ����������дһ�������ж����Ƿ�Ϊ2���ݴ�
 */
public class PowerOfTwo 
{
	public boolean isPowerOfTwo(int n)
	{
		boolean result=true;
		if(n>0)
		{
			while(n!=1)
			{
				if(n%2!=0)
				{
					result=false;
					break;
				}
				n/=2;
			}
		}
		else
			result=false;
		return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���\
	 * �Ƽ��Ķ��Ĵ���
	 * ��˼·Ϊ
	 * 2�Ĵη����Ķ�����д�����ص㣺
		1     2       4         8         16 ����....
		1    10    100    1000    10000��....
		��ô���Ǻ����׿�����2�Ĵη�����ֻ��һ��1��ʣ�µĶ���0
		
		���һ������2�Ĵη����Ļ������������������ô���Ķ�������Ȼ�����λΪ1��������Ϊ0����ô�����ʱ���Ǽ�1�Ļ���
		
		�����λ�ήһλ������Ϊ0��λ���ڶ�Ϊ��Ϊ1����ô���ǰ��������룬�ͻ�õ�0�����������Ҳ��������
	 */
	/*
	public boolean isPowerOfTwo(int n) 
	{
        return n>0&&(n & (n - 1)) == 0;
    }
	*/
	
}

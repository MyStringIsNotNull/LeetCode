package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. 

��дһ�������ж�һ�����������Ƿ�Ϊ����

����Ϊһ����������������������ֻ����2��3,5

���磬6,8Ϊһ��������14������һ����������Ϊ����������������������7

��ʾ��

1��һ�����͵ĳ���

 */
public class UglyNumber 
{
	public boolean isUgly(int num)
	{
		boolean result=true;
		if(num>=1)
		{
			//������factors��Ŀ�����ڣ��κγ����������Էֽ�Ϊ2,3,5��������ĳ˻�
			int[] factors=new int[3];
			factors[0]=2;
			factors[1]=3;
			factors[2]=5;
			while(num!=1)
			{
				boolean divid=false;
				for(int factor:factors)
				{
					if(num%factor==0)
					{
						divid=true;
						num/=factor;
					}
				}
				if(!divid)
				{
					result=false;
					break;
				}
			}
		}
		else
			result=false;
		return result;
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·ͬ��
	 * 
	 */
	
	/*
	public boolean isUgly(int num) 
	{
        if(num <= 0) 
        	return false;
        while(num % 5 == 0) 
        {
            num /= 5;
        }
        while(num % 3 == 0) 
        {
            num /= 3;
        }
        while(num % 2 == 0) 
        {
            num /= 2;
        }
        return num == 1;
    }
    */
}

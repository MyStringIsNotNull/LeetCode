package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 

Starting with any positive integer, replace the number by the sum of the squares of its digits,

and repeat the process until the number equals 1 (where it will stay), 

or it loops endlessly in a cycle which does not include 1. 

Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

дһ���㷨��ȥ�ж�һ�����Ƿ���"happy"��

һ��"happy"����������Ϊ���¹���:

��ʼΪһ����������ȡ�����������λ����ƽ����

�ظ��ù��̣�ֱ����������1(�ڴ�ͣ������)

���ߵ����޷�����1��ʱ��������ֹ�����ڴ�ѭ��

��Щ������1������������happy��

 */
public class HappyNumber 
{
	public boolean isHappy(int n)
	{
		//����set�����ж��Ƿ���ӵĺ��������ֹ�����������ѭ���ĳ���
		Set<Integer> set=new HashSet<Integer>();
		boolean result=false;
		while(n!=1)
		{
			int number=0;
			while(n!=0)
			{
				number+=Math.pow((n%10),2);
				n/=10;
			}
			if(set.contains(number))
				break;
			set.add(number);
			n=number;
		}
		if(n==1)
			result=true;
		return result;
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �������ѭ���Ĺؼ�����n>6����ѭ�������򣬲�����ѭ��
	 * ��Ϊ��2-6��5�����ֵĽ������Ϊhappy��
	 * �鿴����һ�ִ������£�������˲�һ����˼·
	 * 
	 */
	
	/*
	public boolean isHappy(int n) 
	{
        if(n == 0)
        {
            return false;
        }
        while(n > 6)
        {
            int sum = 0;
            while(n > 0)
            {
                int num = n % 10;
                sum += num * num;
                n = n/10;
            }
            if(sum == 1)
            {
                return true;
            }
            n = sum;
        }
        return n==1;
    }
	*/
	
	/**
	 * leetcode�ϵ�����һ�ִ����˼·
	 * �����һ����ָ���һ����ָ�룬���ý�����Ȧ�ķ�ʽ��
	 * ������ָ��ָ��ͬһ��ֵ��ʱ������ܳ��ֵ����Ϊ
	 * low==fast==1������low==fast��=1
	 * ���������֣�����fast��low�ܻ����(һ��ԭ������Ϊ1^2==1)
	 * 
	 */
	
	/*
	public boolean isHappy(int n) 
	{
        int slow, fast;
        slow = fast = n;
        do
        {
            slow = countsum(slow);
            fast = countsum(fast);
            fast = countsum(fast);
        }while(slow!=fast);
        if(slow == 1) 
        	return true;
        return false;
    }
    private int countsum(int n)
    {
        int sum = 0;
        while(n!=0)
        {
            int temp = n%10;
            sum += temp*temp;
            n = n / 10;
        }
        return sum;
    }
	*/
}

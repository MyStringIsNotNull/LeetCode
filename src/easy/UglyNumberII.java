package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. 

дһ������ȥ�ҳ���n������

������һ������������ֻ��2,3,5��������

����:1,2,3,4,5,6,8,9,10,12��ǰ10����������

ע�⣬1������һ�����͵ĳ������Դ�������n��ֵ������1690

 */
public class UglyNumberII 
{
	/**
	 * �÷�����leetcode������ʱ������ʱ�䳬�������
	 * �䷽ʽΪ�����ƽ�
	 * Ϊ�˿���ʹ�����µķ�ʽ��õ�n������
	 * 
	 */
	/*public int nthUglyNumber(int n) 
	{
		int number=1;
		int count=0;
		while(count!=n)
		{
			if(isUgly(number++))
				count++;
		}
		return --number;
	}
	private boolean isUgly(int n)
	{
		while(n%2==0)
			n/=2;		
		while(n%3==0)
			n/=3;
		while(n%5==0)
			n/=5;
		return n==1;
	}*/
	/**
	 * 
	 * һ������Ϊǰһ����������2����3����5�õ��ģ���n������Ϊ���г����д�С������������г����еĵ�n��Ԫ��
	 *��ˣ������������������ڴ洢��2�ı����ĳ�����3�ı����ĳ�����5�ı����ĳ���
	 * ͬʱ���ö�����ά���������ǰ��i���������Ǹ�����
	 * 
	 */
	public int nthUglyNumber(int n) 
	{  
        int u = 0;  
        Queue<Integer> l1 = new LinkedList<Integer>();  
        Queue<Integer> l2 = new LinkedList<Integer>();  
        Queue<Integer> l3 = new LinkedList<Integer>();  
        l1.add(1);  
        l2.add(1);  
        l3.add(1);  
        for(int i=0; i<n; i++) 
        {  
            u = Math.min( Math.min(l1.peek(), l2.peek()), l3.peek());  
            if(l1.peek() == u) 
            	l1.poll();  
            if(l2.peek()== u) 
            	l2.poll();  
            if(l3.peek() == u) 
            	l3.poll();  
            l1.add(u*2);  
            l2.add(u*3);  
            l3.add(u*5);  
        }  
        return u;  
    }  
	
	/**
	 * ���ϵ�����һ��ʵ�֣������Ϊֱ��
	 * SortedSet���ݽ��Ϊһ������С��������ļ���
	 * 
	 */
	/*
    public int nthUglyNumber(int n) 
    {  
        SortedSet<Long> s1 = new TreeSet<>();  
        s1.add((long)1);  
        long result = s1.first();  
        for(int i=0;i<n;i++)
        {  
            result = s1.first();  
            s1.add(result * 2);  
            s1.add(result * 3);  
            s1.add(result * 5); 
            //������Ŀ������ʹ�����еĵ�һ������Ϊ�����ǰ�ĵ�i�������ĳ���
            s1.remove(result);  
        }  
        return (int)result;  
    }  
	*/
	
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·ͬ��δע�͵���д��ֻ���������˲�ͬ�����ݽṹ
	 * 
	 */
	
	/*
	public int nthUglyNumber(int n) 
	 {
        // the idea used here is that
        // every ugly no. multiplied by 2/3/5 produces an ugly number
        int ugly[]=new int[n];
        ugly[0]=1;
        // these indices keep track of which ugly no. needs to be multipied by 2/3/5
        int index2=0, index3=0, index5=0;
        // update factors to actual ugly numbers
        int factor2=2, factor3=3, factor5=5;
        for(int i=1; i<n; i++)
        {
            // since we need ugly numbers in ascending order
            int min=Math.min(Math.min(factor2, factor3), factor5);
            ugly[i]=min;
            // every ugly no. multiplied by 2/3/5 produces an ugly number
            if(min==factor2) 
            	factor2=2*ugly[++index2];
            if(min==factor3) 
            	factor3=3*ugly[++index3];
            if(min==factor5) 
            	factor5=5*ugly[++index5];
        }
        return ugly[n-1];
     }
	*/
	
	
	
}

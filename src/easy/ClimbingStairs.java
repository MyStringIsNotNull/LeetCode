package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer. 

����������¥�ݣ�����n���󵽴ﶥ��

ÿ�����������1��2�������ж����ַ�ʽȥ�������ˣ�

ע��:n��һ��������
 */
public class ClimbingStairs 
{
	/*
	 * 
	 *˼·:��¥����Ŀ�ֱ�Ϊ0��1��2,3,4,5��6��ʱ�򣬶�Ӧ����¥�ݵ�������ĿΪ:0,1,2,3,5,8,13����쳲��������е���ʽ����
	 *
	 */
	public int climbStairs(int n) 
	{
        int f1=0,f2=1;
        int tem=0;
        int result=0;
        while(tem<n)
        {
        	result=f1+f2;
        	f1=f2;
        	f2=result;
        	tem++;
        }
        return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ�������һ��
	 */
}

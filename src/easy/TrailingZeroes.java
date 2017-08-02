package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

����һ������������n!��ĩβ0�ĸ���
ע��:��Ĵ𰸱����Ƕ�����ʱ�临�Ӷ�

 */
public class TrailingZeroes 
{
	/**
	 * ע�⵽��n!��β��0�ĸ�����n!���������������2*5����������
	 * ����n!�зֽ������2�ĸ������ڷֽ����5�ĸ�����Ϊ�ˣ�ֻ�����5�ĸ�������
	 * ����5�ĸ����ļ��㣬ע�⵽
	 * 5!��1��5
	 * 10!��2��5
	 * 15!��3��5
	 * ...
	 * 25!��6��5(�ֱ�Ϊ1*5�е�5��2*5�е�5.....��5*5�е�5�ĸ�����2��)
	 * Ϊ�ˣ�Ҫ����n!��5�ĸ�����Ӧ����Sum(N/5^1,N/5^2,N/5^3.....)
	 * 
	 */
	public int trailingZeroes(int n) 
    {
		if(n<1) 
			return 0;   
        int number = 0;   
        while(n/5 != 0) {    
            n /= 5;   
            number += n;   
        }   
        return number;   
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·ͬ��
	 * 
	 */
	
	/*public int trailingZeroes(int n)
	{
        int sum = 0;
        while(n > 0) {
            n /= 5;
            sum += n;
        }
        return sum;
    }*/
	
}

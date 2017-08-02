package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3. 

����������a��b�ĺͣ����ǲ�����ʹ��+��-������

����:
���� a=1��b=2������3

 */
public class SumOfTwoInteger
{
	/**
	 * ��a��b���а�λ����
	 * ����λ���㣬xor(^)�õ��Ľ���൱����������Ӧλ�ĺͣ�AND(&)�õ��Ľ�������ӦλΪ1���൱�������ڸ�Ϊ���н�λ
	 */
	public int getSum(int a, int b) 
	{
		//���ڼ�¼��λ
		int carry=(a&b)<<1;
		//���ڼ�¼��
		int result=a^b;
		//֤�������н�λ
		while(carry!=0)
		{
			int temp=result;
			//���Ͻ�λ�õ����
			result^=carry;
			//��ȡ���Ͻ�λǰ�����Ľ�λ���
			carry&=temp;
			carry<<=1;
		}
		return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ������ڲ��������⣬����ʹ���˲����ϵ�д�û��õĴ���
	 * �Ƽ��Ķ��Ĵ���
	 * ��˼·ͬ��
	 */
	/*
	public int getSum(int a, int b) 
	{
        while (b != 0) 
        {
        	//���ڵõ����
            int c = a ^ b;
            //���ڵõ���λ
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
	*/
	
	/**
	 * �����ϵ������һ������˼·
	 * ˼·Ϊ:λ���㣨Bit Manipulation) ģ��ӷ�
	 *�÷�����˼·ͬ�ϣ�һ���ǰ�λ���㣬���ǣ���ÿ��ֻ������һλ
	 */
	/*
	public int getSum(int a, int b)
	{
		//r���ڴ洢����Ľ����c���ڼ�¼��λ�����p���ڿ���Ŀǰ����������ǵڼ�λ(��p��ֻ��һ��������λΪ1���Ҹ�1���ڵ�λ��Ϊ�ڼ�λ��������)
		int r = 0, c = 0, p = 1;
		//��ֹͣ������Ϊa��b��c�о�û�ж�����λΪ1��
		while ((a | b | c) != 0)
		{
			if (((a ^ b ^ c) & 1) != 0)
				r |= p;
			p <<= 1;
			c = (a & b | b & c | a & c) & 1;
			a >>>= 1;
			b >>>= 1;
		}
		return r;
	}
	*/
}

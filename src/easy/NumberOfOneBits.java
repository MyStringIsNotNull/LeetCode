package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function should return 3.

дһ���������ڼ��㲢����32λ�޷��������ж�������ʽ��1��λ��(Ҳ��Ϊ��Ȩƽ��)

���磬32λ����11������Ʊ�ʾ��ʽΪ00000000000000000000000000001011�����ԣ���ĺ������뷵��ֵ3

 */
public class NumberOfOneBits
{
	// you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
    	int numbers=0;
    	int temp=0;
    	for(int index=0;index<32;index++,n>>>=1)
    	{
    		temp=n&1;
    		if(temp==1)
    		{
    			temp=0;
    			numbers++;
    		}
    	}
    	return numbers;
    }
    /**
     * leetcode������ʱ����̵Ĵ���
     */
    
    /*
    public int hammingWeight(int n) 
    {
        return Integer.bitCount(n);
    }
    */
    
}

package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100)

return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it? 

�ߵ�������32λ���޷��������ĸ�λ

���磬��������43261596 (��Ӧ�Ķ�����Ϊ 00000010100101000001111010011100)

����964176192 (��Ӧ�Ķ�����Ϊ 00111001011110000010100101000000).

����:
���������ܹ��ƺܶ�ʱ�䣬���ʹ�����Ż���

 */
public class ReverseBits 
{
	// you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
    	return Integer.reverse(n);
    }
    
    /**
     * leetcode������ʱ����̵Ĵ���
     * ps,java�е�λ���������:
     * <<��λ���ƣ���λ��0
     * >>��λ���ƣ���λ������λ(0Ϊ����1Ϊ��)
     * >>>�޷������ƣ���λ��0
     * |��λ������
     * &��λ������
     * ����,n>>=1��ʾ��Ϊn=n>>1�����൱��n+=1���������㣩
     */
    
    /*
    public int reverseBits(int n) 
    {
        int res = 0;
        for(int i = 0; i < 32; ++i, n >>= 1) 
        {
        	//n&1������Ϊȡ��n�����λ
        	//res<<1������Ϊ����res�����ƶ�һλ
        	//res<<1|(n&1)������Ϊ����n�����λ������res�����λ
            res = res << 1 | (n & 1) ;
            
        }
        return res;
    }
    */
}

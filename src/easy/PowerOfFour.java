package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion? 

����һ��32λ�ķ�����������дһ������������Ƿ�Ϊ4���ݴ�

����:
����num=16������true������num=5,����false��

����:
���ܲ�ʹ��ѭ���͵ݹ���

 */
public class PowerOfFour 
{
	public boolean isPowerOfFour(int num) 
	{
		return (num>0)&&((num&(num-1))==0)&&(Integer.toBinaryString(num).length()%2==1);
    }
	
	/**
	 * 
	 * leetcode������ʱ����̵Ĵ���
	 * ʮ��������0x55555555����ת��Ϊ������ʱ��������λ��ΪȫΪ1��ż��λ��ȫΪ0(��1��ʼ����)
	 * ����һ������������Ϊ4���ݴΣ������ת��Ϊ2����ʱ����1��������λ��
	 * 
	 */
	
	/*
	 public boolean isPowerOfFour(int num) 
	 {
	       return (((num & (num-1))==0) && ((num & 0x55555555)!=0));
	  }
	*/
	
}

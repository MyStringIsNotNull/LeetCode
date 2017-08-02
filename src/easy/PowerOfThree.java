package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 

����һ����������дһ���������ж����Ƿ�Ϊ3���ݴ�

����:
���ܲ�ʹ��ѭ���͵ݹ���

 */
public class PowerOfThree
{
	public boolean isPowerOfThree(int n) 
	{
        boolean result=true;
        if(n>0)
        {
        	while(n!=1)
        	{
        		if(n%3!=0)
        		{
        			result=false;
        			break;
        		}
        		n/=3;
        	}
        }
        else 
        	result=false;
        return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·����:
	 * ����һ����Num��3���ݣ���ô����Num��Լ������3���ݣ����һ����nС��Num����3���ݣ���ô�����nһ����Num��Լ����
		�˽��������ʣ�����ֻ��Ҫ�ҵ�һ������3���ݣ���������n�ǲ��Ǵ������ݵ�Լ��������
	 */
	/*
	public boolean isPowerOfThree(int n)
	{
		int maxPower = (int) Math.pow(3,(int)(Math.log(Integer.MAX_VALUE)/Math.log(3)));  
	    // 1162261467 is 3^19,  3^20 is bigger than int
	    return ( n>0 &&  maxPower%n==0);
	}
	*/
	
}

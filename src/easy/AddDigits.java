package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime? 

����һ���Ǹ�����num���ظ��ļ������λ����֮�ͣ�ֱ����ֻʣ��һ������
����:
����num = 38��ִ�еĹ���Ϊ3 + 8 = 11, 1 + 1 = 2����Ϊ2ֻ��һ�����֣����Է�����
����:
���ܲ����κ�ѭ��/�ݹ鲢��ʱ�临�Ӷ�ΪO(1)������������

 */
public class AddDigits
{
	public int addDigits(int num)
	{
		if(num<10)
			return num;
		int number=0;
		while(num!=0)
		{
			number+=num%10;
			num/=10;
		}
		return addDigits(number);
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·Ϊ:
	 * ���������������һ��5λ����num����num�ĸ�λ�ֱ�Ϊa��b��c��d��e��

		�����¹�ϵ��num = a * 10000 + b * 1000 + c * 100 + d * 10 + e

		����num = (a + b + c + d + e) + (a * 9999 + b * 999 + c * 99 + d * 9)

		��Ϊ a * 9999 + b * 999 + c * 99 + d * 9 һ�����Ա�9���������numģ��9�Ľ���� a + b + c + d + e ģ��9�Ľ����һ����
		������num��ģ9֮��a + b + c + d + e����һ��С��9����
	 * 
	 */
	
	/*
	public int addDigits(int num) 
	{
        if (num == 0) 
        	return 0;
        if (num % 9 == 0) 
        	return 9;
        return num % 9;
    }
	*/
	
	/**
	 *
	 *blog������Ĵ��룬������˼·ͬ��
	 *
	 */
	/*
	public int addDigits(int num)
	{
        return (num - 1) % 9 + 1;
    }
	*/
	
}

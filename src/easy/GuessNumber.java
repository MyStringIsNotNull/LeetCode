package easy;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

Example:

n = 10, I pick 6.

Return 6.

����������һ���²����Ϸ�������Ϸ��������:

�Ҵ�1��n����ѡһ�����������²�����ѡ���Ǹ���

ÿ����´��ˣ��һ������������Ǵ��˻���С��

�����һ��Ԥ�ȶ����API guess(int num),��᷵�����ֽ��(-1,1,0):

-1:������
1:��С��
0:�¶���

����:
n=10,����ѡ��6
����6

 */
public class GuessNumber
{
	/**
	 * ��Ŀ������API
	 */
	private int pick=6;
	public int guess(int num)
	{
		return num>pick?-1:((num==pick)?0:1);
	}
	public int guessNumber(int n) 
	{
		int low=1;
		int high=n;
		int result=low;
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			int guess=guess(mid);
			if(guess==0)
			{
				result=mid;
				break;
			}
			else if(guess==-1)
				high=mid-1;
			else
				low=mid+1;
		}
		return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 *�Ƽ��Ķ��Ĵ��룬ѧϰ�������������������Ӷ��������֮����г���2�õ�����𰸵Ľ������
	 *��mid=(low+high)>>>1���
	 */
	/*
	public int guessNumber(int n) 
	{
        if (n == 1) return 1;
        int low = 1, high = n, mid = (low + high) >>> 1, guessRes = guess(mid);
        while (guessRes != 0) {
            if (guessRes == -1) high = mid - 1;
            else low = mid + 1;
            mid = (low + high) >>> 1;
            guessRes = guess(mid);
        }
        return mid;
    }
	 */
}

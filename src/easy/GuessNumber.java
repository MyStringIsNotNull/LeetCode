package easy;

/**
 * 
 * @author 学徒
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

我们正在玩一个猜测的游戏，这个游戏是这样的:

我从1到n中挑选一个数，你必须猜测我挑选的那个数

每次你猜错了，我会告诉你这个数是大了还是小了

你调用一个预先定义的API guess(int num),其会返回三种结果(-1,1,0):

-1:数大了
1:数小了
0:猜对了

例如:
n=10,我挑选了6
返回6

 */
public class GuessNumber
{
	/**
	 * 题目给定的API
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
	 * leetcode上运行时间最短的代码
	 *推荐阅读的代码，学习其解决两个大的正整数相加而产生溢出之后进行除以2得到错误答案的解决方案
	 *即mid=(low+high)>>>1语句
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

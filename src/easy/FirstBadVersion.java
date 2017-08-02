package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
You are a product manager and currently leading a team to develop a new product. 
 
Unfortunately, the latest version of your product fails the quality check. 
 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 

Implement a function to find the first bad version. You should minimize the number of calls to the API. 

你是一个目前正在带领着团队做新产品的产品经理。

不幸的是，产品的最后一个版本的质量没有通过检测

因为产品的每个版本是以其前一个版本为基础的，在坏的版本之后的所有产品的版本也都是坏的

假设你有n个版本[1,2,....,n]并且你想找出导致了后面所有的版本都是坏的产品的第一个坏的版本

你被给定了一个API bool isBadVersion(version) ,其会返回这个版本是否是坏的

实现一个函数，去找到第一个坏了的版本，你应该最小化调用这个API的次数

 */
public class FirstBadVersion
{
	/**
	 * 采用该方法时(采用二分法的思想)leetcode上提交代码时间超时(当int mid=(good+bad)/2时，因为可能会出现溢出)
	 * 为此采用如下的方法
	 */
	
	public int firstBadVersion(int n) 
	{
		if(isBadVersion(1))
			return 1;
		int good=1,bad=n;
		while(good<bad-2)
		{
			//int mid=(good+bad)/2;写成这样的形式时，其会出现异常，因为可能会出现bad和good的值相加溢出的情况
			int mid=good+(bad-good)/2;
			if(isBadVersion(mid))
				bad=mid;
			else
				good=mid;
		}
		int mid=good+(bad-good)/2;
		if(isBadVersion(mid))
			return mid;
		else
			return bad;
    }
    
	/**
	 * 题目提供的API，为了防止其出现报错的情况，直接采用了返回false的方案
	 */
	boolean isBadVersion(int version)
	{
		return false;
	}
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其同样采用了二分法，但其代码和思路更为简便
	 */
	/*
	public int firstBadVersion(int n) 
	{
        int left = 1, right = n;
        while(left < right)
        {
            int mid = left + (right - left )/2;
            if (isBadVersion(mid))
            {
                right = mid;
            } 
            else 
            {
                left = mid+1;
            }
        }
        return right;
    }
	*/
}

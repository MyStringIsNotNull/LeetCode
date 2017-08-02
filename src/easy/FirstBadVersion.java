package easy;
/**
 * 
 * @author ѧͽ
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

����һ��Ŀǰ���ڴ������Ŷ����²�Ʒ�Ĳ�Ʒ����

���ҵ��ǣ���Ʒ�����һ���汾������û��ͨ�����

��Ϊ��Ʒ��ÿ���汾������ǰһ���汾Ϊ�����ģ��ڻ��İ汾֮������в�Ʒ�İ汾Ҳ���ǻ���

��������n���汾[1,2,....,n]���������ҳ������˺������еİ汾���ǻ��Ĳ�Ʒ�ĵ�һ�����İ汾

�㱻������һ��API bool isBadVersion(version) ,��᷵������汾�Ƿ��ǻ���

ʵ��һ��������ȥ�ҵ���һ�����˵İ汾����Ӧ����С���������API�Ĵ���

 */
public class FirstBadVersion
{
	/**
	 * ���ø÷���ʱ(���ö��ַ���˼��)leetcode���ύ����ʱ�䳬ʱ(��int mid=(good+bad)/2ʱ����Ϊ���ܻ�������)
	 * Ϊ�˲������µķ���
	 */
	
	public int firstBadVersion(int n) 
	{
		if(isBadVersion(1))
			return 1;
		int good=1,bad=n;
		while(good<bad-2)
		{
			//int mid=(good+bad)/2;д����������ʽʱ���������쳣����Ϊ���ܻ����bad��good��ֵ�����������
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
	 * ��Ŀ�ṩ��API��Ϊ�˷�ֹ����ֱ���������ֱ�Ӳ����˷���false�ķ���
	 */
	boolean isBadVersion(int version)
	{
		return false;
	}
	
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��ͬ�������˶��ַ�����������˼·��Ϊ���
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

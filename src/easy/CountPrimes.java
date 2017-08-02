package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Count the number of prime numbers less than a non-negative number, n.

计算小于非负整数n的素数的个数

 */
public class CountPrimes
{
	//此处采用素数筛的方式进行求解
	public int countPrimes(int n)
	{
		int count=0;
		//当其为false时,其表示为素数，第0个元素不进行处理
		boolean[] prime=new boolean[n];
		if(n>=1)
			prime[1]=true;
		for(int i=2;i<n;i++)
		{
			if(!prime[i])
			{
				for(int tem=2*i;tem<n;tem+=i)
				{
					if(!prime[tem])
						prime[tem]=true;
				}
			}
		}
		for(int i=2;i<n;i++)
		{
			if(!prime[i])
				count++;
		}
		return count;
	}
	/*
	 * 用以下的方法在leetcode上运行时，时间超过，故采用素数筛的方法来求解
	 */
	/*public int countPrimes(int n) 
	{
		int count=0;
		for(int i=2;i<n;i++)
		{
			if(isPrime(i))
				count++;
		}
		return count;
    }
	*//**
	 * 用于判断一个数是否为素数
	 *//*
	private boolean isPrime(int n)
	{
		boolean result=true;
		if(n<=1)
			result=false;
		else
		{
			int sqrt=(int)Math.sqrt(n);
			for(int i=2;i<=sqrt;i++)
				if(n%i==0)
				{
					result=false;
					break;
				}
		}
		return result;
	}
	*/
	/**
	 * leetcode上运行时间最短的代码
	 * 其思想同素数筛法，但是，其去掉了n中一半的数组元素
	 * 因为除2外的偶数均不为素数
	 * 
	 */
	
	/*
	public int countPrimes(int n) 
	{
        if (n <= 2) 
        {
            return 0;
        }
        boolean[] isComposite = new boolean[n];
        int count = n/2; // don't count even numbers
        for (int i = 3; i * i < n; i += 2) 
        {
            if (isComposite[i]) 
            {
                continue;
            }
            for (int j = i * i; j < n; j += i * 2) 
            {
                if (!isComposite[j]) 
                {
                    isComposite[j] = true;
                    count--;    
                }
            }
        }
        return count;
    }
	*/
	
}

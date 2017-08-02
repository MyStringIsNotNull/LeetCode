package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Count the number of prime numbers less than a non-negative number, n.

����С�ڷǸ�����n�������ĸ���

 */
public class CountPrimes
{
	//�˴���������ɸ�ķ�ʽ�������
	public int countPrimes(int n)
	{
		int count=0;
		//����Ϊfalseʱ,���ʾΪ��������0��Ԫ�ز����д���
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
	 * �����µķ�����leetcode������ʱ��ʱ�䳬�����ʲ�������ɸ�ķ��������
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
	 * �����ж�һ�����Ƿ�Ϊ����
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
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼��ͬ����ɸ�������ǣ���ȥ����n��һ�������Ԫ��
	 * ��Ϊ��2���ż������Ϊ����
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

package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 

����һ��δ������������飬�ҵ����һ����ʧ��������

����:

����[1,2,0] ����3��

����[3,4,-1,1] ����2

����㷨�������о���O(n)��ʱ�临�ӶȺ;���O(1)�Ŀռ临�Ӷ�

 */
public class FirstMissingPositive 
{
	/**
	 * �˷���ʱ�临�Ӷ�ΪO(n)�����ǿռ临�Ӷ�ΪO(n)
	 * ��������Ŀ��Ҫ��Ϊ�˲�����leetcode�ϵķ���
	 */
	public int firstMissingPositive(int[] nums) 
	{
		int result=1;
		if(nums!=null&&nums.length!=0)
		{
			int max=nums[0];
			for(int i:nums)
			{
				if(max<i)
					max=i;
			}
			if(max>0)
			{
				result=max+1;
				boolean[] check=new boolean[max+1];
				for(int i:nums)
				{
					if(i>0&&!check[i])
						check[i]=true;
				}
				for(int i=1;i<=max;i++)
				{
					if(!check[i])
					{
						result=i;
						break;
					}
				}
			}
		}
		return result;
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ��룬�����˼�롣
	 * ��ʵ�ֵ�ʱ�临�Ӷ�ΪO(n)��������Ŀ��Ҫ��
	 *����ĵ�˼��Ϊ:����i��Ԫ�ط����ڵ�i-1Ԫ�ص�λ����
	 */
	/*
	public int firstMissingPositive(int[] nums) 
	{
        for(int i=0;i<nums.length;i++)
        {
        	//���ڵ�����i��Ԫ���ϵ�ֵ��������õ���Ӧ��λ�ã����ڵ�i��λ���Ϸ�����Ӧ��ֵ
        	while(nums[i]!=i+1)
        	{
        		//��i��Ԫ��Ӧ�÷��õ�λ��
                int sindex = nums[i]-1;
        		if(sindex<0||sindex>=nums.length)
        			break;
        		if(nums[i]==nums[sindex])
        			break;
        		int tmp = nums[i];
        		nums[i] = nums[sindex];
        		nums[sindex] = tmp;
        	}
        }
        for(int i=0;i<nums.length;i++)
        {
        	if(nums[i]!=i+1)
        		return i+1;
        }
        return nums.length+1;
    }
	*/
	
}

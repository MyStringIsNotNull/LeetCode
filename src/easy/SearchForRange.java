package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 

����һ������������������������飬�ҵ�һ������ֵ�Ŀ�ʼ�ͽ���λ��

����㷨��ʱ�临�Ӷȴ�ԼΪO(logn)

�������ֵ���������У�����[-1,-1]

����:
����[5,7,7,8,8,10] ����ֵΪ8

����[3,4]

 */
public class SearchForRange 
{
	/**
	 * ���㷨���ռ临�Ӷ�ΪO(1)��ʱ�临�Ӷ�ΪO(n)
	 * ��������Ŀ��Ҫ��
	 * Ϊ�˲������µķ���
	 */
	/*
	public int[] searchRange(int[] nums, int target) 
	{
		int lows=-1,highs=-1;
		int low=0;
		int high=nums.length-1;
		while(low<=high)
		{
			if(lows!=-1&&highs!=-1)
				break;
			if(nums[low]==target)
			{
				lows=low;
				low--;
			}
			if(nums[high]==target)
			{
				highs=high;
				high++;
			}
			low++;
			high--;
		}
		return new int[]{lows,highs};
    }
	*/
	/**
	 * ��ʱ�临�Ӷ�ΪO(logn),�ռ临�Ӷ�ΪO(1)��������Ŀ��Ҫ��
	 * ��˼��ͬ���ֲ��ң�ֻ���������˸Ľ�
	 * 
	 */
	public int[] searchRange(int[] nums, int target) 
	{
		int[] result=new int[2];
		int low=0,high=nums.length-1;
		//ȷ������߽�
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			if(nums[mid]>=target)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		result[0]=low;
		low=0;
		high=nums.length-1;
		//ȷ�����ұ߽�
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			if(nums[mid]>target)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		result[1]=high;
		if(result[0]>result[1])
			result[0]=result[1]=-1;
		return result;
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 */
	/*
	public int[] searchRange(int[] nums, int target) 
	{
        int[] range = {nums.length - 1, -1}; // {6, -1}
        helper(nums, target, 0 , nums.length - 1, range);
        if(range[0] > range[1])
        {
            range[0] = -1;
        }
        return range;
    }
  
    public void helper(int[] nums, int target, int start, int end, int[] range)
    {
        if(start > end)
        {
            return;
        }
        int mid = start + (end - start)/2; 
        if(nums[mid] == target)
        { 
        	//�õݹ�ķ�ʽȷ������߽�
            if(mid < range[0])
            {
                range[0] = mid; 
                helper(nums, target, start, mid - 1, range);
            }
            //�õݹ�ķ�ʽȷ�����ұ߽�
            if(mid > range[1])
            {
                range[1] = mid; 
                helper(nums, target, mid + 1, end, range); // 5, 5
            }
        } 
        else if(nums[mid] < target)
        {
            helper(nums, target, mid + 1, end, range);
        } 
        else
        {
            helper(nums, target, start, mid - 1, range);
        }
    }
	*/
	
}

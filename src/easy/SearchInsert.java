package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 �� 2
[1,3,5,6], 2 �� 1
[1,3,5,6], 7 �� 4
[1,3,5,6], 0 �� 0 

����һ���Ѿ��ź���������һ��Ŀ��ֵ��������ֵ���������еĻ����������������򣬷������������������е�λ��

����Լ����������в�û���ظ���ֵ
 */
public class SearchInsert 
{
	 public int searchInsert(int[] nums, int target) 
	{
		boolean search=false;
		int result=0;
		int low=0;
		int high=nums.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(nums[mid]==target)
			{
				result=mid;
				search=true;
				break;
			}
			else if(nums[mid]>target)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		if(!search&&low!=0)
			result=high+1;
		else if(!search)
			result=0;
		return result;
    }
	
	/**
	 * leetcode������ʱ�����ٵĴ���,��˼·ͬ�ϣ����ǲ��ö��ֲ��ҵķ�ʽ
	 */
	/*public int searchInsert(int[] nums, int target) 
	{
        if (nums.length == 0)
            return 0;
        int low = 0;
        int high = nums.length;
        int mid = high / 2;
        while(high - low > 0)
        {
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
            {
                low = mid + 1;
                mid = low + (high - low) / 2;	//����mid=low+(high-low)/2��mid=(low+high)/2��û������
            }
            else 
            {
                high = mid - 1;
                mid = high - (high - low) / 2;
            }        
        }
        if ( mid < 0 || (mid < nums.length && target > nums[mid]))
            return mid + 1;
        else 
        	return mid;
    }*/
}

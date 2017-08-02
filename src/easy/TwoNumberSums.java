package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question: 
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 

��һ����С�����ź�������飬�ҳ������е�����Ԫ�أ�ʹ����������ĺ͵��ڸ�����ֵ��Ҫ�������������������е�λ��
����λ��Ϊ��1��ʼ�����Ǵ�0��ʼ��Ҫ������������ÿһ���ض������������ж�����Ӧ��ֵ��ͬʱҪ�������е�ͬһ��������ʹ������
 * 
 */

public class TwoNumberSums
{
	/**
	 * ��һ�����飬����ߺ��ұ����м���ң�
	 * ���õ�Ϊһ�������������ʱ���ض���һ�������ڵ�������һ������ԭ��
	 * ʱ�临�Ӷ�ΪO��n��,
	 */
	public int[] twoSum(int[] numbers, int target) 
    {
        int low=0;
        int high=numbers.length-1;
        int[] result=null;
        while(low<high)
        {
            int sum=numbers[low]+numbers[high];
            if(sum==target)
            {
                result=new int[]{low+1,high+1};
                break;
            }
            else if(sum>target)
                high--;
            else
                low++;
        }
        return result;
    }
	/**
	 * leetcode��������ʱ�����ٵ�д��
	 */
	
/*	public int[] twoSum(int[] array, int target) 
	{
        if (array == null || array.length < 2) 
        {
           return null;
       	}
       int left = 0;
       int right = array.length - 1;
       
        * ���´���Ϊ�����֮�����佫�ұ߽��ö��ַ������˵�����ʹ�䲻�Ǵ�array.length-1����ʼ�ģ����Ǵ���ӽ��𰸵��ұ߽翪ʼ��
        * ������ҵ�Ϊ��ӽ��𰸵��ұ߽磬���ԣ��䲻����һ�������������������������������ȵ�����������������е�һ�����ض�
        * С������һ��������Ҫ�����Ǹ��������ֵ�ľ�����ӽ��𰸵��ұ߽磬�����target���Ǹ�����Ϊ�ұ߽�
        * 
        
       while (right - left > 1) 
       {  
           int mid = left + (right - left) / 2;  //binary search. find the mid and use it as our new end
           if (target <= array[mid]) 
           {  //if the target is smaller than the mid element in array, the answer lies in the left side of array
               right = mid;
           } 
           else
           {   //if target is bigger than the mid element in array, the answer is on the right side of array
               left = mid;
           }
       }  //this runs in O(log n)
       
       //binary search has limited the end of range for us.  
       int end = right;
       int start = 0;
       while (end > start) 
       {
           int sum = array[start] + array[end];
           if (sum > target) 
           {
               end--;
           } 
           else if (sum < target) 
           {
               start++;
           } 
           else 
           {
               return new int[] {start + 1, end + 1};
           }
       }
       return new int[] {-1, -1}; //new match found
   }*/
}

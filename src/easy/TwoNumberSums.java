package easy;
/**
 * 
 * @author 学徒
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

给一个从小到大排好序的数组，找出数组中的两个元素，使其相加起来的和等于给定的值，要求获得这两个数在数组中的位置
且其位置为从1开始而不是从0开始，要求你假设输入的每一个特定的数在数组中都有相应的值，同时要求数组中的同一个数不能使用两次
 * 
 */

public class TwoNumberSums
{
	/**
	 * 对一个数组，从左边和右边往中间查找，
	 * 利用的为一个数拆成两个数时，必定有一个数大于等于另外一个数的原理
	 * 时间复杂度为O（n）,
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
	 * leetcode上所花费时间最少的写法
	 */
	
/*	public int[] twoSum(int[] array, int target) 
	{
        if (array == null || array.length < 2) 
        {
           return null;
       	}
       int left = 0;
       int right = array.length - 1;
       
        * 以下代码为其聪明之处，其将右边界用二分法进行了调整，使其不是从array.length-1处开始的，而是从最接近答案的右边界开始的
        * 因其查找的为最接近答案的右边界，所以，其不考虑一个给定的数，拆成两个数，两个数相等的情况，而是让其其中的一个数必定
        * 小于另外一个数，而要查找那个数的最大值的就是最接近答案的右边界，即最靠近target的那个数作为右边界
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

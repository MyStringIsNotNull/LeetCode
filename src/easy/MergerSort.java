package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 

The number of elements initialized in nums1 and nums2 are m and n respectively.

给定两个排好序的整型数组nums1和nums2，合并nums2到nums1这个数组中

注意:
你必须假设nums1有足够的空间(空间是巨大的,或者等于m+n)去容纳得下从nums2中加入的元素
nums1数组初始化的元素个数为m，nums2为n
ps:需要注意的一点是，nums1和nums2数组中的元素的个数可能比m和n都要大


 */
public class MergerSort
{
	public void merge(int[] nums1, int m, int[] nums2, int n) 
	{
		int[] result=new int[m+n];
		int len=0;
		int index1=0;
		int index2=0;
		while(index1<m&&index2<n)
		{
			if(nums1[index1]<nums2[index2])
				result[len++]=nums1[index1++];
			else if(nums1[index1]>nums2[index2])
				result[len++]=nums2[index2++];
			else
			{
				result[len++]=nums1[index1++];
				result[len++]=nums2[index2++];
			}
		}
		if(index2<n)
		{
			System.arraycopy(nums2, index2, result, len, n-index2);
			len+=n-index2;
		}
		if(index1<m)
		{
			System.arraycopy(nums1, index1, result, len, m-index1);
			len+=m-index1;
		}
		System.arraycopy(result, 0, nums1, 0, len);
    }
	
	/**
	 * leetcode上花费的时间最少的代码
	 * 其主要是利用了nums1这个数组中多余出来的空间,将其从后往前排列
	 * 推荐阅读
	 * 
	 */
	/*public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
		int i1 = m - 1, i2 = n - 1, k = m + n - 1;
		while (i1>= 0 && i2>=0)
        {
			if (nums1[i1] < nums2[i2])
	        {
                nums1[k--] = nums2[i2--];//此处并不需要担心nums1中的数组元素被挤掉
            }
            else
            {
             nums1[k--] = nums1[i1--];
            }
        }
        while (i2 >= 0)
        {
           nums1[k--] = nums2[i2--];
     	}
        return;
     }*/
}

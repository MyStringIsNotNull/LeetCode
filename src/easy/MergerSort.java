package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 

The number of elements initialized in nums1 and nums2 are m and n respectively.

���������ź������������nums1��nums2���ϲ�nums2��nums1���������

ע��:
��������nums1���㹻�Ŀռ�(�ռ��Ǿ޴��,���ߵ���m+n)ȥ���ɵ��´�nums2�м����Ԫ��
nums1�����ʼ����Ԫ�ظ���Ϊm��nums2Ϊn
ps:��Ҫע���һ���ǣ�nums1��nums2�����е�Ԫ�صĸ������ܱ�m��n��Ҫ��


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
	 * leetcode�ϻ��ѵ�ʱ�����ٵĴ���
	 * ����Ҫ��������nums1��������ж�������Ŀռ�,����Ӻ���ǰ����
	 * �Ƽ��Ķ�
	 * 
	 */
	/*public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
		int i1 = m - 1, i2 = n - 1, k = m + n - 1;
		while (i1>= 0 && i2>=0)
        {
			if (nums1[i1] < nums2[i2])
	        {
                nums1[k--] = nums2[i2--];//�˴�������Ҫ����nums1�е�����Ԫ�ر�����
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

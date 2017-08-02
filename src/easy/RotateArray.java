package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:
Could you do it in-place with O(1) extra space? 

��תһ������n������Ԫ�ص����鵽�ұߣ�ͨ��k��

���磬n=7��k=3������[1,2,3,4,5,6,7]��תΪ[5,6,7,1,2,3,4].

ע��:
���Զ��ֽ���ķ�������������3�в�ͬ�Ľ������

��ʾ:
������O(1)�Ŀռ临�Ӷ��������


 */
public class RotateArray
{
	//������Ԫ�����������ƶ�k�Σ�ÿ�β���Ϊ1
	public void rotate(int[] nums, int k) 
	{
		if(nums.length<=1||k<=0)
			return;
		int length=nums.length;
		k%=length;
		while(k!=0)
		{
			int temp=nums[length-1];
			for(int i=length-2;i>=0;i--)
			{
				nums[i+1]=nums[i];
			}
			nums[0]=temp;
			k--;
		}
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ��Ĵ��룬�������������ƶ�k��Ԫ�ص���һ������
	 * ����Ҫ�����ƶ�k��Ԫ�ص���һ�����⣬������ʹ������㷨
	 * ��˼·Ϊ���ȷ�תǰn-k(0~n-k-1)��Ԫ��
	 * ��ת��k(n-k,n-1)��Ԫ��
	 * ���n��Ԫ�ؽ��з�ת
	 * ps:��ν�ķ�ת����Ϊ������Ԫ�ش�ͷԪ�غ�βԪ�ؽ��н���
	 * ֮�󣬽�ͷԪ�ص��±��һ��βԪ�ص��±��һ����
	 */
	
	/*
	public void rotate(int[] nums,int k)
	{
		if(k<=0)
			return;
		int length=nums.length;
		k=k%length;
		swap(nums,0,length-k-1);
		swap(nums,length-k,length-1);
		swap(nums,0,length-1);
	}
	private void swap(int[] nums,int low,int high)
	{
		for(int i=low,j=high;i<j;i++,j--)
		{
			int temp=nums[i];
			nums[i]=nums[j];
			nums[j]=temp;
		}
	}*/
}

package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 
 compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 

����n���Ǹ�������������ÿ�������Ըߵ���λ����ʽ����չʾ�����Ⱦ�Ϊ1

��������֮���������ס�˶���ˮ

����;
����[0,1,0,2,1,0,1,3,2,1,2,1], ����6.

 */
public class TrappingRainWater
{
	/**
	 * ������˼·Ϊ:
	 * ���ҵ������ֵ(������������ֵ)���±꣬Ȼ���ڸ����ֵ���������߷ֱ������ֵ���±�����Ԫ�ؽ��п�£
	 * �ڿ�£�Ĺ����м�¼�³��ֹ������ֵ�ߵ�ֵ�����ִ��ڵ��ڵ�ǰ���ֵ�ߣ�����и��£����򣬲������ˮ����������
	 * ��ǰ���ֵ�ߵ�ֵ�뵱ǰ��ֵ�Ĳֱ��������������������ֵ�����ڵ�Ԫ�ص��±꣬��������
	 * 
	 */
	public int trap(int[] height) 
	{
		if(height==null||height.length==0)
			return 0;
		int maxIndex=findMaxIndex(height);
		int result=0;
		int left=height[0];
		int right=height[height.length-1];
		for(int i=0,j=height.length-1;i<maxIndex||j>maxIndex;)
		{
			if(i<maxIndex)
			{
				if(height[i]<left)
					result+=left-height[i];
				else
					left=height[i];
				i++;
			}
			if(j>maxIndex)
			{
				if(height[j]<right)
					result+=right-height[j];
				else
					right=height[j];
				j--;
			}
		}
		return result;
    }
	private int findMaxIndex(int[] height)
	{
		int index=0;
		int max=height[0];
		for(int i=1;i<height.length;i++)
		{
			if(height[i]>max)
			{
				index=i;
				max=height[i];
			}
		}
		return index;
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·ͬ�ϣ�ֻ������Ϊ��㣬ͬʱʡȥ�˲������ֵ��ʱ��
	 */
	/*
	public int trap(int[] height)
	{
		if (height == null || height.length < 3)
			return 0;

		int vol = 0;

		int l = 0;
		int r = height.length - 1;
		int highestL = -1;
		int highestR = -1;
		int highest = -1;

		while (l <= r)
		{
			if (highestL < highestR)
			{
				if (height[l] < highestL)
				{
					vol += highestL - height[l];
				}
				else
				{
					highestL = height[l];
				}
				l++;
			}
			else
			{
				if (height[r] < highestR)
				{
					vol += highestR - height[r];
				}
				else
				{
					highestR = height[r];
				}
				r--;
			}
		}

		return vol;
	}*/
	
	
}

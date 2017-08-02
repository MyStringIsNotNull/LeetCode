package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an integer array nums, find the sum of the elements between indices i and j (i �� j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

You may assume that the array does not change.

There are many calls to sumRange function.
����һ����������nums���ҵ���Ԫ������Ϊi��j֮��(����j)��Ԫ�غ�

����:
����nums=[-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

��ʾ:
������������û�иı�

sumRange�������ܻᱻ���ö��


 */
public class RangeSumQueryImmutable
{
	/**
	 * �������µķ������ύ��leetcode��ʱ�����ֳ�ʱ�����
	 * Ϊ�ˣ��������µķ���
	 */
	/*
	private int[] nums;
    public RangeSumQueryImmutable(int[] nums) 
    {
        this.nums=nums;
    }
    
    public int sumRange(int i, int j) 
    {
    	int result=0;
        for(int index=i;index<=j;index++)
        {
        	result+=nums[index];
        }
        return result;
    }
	 */
	
	/**
	 * ��nums�����е�Ԫ�أ��洢��Ϊ��ǰ��ĸ���Ԫ��֮��
	 */
	private int[] nums;
    public RangeSumQueryImmutable(int[] nums) 
    {
        int length=nums.length;
        this.nums=new int[length+1];
        for(int i=1;i<=length;i++)
        {
            this.nums[i]=nums[i-1]+this.nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) 
    {
        return nums[j+1]-nums[i];
    }
    
    /**
     * leetcode������ʱ����̵Ĵ���
     */
    /*
    private int[] sums;
    private int[] nums;
    public NumArray(int[] nums)
     {
        if (nums != null && nums.length != 0) 
        {
            this.nums = nums;
            this.sums = new int[nums.length];
            this.sums[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                this.sums[i] = this.sums[i - 1] + this.nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return (nums == null)? null: sums[j] - sums[i] + nums[i];
    }
    */
}

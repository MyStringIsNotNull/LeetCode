package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

You may assume that the array does not change.

There are many calls to sumRange function.
给定一个整型数组nums，找到在元素索引为i和j之间(包括j)的元素和

例如:
给定nums=[-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

提示:
你必须假设数组没有改变

sumRange函数可能会被调用多次


 */
public class RangeSumQueryImmutable
{
	/**
	 * 采用以下的方法，提交到leetcode上时，出现超时的情况
	 * 为此，采用以下的方法
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
	 * 其nums数组中的元素，存储的为其前面的各个元素之和
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
     * leetcode上运行时间最短的代码
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

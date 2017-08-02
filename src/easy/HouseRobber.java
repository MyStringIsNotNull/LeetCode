package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
You are a professional robber planning to rob houses along a street. 

Each house has a certain amount of money stashed, 

the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 

and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 

determine the maximum amount of money you can rob tonight without alerting the police.

����һ��רҵ��ǿ������������������������ȥ������Щ����

ÿһ������ӵ�д洢��һ���Ľ��

Ψһ������ȥ�������ǵ����ٽ��ķ����а�ȫϵͳ����

��������Զ������ӵ��������������ٽ��ķ�����ͬһ���ϱ�����

����һ���Ǹ��������б����ÿһ���˼���ӵ�еĽ��

��û�о������������£�ȷ�����ڽ������ܻ�ȡ���������
 */
public class HouseRobber 
{
	/**
	 * 
	 * �����з�ʽʱ����ʱ�䳬��
	 * ˼·Ϊ:Ҫô���ٵ�ǰ�⻧�˼ң�Ҫô�����ٵ�ǰ�⻧�˼ң�
	 * �������⻧�˼ҵ�ʱ��ֻ�ܴ��⻧�˼ҵ����»��˼ҽ�������
	 * ���������⻧�˼ҵ�ʱ�򣬿��Դ���һ���˼�֮��ʼ��������
	 * ֮�󣬱Ƚ����Ͳ����Ĳ��������ַ�����õĽ����࣬�Ӷ�ѡ�����ֽ���
	 * Ϊ�ˣ�������һ��˼·
	 * 
	 */
	
	/*
	public int rob(int[] nums) 
    {
		if(nums==null||nums.length==0)
			return 0;
		int doRob=nums[0]+rob(nums,2,nums.length-1);
		int notRob=rob(nums,1,nums.length-1);
		return Math.max(doRob, notRob);
    }
	private int rob(int[] nums,int low,int high)
	{
		if(low>high)
			return 0;
		int doRob=nums[low]+rob(nums,low+2,high);
		int notRob=rob(nums,low+1,high);
		return Math.max(doRob, notRob);
	}
	*/
	/**
	 * ��˼·Ϊ��̬�滮���뷨
	 * ��״̬����Ϊ:maxV[i]��ʾ����i������λ�ã�������档
	 * ���ƹ�ϵΪmaxV[i] = max(maxV[i-2]+num[i], maxV[i-1])
		ע�����ܻ���������ƹ�ϵ�������ʣ��Ƿ�������¿����ԣ�maxV[i-1]������num[i-1]��
		�����ǣ������������maxV[i-1]��ͬ��maxV[i-2]�����ǰ�߸���
	 * 
	 */
	public int rob(int[] nums) 
    {
		if(nums==null||nums.length==0)
			return 0;
		else if(nums.length==1)
            return nums[0];
	 	//����������ά���������i�����ӵ�ʱ������������
		int[]  maxV=new int[nums.length];
	 	maxV[0]=nums[0];//����˼·����⣬��ʵ����ΪmaxV[0]=Math.max(0,nums[0]);
	 	//����˼·�ϵ���⣬��ʵ����ΪmaxV[1]=Math.max(nums[0],nums[1]+0);
	 	//��Ҫô�������Լ����ڵķ���ȥ����ǰ�����ڵ��Ǹ����ӵĺ�
	 	//����Ҫô���ٵ�ǰ���ڷ��Ӳ�����ǰ�治���ڵ��Ǹ����ӵĺ�
	 	maxV[1] = Math.max(nums[0], nums[1]);
	 	for(int i = 2; i <nums.length; i ++)
            maxV[i] = Math.max(maxV[i-2]+nums[i], maxV[i-1]);
        return maxV[nums.length-1];
    }
	
	/**
	 * 
	 * �����ϵ�˼·���иĽ�֮��Ĵ���
	 * 
	 */
	/*
	public int rob(int[] nums) 
    {
		if(nums==null||nums.length==0)
			return 0;
		else if(nums.length==1)
            return nums[0];
		int pre=nums[0];
		int pren=Math.max(nums[1],nums[0]);
		for(int i=2;i<nums.length;i++)
		{
			int temp=pren;
			pren=Math.max(pren, pre+nums[i]);
			pre=temp;
		}
		return pren;
    }*/
	/**
	 * leetcode������ʱ��϶̵Ĵ���
	 * ͬʱ���ٶȽ��м�֮��Ĵ���
	 * ��˼·ͬ��
	 */
	/*
	 public int rob(int[] num) 
	 {
		    int prevMax = 0;
		    int currMax = 0;
		    for (int x : num) 
		    {
		        int temp = currMax;
		        currMax = Math.max(prevMax + x, currMax);
		        prevMax = temp;
		    }
		    return currMax;
		}*/
}

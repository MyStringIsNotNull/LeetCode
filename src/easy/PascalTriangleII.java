package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? 

给定一个索引k，返回第k行的杨辉三角
例如，给定k=3，返回[1,3,3,1].

注意:
你能够把你的算法优化到空间复杂度为O(k)嘛？

 */
public class PascalTriangleII 
{
	public List<Integer> getRow(int rowIndex) 
	{
        int[] triangle=new int[rowIndex+1];
        //用于暂时存放被改变的前一个值
        int temps=0;
        List<Integer> result=new LinkedList<Integer>();
        if(rowIndex<0)
        	return result;
        //用于将其第1行的元素置为1，1
        triangle[0]=1;
        //用于控制行的迭代(从第二行开始算起)
        int row=1;
        //控制行
        while(row<=rowIndex)
        {
        	//用于将当前行的首元素置1处理
        	triangle[0]=1;
        	//初始化暂时存放的值为杨辉三角的第一个元素
        	temps=triangle[0];
        	int half=(row+1)/2;
        	//当元素的个数为偶数个的时候，将其对半分，将最后一个元素指向中间折半的那最后一个元素
        	if(row%2==1)
        		half--;
        	//用于控制更新当前行的前半数组的元素值进行更新
        	for(int tem=1;tem<=half;tem++)
        	{
        		//用于记录下当前相加元素的前一个元素的值，将其暂时存放在变量t中
        		int t=triangle[tem];
        		triangle[tem]=triangle[tem]+temps;
        		temps=t;
        		
        	}
        	//用于将后半数组的元素的值进行复制
        	int count=half;
        	if(row%2==0)
        		count--;
        	for(int tem=half+1;tem<=row;tem++,count--)
        	{
        		triangle[tem]=triangle[count];
        	}
        	//更换行
        	row++;
        }
        //将数组中的值装入List中
        for(int i=0;i<=rowIndex;i++)
        	result.add(triangle[i]);
        return result;
	}
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读，其目的是了解下数学的奥妙
	 */
	/*
	public List<Integer> getRow(int rowIndex) 
	{
       List<Integer> result = new ArrayList<Integer>();
       result.add(1);
       long tmp=1;
       for(int i=1; i<=rowIndex; i++)
       {
           tmp=tmp*(rowIndex-i+1)/i;	//此处是利用了组合数学和杨辉三角之间的关系的一个公式来进行求解的
           result.add((int)tmp);
       }
       return result;
   }*/
	
	
}

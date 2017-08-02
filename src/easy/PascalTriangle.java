package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

����һ������������һ������ʽ���������
����,����������5������
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


[
[1],
[1,1],
[1,2,1],
[1,3,3,1],
[1,4,6,4,1]
]

 */
public class PascalTriangle 
{
	public List<List<Integer>> generate(int numRows) 
	{
        int[][] triangle=new int[numRows][];
        for(int i=0;i<numRows;i++)
        {
        	triangle[i]=new int[i+1];
        }
        //��ͷβ����Ԫ�ص�ֵ��Ϊ1
        for(int i=0;i<numRows;i++)
        {
        	triangle[i][0]=1;
        	triangle[i][triangle[i].length-1]=1;
        }
        for(int i=2;i<numRows;i++)
        {
        	for(int tem=1;tem<triangle[i].length-1;tem++)
        	{
        		triangle[i][tem]=triangle[i-1][tem-1]+triangle[i-1][tem];
        	}
        }
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        for(int i=0;i<numRows;i++)
        {
        	List<Integer> temp=new LinkedList<Integer>();
        	for(int tem=0;tem<triangle[i].length;tem++)
        	{
        		temp.add(triangle[i][tem]);
        	}
        	result.add(temp);
        }
        return result;
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·ͬ�ϣ�ֻ�Ǵ����ϸ�Ϊ���
	 */
	 /*
	 public List<List<Integer>> generate(int numRows) 
	 {
	    	int result[][] = new int[numRows][];
	    	// corner case
	        if(numRows == 0) 
	        {
	        	return new ArrayList<>();
	        }
	        // first row
	        result[0] = new int[1];
	        result[0][0] = 1;
	        for(int i = 1; i < numRows; i++) 
	        {
	        	result[i] = new int[i + 1];
	        	result[i][0] = 1;
	        	for(int j = 1; j < i; j++) 
	        	{
	        		result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
	        	}
	        	result[i][i] = 1;
	        }
	        List arrayList = Arrays.asList(result);
	        return arrayList;
	    }
	*/
}

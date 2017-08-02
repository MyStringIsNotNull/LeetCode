package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? 

����һ������k�����ص�k�е��������
���磬����k=3������[1,3,3,1].

ע��:
���ܹ�������㷨�Ż����ռ临�Ӷ�ΪO(k)�

 */
public class PascalTriangleII 
{
	public List<Integer> getRow(int rowIndex) 
	{
        int[] triangle=new int[rowIndex+1];
        //������ʱ��ű��ı��ǰһ��ֵ
        int temps=0;
        List<Integer> result=new LinkedList<Integer>();
        if(rowIndex<0)
        	return result;
        //���ڽ����1�е�Ԫ����Ϊ1��1
        triangle[0]=1;
        //���ڿ����еĵ���(�ӵڶ��п�ʼ����)
        int row=1;
        //������
        while(row<=rowIndex)
        {
        	//���ڽ���ǰ�е���Ԫ����1����
        	triangle[0]=1;
        	//��ʼ����ʱ��ŵ�ֵΪ������ǵĵ�һ��Ԫ��
        	temps=triangle[0];
        	int half=(row+1)/2;
        	//��Ԫ�صĸ���Ϊż������ʱ�򣬽���԰�֣������һ��Ԫ��ָ���м��۰�������һ��Ԫ��
        	if(row%2==1)
        		half--;
        	//���ڿ��Ƹ��µ�ǰ�е�ǰ�������Ԫ��ֵ���и���
        	for(int tem=1;tem<=half;tem++)
        	{
        		//���ڼ�¼�µ�ǰ���Ԫ�ص�ǰһ��Ԫ�ص�ֵ��������ʱ����ڱ���t��
        		int t=triangle[tem];
        		triangle[tem]=triangle[tem]+temps;
        		temps=t;
        		
        	}
        	//���ڽ���������Ԫ�ص�ֵ���и���
        	int count=half;
        	if(row%2==0)
        		count--;
        	for(int tem=half+1;tem<=row;tem++,count--)
        	{
        		triangle[tem]=triangle[count];
        	}
        	//������
        	row++;
        }
        //�������е�ֵװ��List��
        for(int i=0;i<=rowIndex;i++)
        	result.add(triangle[i]);
        return result;
	}
	
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ�����Ŀ�����˽�����ѧ�İ���
	 */
	/*
	public List<Integer> getRow(int rowIndex) 
	{
       List<Integer> result = new ArrayList<Integer>();
       result.add(1);
       long tmp=1;
       for(int i=1; i<=rowIndex; i++)
       {
           tmp=tmp*(rowIndex-i+1)/i;	//�˴��������������ѧ���������֮��Ĺ�ϵ��һ����ʽ����������
           result.add((int)tmp);
       }
       return result;
   }*/
	
	
}

package memoization;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * 
question:
Given an integer matrix, find the length of the longest increasing path.
����һ�����;����ҵ����������·������
From each cell, you can either move to four directions: left, right, up or down.
����ÿһ��Ԫ�أ������ѡ���������ҵ��ƶ�
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
�㲻�ܽ��жԽ��ߵ��ƶ������߽�Ԫ���ƶ����߽���
Example 1:
����1:
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].
�������·��Ϊ[1, 2, 6, 9].
Example 2:
����2��
nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
�������·��Ϊ[3, 4, 5, 6]��������Խ��ߵ��ƶ�
 */
public class LongestIncreasingPathinaMatrix
{
	/*
	 �����˼·��
	 ����������һ����ά���飬���������������ĵ���·����
	 �涨����ֻ�������������ߣ�������б�߻����ǳ����˱߽硣
	 ��ô�����ĽⷨҪ�õݹ��DP���⣬��DP��ԭ����Ϊ�����Ч�ʣ������ظ����㡣
	 ������Ҫά��һ����ά��̬����dp������dp[i][j]��ʾ��������(i,j)Ϊ���������·���ĳ��ȣ���ʼ��dp���鶼��Ϊ0��
	 �������õݹ����ʱ������ĳ��λ��(x, y), ���dp[x][y]��Ϊ0�Ļ�������ֱ�ӷ���dp[x][y]���ɣ�����Ҫ�ظ����㡣
	 ������Ҫ��������ÿ��λ�ö�Ϊ�����õݹ��������Ƚ��ҳ����ֵ��
	 ����һ��λ��Ϊ�����DFS����ʱ�������ĸ�����λ�ý����жϣ�
	 �������λ�õ�ֵ������һ��λ�ã��������λ�ü������õݹ飬������һ�����ֵ��������ɺ󷵻ؼ��ɣ�
	 */
	//���ڱ�ʶ��ǰ�ڵ���ĸ����򡣷ֱ�Ϊ��������dirs��Ԫ�صĵ�0��Ԫ��Ϊ���������������1��Ԫ��Ϊ�����������
	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public int longestIncreasingPath(int[][] matrix)
	{
		if (matrix.length == 0)
			return 0;
		//mΪ����,nΪ����
		int m = matrix.length, n = matrix[0].length;
		//cache���ڼ�¼���������ȱ������ĵ�����·���ĳ���
		int[][] cache = new int[m][n];
		//���ڼ�¼�����·���ĳ���
		int max = 1;
		//��ÿ��Ԫ����Ϊ�������������ҵĽ�����ȱ���һ��
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				//��õ�ǰ�ڵ���Ϊ�����б����õ������·������
				int len = dfs(matrix, i, j, m, n, cache);
				//����ǰ�õ������·�����Ⱥ��Ե�ǰ�ڵ���Ϊ�����б����õ������·�����Ƚ��бȽϣ��õ��������ֵ����Ϊ��
				//��ǰ��õ����ֵ
				max = Math.max(max, len);
			}
		}
		return max;
	}
	/*
		���������ȱ���
		matrixΪ���Ӧ��Ԫ�صļ��ϣ�i��j���ڱ�ʶԪ�����ڵ�matrix�����е�λ��
		m��n�ֱ�Ϊmatrix����������������Ҫ�����ж��������ҵĽڵ��Ƿ���Խ�磻
		cache����Ϊ���������ֵ�Ļ���
	*/
	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache)
	{
		//����ýڵ��������ʱ�������ֵ������ֱ�ӽ��з��أ������ý��б������Ӷ��ﵽ����ʱ�临�Ӷȵ�Ч��
		if (cache[i][j] != 0)
			return cache[i][j];
		//�ñ�����Ҫ���ڼ�¼����Ԫ�ص�������������ľ���ĵ�
		int max = 1;		
		for (int[] dir : dirs)
		{
			//�ı�õ�ĺ������꣬�õ����Ӧ�����ڵ�Ԫ�صĵ�������
			int x = i + dir[0], y = j + dir[1];
			//����Խ��������ڵ�Ԫ�ص�ֵС�ڵ�����һ��Ԫ�ص�ֵ��ʱ���䲻�Ը�Ԫ�ؽ��еݹ����
			if (x < 0 || x >= m || y < 0 || y >= n|| matrix[x][y] <= matrix[i][j])
				continue;
			int len = 1 + dfs(matrix, x, y, m, n, cache);
			max = Math.max(max, len);
		}
		//�õ����������ȵĵ�ľ���
		cache[i][j] = max;
		return max;
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·ͬ��
	 */
	/*	
	public int longestIncreasingPath(int[][] matrix)
	{
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		int[][] path = new int[m][n];
		int[] res = new int[1];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				findLIP(matrix, path, i, j, Integer.MIN_VALUE, res);
			}
		}
		return res[0];
	}

	private int findLIP(int[][] matrix, int[][] path, int i, int j, int num,int[] res)
	{
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length|| matrix[i][j] <= num)
		{
			return 0;
		}
		int curr = matrix[i][j];
		// if(curr<=num){
		// return 0;
		// }
		if (path[i][j] != 0)
		{
			return path[i][j];
		}
		// visiting[i][j]=1;
		int nbr1 = findLIP(matrix, path, i, j - 1, curr, res);
		int nbr2 = findLIP(matrix, path, i, j + 1, curr, res);
		int nbr3 = findLIP(matrix, path, i - 1, j, curr, res);
		int nbr4 = findLIP(matrix, path, i + 1, j, curr, res);
		path[i][j] = Math.max(Math.max(nbr1, nbr2), Math.max(nbr3, nbr4)) + 1;
		// visiting[i][j]=0;
		res[0] = Math.max(res[0], path[i][j]);
		return path[i][j];
	}
 	*/
}

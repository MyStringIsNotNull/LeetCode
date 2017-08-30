package memoization;
/**
 * 
 * @author 学徒
 *
 */
/*
 * 
question:
Given an integer matrix, find the length of the longest increasing path.
给定一个整型矩阵，找到最长的增长的路径长度
From each cell, you can either move to four directions: left, right, up or down.
对于每一个元素，你可以选择上下左右的移动
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
你不能进行对角线的移动，或者将元素移动到边界外
Example 1:
例子1:
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].
最长的增长路径为[1, 2, 6, 9].
Example 2:
例子2：
nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
最长的增长路径为[3, 4, 5, 6]，不允许对角线的移动
 */
public class LongestIncreasingPathinaMatrix
{
	/*
	 代码的思路：
	 这道题给我们一个二维数组，让我们求矩阵中最长的递增路径，
	 规定我们只能上下左右行走，不能走斜线或者是超过了边界。
	 那么这道题的解法要用递归和DP来解，用DP的原因是为了提高效率，避免重复运算。
	 我们需要维护一个二维动态数组dp，其中dp[i][j]表示数组中以(i,j)为起点的最长递增路径的长度，初始将dp数组都赋为0，
	 当我们用递归调用时，遇到某个位置(x, y), 如果dp[x][y]不为0的话，我们直接返回dp[x][y]即可，不需要重复计算。
	 我们需要以数组中每个位置都为起点调用递归来做，比较找出最大值。
	 在以一个位置为起点用DFS搜索时，对其四个相邻位置进行判断，
	 如果相邻位置的值大于上一个位置，则对相邻位置继续调用递归，并更新一个最大值，搜素完成后返回即可，
	 */
	//用于标识当前节点的四个方向。分别为下右上左dirs中元素的第0个元素为横坐标的增量，第1个元素为纵坐标的增量
	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public int longestIncreasingPath(int[][] matrix)
	{
		if (matrix.length == 0)
			return 0;
		//m为行数,n为列数
		int m = matrix.length, n = matrix[0].length;
		//cache用于记录下其进行深度遍历过的点的最长的路径的长度
		int[][] cache = new int[m][n];
		//用于记录下最长的路径的长度
		int max = 1;
		//将每个元素作为起点进行上下左右的进行深度遍历一遍
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				//获得当前节点作为起点进行遍历得到的最长的路径长度
				int len = dfs(matrix, i, j, m, n, cache);
				//将当前得到的最长的路径长度和以当前节点作为起点进行遍历得到的最长的路径长度进行比较，得到其中最大值者作为其
				//当前获得的最大值
				max = Math.max(max, len);
			}
		}
		return max;
	}
	/*
		对其进行深度遍历
		matrix为其对应的元素的集合，i和j用于标识元素所在的matrix数组中的位置
		m和n分别为matrix的行数，列数，主要用于判断上下左右的节点是否发生越界；
		cache数组为遍历过的最长值的缓存
	*/
	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache)
	{
		//当其该节点遍历过的时候，其存在值，将其直接进行返回，而不用进行遍历，从而达到降低时间复杂度的效果
		if (cache[i][j] != 0)
			return cache[i][j];
		//该变量主要用于记录下其元素的上下左右中最长的距离的点
		int max = 1;		
		for (int[] dir : dirs)
		{
			//改变该点的横纵坐标，得到其对应的相邻的元素的点的最长长度
			int x = i + dir[0], y = j + dir[1];
			//当其越界或者相邻的元素的值小于等于上一个元素的值的时候，其不对该元素进行递归遍历
			if (x < 0 || x >= m || y < 0 || y >= n|| matrix[x][y] <= matrix[i][j])
				continue;
			int len = 1 + dfs(matrix, x, y, m, n, cache);
			max = Math.max(max, len);
		}
		//该点出发的最长长度的点的距离
		cache[i][j] = max;
		return max;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路同上
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

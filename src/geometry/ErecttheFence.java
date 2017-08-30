package geometry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. 
有一些树，其位置的信息用二维的方式（x，y）表示其在花园中的位置
Your job is to fence the entire garden using the minimum length of rope as it is expensive.
你的工作是用最短的绳索的长度去围住整个花园
The garden is well fenced only if all the trees are enclosed. 
 花园应当将所有的树都包围起来
Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.
你的任务是去并找到树的坐标，用这些树的坐标围起来的恰好等于其周长
Example 1:
例子一
Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation:
解释：
详见erect_the_fence1.png
Example 2:
例子2：
Input: [[1,2],[2,2],[4,2]]
输入：[[1,2],[2,2],[4,2]]
Output: [[1,2],[2,2],[4,2]]
输出:[[1,2],[2,2],[4,2]]
Explanation:
解释：
详见erect_the_fence2.png
Even you only have trees in a line, you need to use rope to enclose them. 
即使那些树并排在一条直线上，你也要用绳索去包围住他们
Note:
注意:
All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
所有的树应该包围在一起，你不能剪短绳索去包围那些树，这会使得它们被分散在多个群中
All input integers will range from 0 to 100.
所有输入的整数均在0-100之间
The garden has at least one tree.
花园中最少有一棵树
All coordinates are distinct.
所有树的坐标均是不同的
Input points have NO order. No order required for output.
输入的点并没有顺序，输出的点也没有顺序的要求

 */
public class ErecttheFence
{
	class Point
	{
		int x;
		int y;
		Point() 
		{ 
			x = 0; 
			y = 0; 
		}
		Point(int a, int b) 
		{ 
			x = a; 
			y = b;
		}
	}
	//详见数学中关于凸包相关知识之后，再理解该题
	//该份代码是自己从网上copy下来的
	//凸包最常用的凸包算法是Graham扫描法和Jarvis步进法
	//关于Graham扫描法详见博客：http://blog.csdn.net/u012328159/article/details/50808360
	//凸包的五种计算方法，详见http://blog.csdn.net/bone_ace/article/details/46239187
	public List<Point> outerTrees(Point[] points)
	{
		Point first = points[0];
		int firstIndex = 0;
		// Find the leftmost point
		for (int i = 0; i < points.length; i++)
		{
			Point point = points[i];
			if (point.x < first.x)
			{
				first = point;
				firstIndex = i;
			}
		}
		Set<Point> answer = new HashSet<>();
		Point cur = first;
		int curIndex = firstIndex;
		answer.add(first);
		do
		{
			Point next = points[0];
			int nextIndex = 0;
			for (int i = 1; i < points.length; i++)
			{
				if (i == curIndex)
					continue;
				Point p = points[i];
				int cross = crossProductLength(p, cur, next);
				if (nextIndex == curIndex || cross > 0 ||(cross == 0 && distance(p, cur) > distance(next, cur)))
				// Handle multi points in a line
				{
					next = p;
					nextIndex = i;
				}
			}
			// Handle multi points in a line
			for (int i = 0; i < points.length; i++)
			{
				Point p = points[i];
				int cross = crossProductLength(p, cur, next);
				if (i != curIndex && cross == 0)
				{
					answer.add(p);
				}
			}
			cur = next;
			curIndex = nextIndex;
		} while (curIndex != firstIndex);
		return new ArrayList<>(answer);
	}

	private int crossProductLength(Point A, Point B, Point C)
	{
		// Get the vectors' coordinates.
		int BAx = A.x - B.x;
		int BAy = A.y - B.y;
		int BCx = C.x - B.x;
		int BCy = C.y - B.y;
		// Calculate the Z coordinate of the cross product.
		return (BAx * BCy - BAy * BCx);
	}
	private int distance(Point p1, Point p2)
	{
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 
	 */
	/*
	public List<Point> outerTrees(Point[] points)
	{
		Point[][] range = new Point[101][2];
		int high = -1;
		int low = 101;
		for (int i = 0; i < points.length; i++)
		{
			int x = points[i].x;
			if (range[x][0] == null || range[x][0].y > points[i].y)
			{
				range[x][0] = points[i];
			}
			if (range[x][1] == null || range[x][1].y < points[i].y)
			{
				range[x][1] = points[i];
			}
			high = Math.max(x, high);
			low = Math.min(x, low);
		}
		Set<Point> result = new HashSet<Point>();
		for (int i = 0; i < points.length; i++)
		{
			int x = points[i].x;
			if (x == low || x == high)
			{
				result.add(points[i]);
			}
		}
		int lowindex = low;
		while (lowindex < high)
		{
			double min = Double.MAX_VALUE;
			int lowest = -1;
			for (int i = lowindex + 1; i < range.length; i++)
			{
				if (range[i][0] == null)
				{
					continue;
				}
				double slope = (double) (range[i][0].y - range[lowindex][0].y)
						/ (double) (range[i][0].x - range[lowindex][0].x);
				if (slope < min && min - slope > 0.000001)
				{
					min = slope;
					lowest = i;
				}
			}
			result.add(range[lowest][0]);
			lowindex = lowest;
		}
		int highindex = low;
		while (highindex < high)
		{
			double max = Integer.MIN_VALUE;
			int highest = -1;
			for (int i = highindex + 1; i < range.length; i++)
			{
				if (range[i][1] == null)
				{
					continue;
				}
				double slope = (double) (range[i][1].y - range[highindex][1].y)
						/ (double) (range[i][1].x - range[highindex][1].x);
				if (slope > max && slope - max > 0.000001)
				{
					max = slope;
					highest = i;
				}
			}
			result.add(range[highest][1]);
			highindex = highest;
		}
		return new ArrayList<Point>(result);
	}
	*/
	
	
} 

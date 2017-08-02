package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. 

If there is a choice tie between answers, output all of them with no order requirement. 

You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.


Andy和Doris想选择一个餐厅去吃晚餐，他们都有一个以字符串形式呈现的列表，上面写上了他们最喜欢的餐厅的名字
你需要去帮助他们找出共同感兴趣的列表的下标和最小的那个
如果有多个答案的情况，输出所有的答案，输出的答案并没有顺序的要求
你可以假设总是有一个答案存在


例如:
输入：
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出:["Shogun"]
解释:他们共同喜欢的，只有"Shogun"这一个


例如:
输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
输出:["Shogun"]
解释:他们都喜欢的并且具有最小下标和的元素是"Shogun" ，它的下标和为1

注意:
两个列表的长度都会在1到1000之间
在两个列表中的具有共同字符串的个数在1到30之间
列表的索引从0开始
两个列表中均没有重复的元素

 */
public class MinimumIndexSum 
{
	/**
	 * 这种写法的时间复杂度很高为O(n^2)
	 * 其空间复杂度较低
	 */
	public String[] findRestaurant(String[] list1, String[] list2) 
	{
		String result="";
		int min=Integer.MAX_VALUE;
		for(int i=0;i<list1.length;i++)
		{
			for(int tem=0;tem<list2.length;tem++)
			{
				if(list1[i].equals(list2[tem]))
				{
					int sum=i+tem;
					if(sum<min)
					{
						result=list1[i];
						min=sum;
					}
					else if(sum==min)
					{
						result+=","+list1[i];
					}
				}
			}
		}
		return result.split(",");
    }
	
	/**
	 * 
	 * leetcode上运行时间最短的代码
	 * 不同推荐阅读的代码，其是一种用空间换取时间的做法
	 * 并且其可以进行进一步的优化，以节省空间
	 * 即在构造HashMap的时候，将list1和list2的长度进行比较，选用较小的那个字符串数组进行构造
	 * 
	 */
	/*
	public String[] findRestaurant(String[] list1, String[] list2) 
	{
		ArrayList<String> resultList = new ArrayList<String>();
		HashMap<String, Integer> l1Map = new HashMap<String, Integer>(list1.length * 2);
		for (int i = 0; i < list1.length; i++) 
		{
			l1Map.put(list1[i], i);
		}

		int minIndexSum = Integer.MAX_VALUE;//此处的值可将其修改为minIndexSum=list1.length+list2.length;
		for (int i = 0; i < list2.length; i++) 
		{
			if (l1Map.containsKey(list2[i])) 
			{
				int indexSum = l1Map.get(list2[i]) + i;
				if (indexSum < minIndexSum) 
				{
					minIndexSum = indexSum;
					resultList.clear();
					resultList.add(list2[i]);
				} 
				else if (indexSum == minIndexSum)
				{
					resultList.add(list2[i]);
				}
			}
		}
		return resultList.toArray(new String[resultList.size()]);
	}
	*/
}

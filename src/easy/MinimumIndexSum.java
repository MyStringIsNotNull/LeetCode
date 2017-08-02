package easy;
/**
 * 
 * @author ѧͽ
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


Andy��Doris��ѡ��һ������ȥ����ͣ����Ƕ���һ�����ַ�����ʽ���ֵ��б�����д����������ϲ���Ĳ���������
����Ҫȥ���������ҳ���ͬ����Ȥ���б���±����С���Ǹ�
����ж���𰸵������������еĴ𰸣�����Ĵ𰸲�û��˳���Ҫ��
����Լ���������һ���𰸴���


����:
���룺
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
���:["Shogun"]
����:���ǹ�ͬϲ���ģ�ֻ��"Shogun"��һ��


����:
����:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
���:["Shogun"]
����:���Ƕ�ϲ���Ĳ��Ҿ�����С�±�͵�Ԫ����"Shogun" �������±��Ϊ1

ע��:
�����б�ĳ��ȶ�����1��1000֮��
�������б��еľ��й�ͬ�ַ����ĸ�����1��30֮��
�б��������0��ʼ
�����б��о�û���ظ���Ԫ��

 */
public class MinimumIndexSum 
{
	/**
	 * ����д����ʱ�临�ӶȺܸ�ΪO(n^2)
	 * ��ռ临�ӶȽϵ�
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
	 * leetcode������ʱ����̵Ĵ���
	 * ��ͬ�Ƽ��Ķ��Ĵ��룬����һ���ÿռ任ȡʱ�������
	 * ��������Խ��н�һ�����Ż����Խ�ʡ�ռ�
	 * ���ڹ���HashMap��ʱ�򣬽�list1��list2�ĳ��Ƚ��бȽϣ�ѡ�ý�С���Ǹ��ַ���������й���
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

		int minIndexSum = Integer.MAX_VALUE;//�˴���ֵ�ɽ����޸�ΪminIndexSum=list1.length+list2.length;
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

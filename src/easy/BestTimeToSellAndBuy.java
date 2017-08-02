package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock)

design an algorithm to find the maximum profit.

Example 1:

Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

Example 2:

Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.

数组中的第i个元素的值是第i天的股票的价格
如果你只被允许去完成一个交易(购买一个并且出售股票的股份)
设计一个算法去寻找这个最大的收益

例子1:
输入:[7, 1, 5, 3, 6, 4]
输出:5
最大.不同=6-1=5(而不是7-1=6，正如销卖的价格要比购买的价格大那样)

例子2:
输入:[7, 6, 4, 3, 1]
输出:0

在这个例子中，没有交易进行，最大的利润为0


对于这道题，其只能依次从数组的第一个元素往后执行遍历，在遍历当前元素的情况下判断是买进还是卖出股票的股份，而不能
从后往前遍历


 */
public class BestTimeToSellAndBuy 
{
	public int maxProfit(int[] prices) 
	{
		if(prices==null||prices.length==0)
			return 0;
		//用于记录获得的利润
		int profit=0;
		//用于记录下买进的价格
		int buyPrice=prices[0];
		//从第二个元素其开始遍历数组中的元素
		for(int i=1;i<prices.length;i++)
		{
			//当出现价格比买进的价格大，并且比当前利润还大的时候，选择在此卖出
			if(prices[i]>buyPrice&&profit<prices[i]-buyPrice)
			{
				profit=prices[i]-buyPrice;
			}
			//当出现价格比买进的价格还要低的时候，重新选择买进
			else if(prices[i]<buyPrice)
			{
				buyPrice=prices[i];
			}
		}
		return profit;
    }
	/**
	 * leetcode上运行时间最短的代码
	 * 其代码的思路为从前往后遍历数组的元素，当出现比当前的价格还小的时候，选择买入，当出现比当前价格还大的时候，尝试卖出
	 * 
	 */
	/*
	public int maxProfit(int prices[]) 
	{
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) 
        {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }*/
	
}

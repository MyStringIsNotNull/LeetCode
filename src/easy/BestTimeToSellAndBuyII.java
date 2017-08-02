package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like

(ie, buy one and sell one share of the stock multiple times). 

However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

数组中的第i个元素的值是第i天的股票的价格
设计一个算法去找出最大的利润，你可以完成多次的交易(买入和卖出一支股票的股份多次)
但是，你不能在同样的时间里进行多次的交易(你必须售卖掉股票在你在此买入之前)


 */
public class BestTimeToSellAndBuyII 
{
	public int maxProfit(int[] prices) 
	{
		if(prices.length==0||prices==null)
			return 0;
		int profit=0;
		int buyPrice=prices[0];
		//对数组的元素进行从前往后的遍历
		for(int i=1;i<prices.length;i++)
		{
			//当出现股票的价格比当前的股票的价格大的时候，卖出，并尝试买入
			if(prices[i]>buyPrice)
			{
				profit+=prices[i]-buyPrice;
				buyPrice=prices[i];
			}
			//当出现当前的股票的价格比尝试买入的股票的价格还要小的时候，买入新的股票
			else
			{
				buyPrice=prices[i];
			}
		}
		return profit;
	}
	/**
	 * leetcode上运行时间最短的代码
	 * 其思路的实现和上面所写的代码有相同之处，但是此处的写法更为直接，更加接近本质点
	 * 因为其只能出现两种情况
	 * 第一种为当前买入的股票的价格比下一天的要大，则其卖出
	 * 第二种为当前买入的股票的价格比下一天的要小，则其买入较小的
	 * 由此，可以得到下面的代码，其写法更为直接
	 * 
	 */
	/*public int maxProfit(int[] prices) 
	{
    	int res = 0;
        for(int i = 1; i < prices.length; i++) 
        {
        	if(prices[i] > prices[i - 1]) 
        		res += prices[i] - prices[i - 1];
        }
        return res;
    }*/
}

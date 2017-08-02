package easy;
/**
 * 
 * @author ѧͽ
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

�����еĵ�i��Ԫ�ص�ֵ�ǵ�i��Ĺ�Ʊ�ļ۸�
�����ֻ������ȥ���һ������(����һ�����ҳ��۹�Ʊ�Ĺɷ�)
���һ���㷨ȥѰ�������������

����1:
����:[7, 1, 5, 3, 6, 4]
���:5
���.��ͬ=6-1=5(������7-1=6�����������ļ۸�Ҫ�ȹ���ļ۸������)

����2:
����:[7, 6, 4, 3, 1]
���:0

����������У�û�н��׽��У���������Ϊ0


��������⣬��ֻ�����δ�����ĵ�һ��Ԫ������ִ�б������ڱ�����ǰԪ�ص�������ж����������������Ʊ�Ĺɷݣ�������
�Ӻ���ǰ����


 */
public class BestTimeToSellAndBuy 
{
	public int maxProfit(int[] prices) 
	{
		if(prices==null||prices.length==0)
			return 0;
		//���ڼ�¼��õ�����
		int profit=0;
		//���ڼ�¼������ļ۸�
		int buyPrice=prices[0];
		//�ӵڶ���Ԫ���俪ʼ���������е�Ԫ��
		for(int i=1;i<prices.length;i++)
		{
			//�����ּ۸������ļ۸�󣬲��ұȵ�ǰ���󻹴��ʱ��ѡ���ڴ�����
			if(prices[i]>buyPrice&&profit<prices[i]-buyPrice)
			{
				profit=prices[i]-buyPrice;
			}
			//�����ּ۸������ļ۸�Ҫ�͵�ʱ������ѡ�����
			else if(prices[i]<buyPrice)
			{
				buyPrice=prices[i];
			}
		}
		return profit;
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·Ϊ��ǰ������������Ԫ�أ������ֱȵ�ǰ�ļ۸�С��ʱ��ѡ�����룬�����ֱȵ�ǰ�۸񻹴��ʱ�򣬳�������
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

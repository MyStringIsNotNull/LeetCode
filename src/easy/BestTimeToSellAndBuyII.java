package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like

(ie, buy one and sell one share of the stock multiple times). 

However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

�����еĵ�i��Ԫ�ص�ֵ�ǵ�i��Ĺ�Ʊ�ļ۸�
���һ���㷨ȥ�ҳ����������������ɶ�εĽ���(���������һ֧��Ʊ�Ĺɷݶ��)
���ǣ��㲻����ͬ����ʱ������ж�εĽ���(�������������Ʊ�����ڴ�����֮ǰ)


 */
public class BestTimeToSellAndBuyII 
{
	public int maxProfit(int[] prices) 
	{
		if(prices.length==0||prices==null)
			return 0;
		int profit=0;
		int buyPrice=prices[0];
		//�������Ԫ�ؽ��д�ǰ����ı���
		for(int i=1;i<prices.length;i++)
		{
			//�����ֹ�Ʊ�ļ۸�ȵ�ǰ�Ĺ�Ʊ�ļ۸���ʱ������������������
			if(prices[i]>buyPrice)
			{
				profit+=prices[i]-buyPrice;
				buyPrice=prices[i];
			}
			//�����ֵ�ǰ�Ĺ�Ʊ�ļ۸�ȳ�������Ĺ�Ʊ�ļ۸�ҪС��ʱ�������µĹ�Ʊ
			else
			{
				buyPrice=prices[i];
			}
		}
		return profit;
	}
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·��ʵ�ֺ�������д�Ĵ�������֮ͬ�������Ǵ˴���д����Ϊֱ�ӣ����ӽӽ����ʵ�
	 * ��Ϊ��ֻ�ܳ����������
	 * ��һ��Ϊ��ǰ����Ĺ�Ʊ�ļ۸����һ���Ҫ����������
	 * �ڶ���Ϊ��ǰ����Ĺ�Ʊ�ļ۸����һ���ҪС�����������С��
	 * �ɴˣ����Եõ�����Ĵ��룬��д����Ϊֱ��
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

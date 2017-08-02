package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 You are playing the following Nim Game with your friend: 
 
 There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
 
 The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. 

Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, 

then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend. 

你正准备和你的朋友玩NimGame

有一堆石头在桌面上，每次你们中的一个人可以移除1到3颗石头

其中最后移除尽石头的人将会成为赢家，你会成为第一个去移除石头的人

你们都非常的聪明，并且对于这款游戏都有最佳的策略。

编写一个函数，判断你是否能够在给定数目的一对石头里赢得这场比赛

例如，这堆石头有4个石头，

这样你就永远无法赢得这场游戏，无论你移除1个或者2个或者3个石头，最后一个石头终将会被你的朋友所移除

 */
public class NimGame 
{
	/**
	Nim游戏的解题关键是寻找“必胜态”。

	根据题设条件：

	当n∈[1,3]时，先手必胜。

	当n == 4时，无论先手第一轮如何选取，下一轮都会转化为n∈[1,3]的情形，此时先手必负。

	当n∈[5,7]时，先手必胜，先手分别通过取走[1,3]颗石头，可将状态转化为n == 4时的情形，此时后手必负。

	当n == 8时，无论先手第一轮如何选取，下一轮都会转化为n∈[5,7]的情形，此时先手必负。
	*/
	public boolean canWinNim(int n)
	{
		return (n&0x3)!=0;
	}
	/**
	 * leetcode上运行时间最短的代码
	 *其思路为:找出规律 
	 */
	
	/*
	public boolean canWinNim(int n) 
	{
        return n%4 != 0;
    }*/
}

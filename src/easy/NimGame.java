package easy;
/**
 * 
 * @author ѧͽ
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

����׼�������������NimGame

��һ��ʯͷ�������ϣ�ÿ�������е�һ���˿����Ƴ�1��3��ʯͷ

��������Ƴ���ʯͷ���˽����ΪӮ�ң�����Ϊ��һ��ȥ�Ƴ�ʯͷ����

���Ƕ��ǳ��Ĵ��������Ҷ��������Ϸ������ѵĲ��ԡ�

��дһ���������ж����Ƿ��ܹ��ڸ�����Ŀ��һ��ʯͷ��Ӯ���ⳡ����

���磬���ʯͷ��4��ʯͷ��

���������Զ�޷�Ӯ���ⳡ��Ϸ���������Ƴ�1������2������3��ʯͷ�����һ��ʯͷ�ս��ᱻ����������Ƴ�

 */
public class NimGame 
{
	/**
	Nim��Ϸ�Ľ���ؼ���Ѱ�ҡ���ʤ̬����

	��������������

	��n��[1,3]ʱ�����ֱ�ʤ��

	��n == 4ʱ���������ֵ�һ�����ѡȡ����һ�ֶ���ת��Ϊn��[1,3]�����Σ���ʱ���ֱظ���

	��n��[5,7]ʱ�����ֱ�ʤ�����ֱַ�ͨ��ȡ��[1,3]��ʯͷ���ɽ�״̬ת��Ϊn == 4ʱ�����Σ���ʱ���ֱظ���

	��n == 8ʱ���������ֵ�һ�����ѡȡ����һ�ֶ���ת��Ϊn��[5,7]�����Σ���ʱ���ֱظ���
	*/
	public boolean canWinNim(int n)
	{
		return (n&0x3)!=0;
	}
	/**
	 * leetcode������ʱ����̵Ĵ���
	 *��˼·Ϊ:�ҳ����� 
	 */
	
	/*
	public boolean canWinNim(int n) 
	{
        return n%4 != 0;
    }*/
}

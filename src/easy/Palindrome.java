package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Determine whether an integer is a palindrome. Do this without extra space.

判断一个整数是否是回文数，在此数上进行操作，不用额外的空间
 */
public class Palindrome 
{
	 public boolean isPalindrome(int x) 
	 {
		boolean result=true;
		String xString=String.valueOf(x);
		int low=0;
		int high=String.valueOf(x).length()-1;
		while(low<high)
		{
			char lowC=xString.charAt(low);
			char highC=xString.charAt(high);
			if(lowC!=highC)
			{
				result=false;
				break;
			}
			else
			{
				low++;
				high--;
			}
				
		}
		return result;
	 }
	 
	 /**
	  * leetcode上运行时间最少的代码
	  */
	/* public boolean isPalindrome(int x) 
	 {
		 为负数的时候，其不为回文数
	        if (x < 0)
	        {
	            return false;
	        }
	        int tempX = x;
	        int reverse = 0;
	        // 当tempX剩下一位数的时候停下来
	        
	         * 在这里，相当于将x这个数进行转换，相当于使用了ReverseNumber中的那个算法
	         * 但是，这里要考虑的是，转换后的数超过了最大值产生了溢出的情况，所以，这个算法不是最有效的
	         
	        while (tempX >= 10)
	        {
	            reverse = reverse * 10 + tempX % 10;
	            tempX /= 10;
	        }
	        //对比整个x的头尾两位，以及中间所有位reverse以后是否与不reverser时一致
	        return tempX == x % 10 && reverse == x / 10;
	    }*/
}

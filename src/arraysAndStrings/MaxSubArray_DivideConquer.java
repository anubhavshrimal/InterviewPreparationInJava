package arraysAndStrings;

public class MaxSubArray_DivideConquer {

	//class to represent the set of result
	static class Res
	{
		public int start;	//start index of max sub array
		public int end;		//end index of max sub array
		public int maxSum;	//sum of max sub array
		
		public Res(int start,int end,int maxSum) 
		{
			this.start=start;
			this.end=end;
			this.maxSum=maxSum;
		}
	}
	
	//method to return the maximum sub array found
	public Res maxSubArray(int a[],int l,int r)
	{
		
		if(l==r)	//base case to stop the recursion
			return new Res(l,r,a[l]);
		
		int m=(l+r)/2;	//middle element
		Res left=maxSubArray(a, l, m);
		Res right=maxSubArray(a, m+1, r);
		Res crossOver=maxCrossOver(a, l, m, r);
		
		return maxOf(left,right,crossOver);	//return maximum sub array of the 3 sub arrays created 
	}
	
	//method to return the maximum sum object after comparing the sums
	private Res maxOf(Res left,Res right,Res crossOver)
	{
		if(left.maxSum>right.maxSum && left.maxSum>crossOver.maxSum)
			return left;
		else if(right.maxSum>left.maxSum && right.maxSum>crossOver.maxSum)
			return right;
		else
			return crossOver;
	}
	
	//finds the maximum sub array possible for the array passing through the mid point
	private Res maxCrossOver(int a[],int l,int m,int r)
	{
		int left_sum=Integer.MIN_VALUE;
		int right_sum=Integer.MIN_VALUE;
		int left=m,right=m;	
		int sum=0;
		
		//find the max sum from mid to left 
		for(int i=m;i>=l;i--)
		{
			sum+=a[i];
			if(sum>left_sum)
			{
				left_sum=sum;
				left=i;
			}			
		}
		
		sum=0;
		//find the max sum from mid to right
		for(int i=m+1;i<=r;i++)
		{
			sum+=a[i];
			if(sum>right_sum)
			{
				right_sum=sum;
				right=i;
			}			
		}
		return new Res(left,right,left_sum+right_sum);
	}
	
	public static void main(String[] args)
	{
		int a[]={-1,-5,8,9,3,10,-5,-8,-100};
		Res res=new MaxSubArray_DivideConquer().maxSubArray(a, 0, a.length-1);
		System.out.println(res.start+"-----"+res.end+"-----"+res.maxSum);
	}

}

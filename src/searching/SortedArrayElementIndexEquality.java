/*Question) Given a sorted array (all elements are unique) find the element index where A[i]=i in O(log n) time complexity 
 * and O(1) space complexity where n is the size of the array.
 * Answer: Here we use the concept of modified binary search if a[i]=i then a[i]-i will be 0 and hence search for 0*/
package searching;

public class SortedArrayElementIndexEquality 
{
	//method to return the element index where a[i]=i else return -1
	public int searchIndex(int a[])
	{
		int l=0;
		int r=a.length-1;
		int m;
		while(l<=r)
		{
			m=l+(r-l)/2;
			if(a[m]-m==0)
				return m;
			else if(a[m]-m>0)
				r=m-1;
			else
				l=m+1;
		}
		return -1;
	}
	
	//driver function
	public static void main(String[] args) 
	{
		int[] a={-1,0,2,4,6,10,15};
		int index=new SortedArrayElementIndexEquality().searchIndex(a);
		System.out.println("The index where a[i]=i is: "+index);
	}
}

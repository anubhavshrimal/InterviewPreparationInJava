package sorting;

import java.util.Scanner;

public class RadixSort 
{
	//method returns number of digits in the maximum element of the array
	private int getMaxDigits(int a[],int size)
	{
		int max=a[0];
		for(int i=1;i<size;i++)	//find the maximum element in the array
		{
			if(a[i]>max)
				max=a[i];
		}
		
		int count=0;	//variable for number of digits
		while(max!=0)
		{
			count++;
			max/=10;
		}
		return count;
	}
	
	//counting sort for each position
	private void countingSort(int a[],int size,int exp)
	{
		int temp[]=new int[10];
		int sortedArray[]=new int[size];
		
		for(int i=0;i<size;i++)
			temp[(a[i]/exp)%10]++;
		
		for(int i=1;i<=9;i++)
			temp[i]+=temp[i-1];
		
		for(int i=0;i<size;i++)
		{
			sortedArray[temp[(a[i]/exp)%10]-1]=a[i];
			temp[(a[i]/exp)%10]--;
		}
		
		//copying sorted array to original array
		for (int i = 0; i < size; i++) 
			a[i]=sortedArray[i];
	}
	
	//method to perform radix sort
	public void radixSort(int a[],int size)
	{
		int maxDigits=getMaxDigits(a, size);	//gets the number of digits in the maximum element of the array
		
		for(int i=1;maxDigits/i>0;i*=10)	//perform sorting for each place in the array elements
			countingSort(a, size, i);
	}
	
	public void printArray(int a[],int size)
	{
		for (int i = 0; i < size; i++)
		{
			System.out.print(a[i]+" --> ");
		}
		System.out.println("END");
	}
	
	//driver function
	public static void main(String[] args) 
	{
		int size;
		
		Scanner sc=new Scanner(System.in);
		
		//input array size
		System.out.println("Enter the number of elements in the array:");
		size=sc.nextInt();
		int array[]=new int[size];	//allocate memory to array
		
		//input array elements
		System.out.println("Enter array to be sorted (via radix sort):\n");
		for(int i=0;i<size;i++)
			array[i]=sc.nextInt();
		
		RadixSort obj=new RadixSort();
		obj.printArray(array, size);
		
		obj.radixSort(array,size);		//radixSort function calling
		
		System.out.println("After Sorting:");
		obj.printArray(array, size);
		
		sc.close();
	}

}

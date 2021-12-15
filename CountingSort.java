import java.util.Arrays;

class CountingSort{
	
	//Method to find largest key in the data range
	private static int findKRange(int[] arr){
		int k=0;
		for(int i: arr){
			if(i>k){
				k=i;
			}
		}
		return k;
	}
	
	//Method to return count array with the count of individual element
	private static int[] prepareCountArray(int[] arr, int k){
		int[] count=new int[k+1];
		for(int i: arr){
			++count[i];
		}
		return count;
	}
	
	//Method for sorting using counting sort
	private static void sort(int[] arr){
		int k=findKRange(arr);
		int[] count=prepareCountArray(arr,k);
		for(int i=1;i<=k;++i){
			count[i]=count[i]+count[i-1];
		}
		int j=arr.length-1;
		int[] sortedArr=new int[arr.length];
		while(j>=0){
			sortedArr[--count[arr[j]]]=arr[j];
			j--;
		}
		print(sortedArr);
	}

	//Method to print array elements
	private static void print(int[] arr){
		Arrays.stream(arr).forEach(System.out::print);
	}

	//Main method
	public static void main(String[] args){
		int[] arr=new int[]{1,4,1,2,7,5,2};
		System.out.println("Unsorted array:");
		print(arr);
		System.out.println("\nSorted array");
		sort(arr);
	}
}

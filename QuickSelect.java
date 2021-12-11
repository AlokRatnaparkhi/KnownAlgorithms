import java.util.Arrays;

class QuickSelect{
	
	//Function to find kth element
	private int findKthElement(int[] arr, int low, int high, int k) {
		int partition=partition(arr,low,high,k);
		if(partition<k-1) {
			return findKthElement(arr,partition+1,high,k);
		}
		else if(partition>k-1) {
			return findKthElement(arr,low,partition-1,k);
		}
		else {
			return arr[partition];
		}
	}
	
	//Function to partition array around the pivot
	private int partition(int[] arr,int low,int high,int k) {
		int pivot=arr[high],pivotloc=low;
		for(int i=low;i<=high;++i) {
			if(arr[i]<pivot) {
				swap(arr,i,pivotloc);
				pivotloc++;
			}
		}
		swap(arr,pivotloc,high);
		return pivotloc;
	}
	
	//Function for in-place swapping
	private void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
		
	//Main Method
	public static void main(String[] args) {
		int[] arr=new int[] {100,200,234,564,222,544,1,2,3,6000,23,12,53,43,53,33,21,555};
		int[] arrcpy=Arrays.copyOf(arr, arr.length);
		int k=4;
		QuickSelect q=new QuickSelect();
		if(k>arr.length || k< 0) {
			System.out.println("Invalid value of k. Array Index out of bound.");
		}
		else {
			System.out.println("The Kth element is "+q.findKthElement(arrcpy,0, arrcpy.length-1,k));
		}
	}
}

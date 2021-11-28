package String;

class RobinKarp{
	
	private static int d=256;
	
	//Function to find pattern in a given string
	public void searchPattern(char[] text, char[] pattern){
		int m=text.length;
		int n=pattern.length;
		long hashOfText=0;
		long hashOfPattern=0;
		hashOfText=generateHashCode(text,0,n-1);
		hashOfPattern=generateHashCode(pattern,0,n-1);
		for(int i=0;i<=m-n;++i){
			if(hashOfText==hashOfPattern){
				if(compareCharArrayWindow(text,pattern,i,n)) 
					System.out.println("Pattern found at:"+i);
			}
			//Rolling Hash
			if(i<m-n)
				hashOfText=rollHashCode(text,hashOfText,i,n);
		}	
	}
	
	//Reusable function to generate hashcode 
	private long generateHashCode(char[] arr, int startIndex, int endIndex){
		long hashCode=0;
		for(int i=startIndex; i<=endIndex;++i) {
				hashCode=(long) (hashCode+arr[i]*Math.pow(d,i));
		}
		return hashCode;
	}
	
	//Function to compare possible pattern in a given string
	private boolean compareCharArrayWindow(char[] text, char[] pattern, int startIndex, int window){
		for(int i=0;i<window;++i){
		if(text[i+startIndex]!=pattern[i]) return false;
		}
		return true;
	}
	
	//Function to roll the hashes
	private long rollHashCode(char[] arr, long hashCode, int startIndex, int window){
		hashCode=hashCode-arr[startIndex];
		hashCode/=d;
		hashCode+=arr[startIndex+window]*Math.pow(d,window-1);
		return hashCode;
	}

	public static void main(String[] args){
		String text="LordOfTheRings";
		String pattern="Ring";
		RobinKarp k=new RobinKarp();
		System.out.println("The pattern text is present at:");
		k.searchPattern(text.toCharArray(),pattern.toCharArray());
	}
}

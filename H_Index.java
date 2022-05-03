//Time Complexity : O(n)
//Space Complexity : O(n)
public class H_Index {	
	/**Approach: Count/Bucket Sort**/
	public int hIndex(int[] citations) {
        if(citations==null || citations.length==0) return 0;
        int n = citations.length;
        int[] buckets= new int[n+1];
        //Bucket sort/count sort
        for(int i=0; i<n; i++){
            if(citations[i] >= n)
                buckets[n]++;
            else
                buckets[citations[i]]++;
        }
        //Find h-index where breach happens
        int sum=0;
        for(int i=n; i>=0; i--){
            sum += buckets[i];
            if(sum >= i){
                return i;
            }
        }        
        return 0;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		H_Index ob= new H_Index();
		int[] citations = {3,0,6,1,5};
		System.out.println("H-index in given array is : "+ob.hIndex(citations));					
	}	
}

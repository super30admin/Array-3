// TC: O(N) where N is length of the array citations
// CS: O(N) to store count for array bucket
public class h_index {

	public int findHindex(int[] citations) {
		
		if(citations == null || citations.length == 0)
			return 0;
		
		int n = citations.length;
		int[] bucket = new int[n+1];  // since we need to consider even the length of the array 
		// INstead os sorting the array and checking for the number of citations with h index, we are trying to keep the values in stored format
		// using bucket sort in bucket array
		
		for(int i: citations) {
			if(i >= n) // if the value of citations is greater than n, we will keep increment the count of n
				bucket[n]++;
			else
				bucket[i]++; // increment the count of citations less than n
		}
		
		int cnt = 0;
		for(int i=n;i>=0;i--) {
			
			// we will take the count of each values of the citations, if the values are greater than or equal to i
			// we return that h index
			cnt += bucket[i];
			// helps keep track of count of papers with greater citations, since we are traversing from last, we retrieve the maximum index when there
			// are multiple citations
			if(cnt >= i)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		
		h_index hi = new h_index();
		int[] citations = {3,0,6,1,5};

		System.out.println(hi.findHindex(citations));
		
	}
}

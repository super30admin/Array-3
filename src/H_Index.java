import java.util.Arrays;

public class H_Index {
	// Time Complexity : O(nlogn)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No

	// Your code here along with comments explaining your approach
	/*
	 * This is a bruteforce approach where the citations array is sorted and when the diff crosses over the citations value, 
	 * the diff value becomes the h-index
	 */
	public int hIndex1(int[] citations) {
        if(citations == null) return 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            int diff = n - i;
            if(diff <= citations[i]){
                return diff;
            }
        }
        return 0;
    }
	// Time Complexity : O(n)
	// Space Complexity : O(n+1)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No

	// Your code here along with comments explaining your approach
	/*
	 * This is a bucket sort approach where the citations array created with the size equal to length of the given citations array + 1.
	 * according to the citation array's element is identified, that bucket index element will be be incremented. when the citations element 
	 * value is greater than of equal to the length, then increment the last bucket's index.
	 * compare each bucket index summation with the processed storage in the bucket array, if the sum stored is greater than or equal to the 
	 * bucket index, then return that index value as the h-index
	 */
	public int hIndex2(int[] citations) {
        if(citations == null) return 0;
        int n = citations.length;
        int [] bucket = new int [n+1];
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= n){
                bucket[n]++;
            } else{
                bucket[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += bucket[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
	
}

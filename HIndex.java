package array3;

import java.util.Arrays;

public class HIndex {
	//Time Complexity : O(n), where n is length of citations
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        
        for(int i=0; i<n; i++) {
            if(citations[i] >= n)
                bucket[n]++;
            else
                bucket[citations[i]]++;
        }
        
        int sum = 0;
        for(int i=bucket.length - 1; i>=0; i--) {
            sum += bucket[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
	
	//Time Complexity : O(n log n), where n is length of citations
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        for(int i=0; i<citations.length; i++) {
            int diff = n - i;
            if(citations[i] >= diff)
                return diff;
        }
        
        return 0;
    }
}

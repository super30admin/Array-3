// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

// Your code here along with comments explaining your approach
// Approach 1: Sort and find h-index
// Time Complexity : O(n log n)
//      n: number of citations
// Space Complexity : O(1)
class Problem2S1 {

    /** find h-index */
    public int hIndex(int[] citations) {

        // edge case
        if(citations == null || citations.length == 0)
            return 0;
        // sort
        Arrays.sort(citations);
        int n = citations.length;
        int diff;
        // iterate
        for(int i=0; i<n; i++){
            diff = n-i;
            if( citations[i] >= diff)
                return diff;
        }
        // default 
        return 0;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using bucket sort
// Time Complexity : O(2n) = O(n)
//      n: number of citations
// Space Complexity : O(n+1)
//      n: number of citations
class Problem2S2 {

    /** find h-index */
    public int hIndex(int[] citations) {

        // edge case
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int[] bucket = new int[n+1];
        int temp; //behaves like index
        // iterate and place them in bucket
        for(int i=0; i<n; i++){
            if(citations[i] >= n)
                temp = n;
            else
                temp = citations[i];
            bucket[temp]++;
        }
        // finding sum
        temp = 0;
        while(n >= 0){
            temp += bucket[n];
            if(temp >= n)
                return n;
            n--;
        }

        // default 
        return 0;
    }
}
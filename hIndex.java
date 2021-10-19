// Time Complexity : O()
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Traditional sorting method O(n * logn)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int i=0; i<n ; i++){
            int diff = n-i;
            if(diff <= citations[i]) return diff;
        }
        return 0;
    }
}

// ***********************************************

// Bucket sorting method O(n)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        //Arrays.sort(citations);
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i=0; i<n ; i++){
            if(citations[i] >= n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
        }
        
        int sum = 0;
        for(int i=buckets.length-1; i>=0 ; i--){
            sum += buckets[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}
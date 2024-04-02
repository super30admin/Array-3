// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english  :  We don't have to sort as h-index lies from 0 to n, we only care about the n indexes. Therefore apply bucket sort and find where the flip happens. 


class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int i = 0 ; i < n ; i++){
            if(citations[i] >= n){
                buckets[n]++;
            }
            else{
                buckets[citations[i]]++;
            }
        }

        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum +=buckets[i];
            // h papers have at least h citations
            if(sum >= i){
                return i;
            }
        }

        return -1; //dummy
    }
}
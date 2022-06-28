// Time Complexity : O(n) n no.of elements in the height array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
taken an array of size n+1 and added the values that match to their indexes at the bucket array.If
greater than or equal to n then group them at index n. cal the sum from the end and wherever the sum crosses
the index value its the h-index(h>=h and n-h<=h)



class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int []bucket = new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                bucket[n]++;
            }
            else{
                bucket[citations[i]]++;
            }
        }
        int sum =0;
        for(int i=n;i>=0;i--){
            sum = sum + bucket[i];
            if(sum>=i) return i;
        }
        return 0;
    }
}
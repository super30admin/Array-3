// Time = O(n) n is elements in array;
//Space = O(n);
//LeetCode : Worked


class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i =0;i<n;i++){
            buckets[Math.min(citations[i],n)] ++ ; 
        }
        int sum =0;
        
        for(int i = n;i>=0;i--){
            sum += buckets[i];
            if(sum>=i) return i;
        }
        return 0;
    }
}
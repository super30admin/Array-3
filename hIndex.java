//time complexity : O(nlogn)
//space complexity: O(1)
//executed on leetcode: yes
/**
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=0;i<citations.length;++i)
        {
            int diff = citations.length-i;
            if(citations[i]>=diff) return diff;
        }
        return 0; //in case of empty citations array
    }
}
**/
//approach 2: using bucket sort
//time complexity: O(n)
//space complexity : O(n+1)
//executed on leetcode: yes

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1]; //last index is nth
        for(int i=0;i<n;++i)
        {
            buckets[Math.min(citations[i],n)]++; //put at appropriate bucket,if citations[i] is greater than the length of buckets,put the element in the last index
        }
        int sum = 0;
        for(int i=buckets.length-1;i>=0;--i)
        {
            sum+=buckets[i];
            if(sum>=i) return i; // i is the number of citations here
        }
        return 9090;
    }
}
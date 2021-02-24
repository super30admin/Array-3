// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null) return 0;
        int n=citations.length;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            int diff=n-i;
            if(diff<=citations[i]){
                return diff;
            }
        }
        return 0;
    }
}
///
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null) return 0;
        int n=citations.length;
        int[] buckets=new int[n+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=n){
                buckets[n]++;
            }else{
                buckets[citations[i]]++;
            }
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum=sum+buckets[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;
    }
}
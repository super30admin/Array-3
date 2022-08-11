// Time Complexity : O(n) iterate over citations
// Space Complexity : O(n) for the bucket array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int [] buckets = new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                buckets[n]++;
            }
            else{
                buckets[citations[i]]++;
            }
        }
        int sum = 0;
        //System.out.println(Arrays.toString(buckets));
        for(int i=n;i>=0;i--){
            sum+=buckets[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;
    }

    public static void main(String [] args){
        HIndex hi = new HIndex();
        System.out.println(hi.hIndex(new int[]{3,0,6,1,5}));
    }
}
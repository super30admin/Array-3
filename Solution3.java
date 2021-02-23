//Time Complexity: O(nlogn)
//Space Complexity: O(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null)return 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i =0;i<citations.length;i++){
            int diff = n-i;
            if(diff<=citations[i]){
                return diff;
            }
        }return 0;
    }
}

//Time Complexity:O(N)
//Space Complexity: O(N)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null)return 0;
        int n= citations.length;
        
        int [] buckets = new int[n+1];
        for(int i =0;i<citations.length;i++){
            if(citations[i]>=n){
                //put it in the last bucket
                buckets[n]++;
            }
            else{
                buckets[citations[i]]++;
            }
        }
        int sum =0;
        for(int i=n;i>=0;i--){
            sum+=buckets[i];
            if(sum>=i){
                return i;
            }
        }return 0;
    }
}
//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0) return 0;
        int n =citations.length;
        int[] arr = new int[n+1];
        for(int cite:citations){
            if(cite>=n) arr[n]++;
            else{
                arr[cite]++;
            }
        }
        int rsum =0;
        for(int i=n;i>=0;i--){
            rsum+=arr[i];
            if(rsum>=i) return i;
        }
        return 0;
    }
}
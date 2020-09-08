//TC: O(n)
//SC: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        if(n == 0) return 0;
        for(int citation : citations){
            buckets[Math.min(citation,n)]++;
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += buckets[i];
            if(sum >= i) return i;
        }
        return -1;
    }
}

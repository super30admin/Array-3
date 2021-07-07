//Brute Force : 
// TC : O(n log n)
// SC : O(1)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        for(int i=0;i<citations.length;i++){
            int val = citations[i];
            int diff = citations.length - i;
            if(val>=diff) return diff;
        }
        
        return 0;
    }
}
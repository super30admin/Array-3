// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];
        
        for(int citation: citations){
            if(citation < n)
                arr[citation]++;
            else
                arr[n]++;
        }
        
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += arr[i];
            if(sum >= i)
                return i;
        }
        
        return -1;
    }
}
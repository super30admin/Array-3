// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] paper = new int[citations.length+1];
        
        for(int i=0; i<n; i++){
            paper[Math.min(citations[i], n)]++;
        }
        
        int sum = 0;
            
        for(int i=paper.length-1; i>=0; i--){
            sum += paper[i];
            if(sum>=i)
                return i;
        }
        return -1;
    }
}
// Time Complexity :  O(N)
// Space Complexity : O(N) for extra space for counting .
// Did this code successfully run on Leetcode : Yes

class HIndex {
    public int hIndex(int[] citations) {
     
        int n=citations.length;
        
        int[] hindex= new int[n+1];
        
        for(int c:citations){
           //Check if number greater than n then update last index increment to 1 as its not significant
            if(c>=n)
                hindex[n]++;
            
            else
                // else increment count of citation index 
                hindex[c]++;
        }
        
        int sum=0;
        // increment sum until it is greater than or equal to i and return i
        for(int i=n;i>0;i--){
            sum=sum+hindex[i];
            if(sum>=i) return i;
        }
            
        return 0;
    }
}
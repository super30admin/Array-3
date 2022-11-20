// TC : O(n)
// SC : O(n)
// Method : counting sort
class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        
        int[] temp = new int[n + 1];
        
        for(int k : citations) {
            if(k > n)
                temp[n]++;
            else
                temp[k]++;
        }
        int sum = 0;
        for(int i = n ; i >= 0; i--) {
        
            sum = sum + temp[i];
            if(sum >= i)
                return i;
            
        }
        
        return 0;
    }
}

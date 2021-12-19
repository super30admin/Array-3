// 274 - Hindex
// Time - O(n)
// Space - O(1)
class Solution {
    public int hIndex(int[] citations) {
        
        int[] hashtable = new int[citations.length + 1];
        int n = citations.length;
        
        for(int citation : citations){
            
            if (citation > citations.length){
                hashtable[n]++;
            }else{
                hashtable[citation]++;
            }
        }
        
        int cumSum = 0;
        
        for(int i = hashtable.length - 1; i >= 0; i--){
            cumSum = cumSum + hashtable[i];
            if(cumSum >= i){
                return i;
            }
        }
        
        return -1;
    }
}
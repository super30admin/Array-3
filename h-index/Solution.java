/**
 * Time complexity: O(n)
 * Space Complexity: O(n+1)
 */
class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        
        for(int i=0;i<citations.length;i++){
            if(citations[i] > citations.length)
                count[citations.length]++;
            else
                count[citations[i]]++;            
        }
        
        int sum = 0;
        for(int i=count.length-1;i>0;i--){
            sum += count[i];
            
            if(sum >= i)
                return i;
        }
        return 0;
    }
}
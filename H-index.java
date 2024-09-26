/*
 * Time complexity : O(n)
 * Space complexity : O(n)
 * 
 */
class Solution {
    public int hIndex(int[] citations) {
        
        if(citations == null || citations.length == 0){
            return 0;
        }
        
        int count = 0;
        int n = citations.length;
        int h[] = new int[citations.length+1];
        
        for(int i=0; i<citations.length; i++){
            h[Math.min(citations[i], n)]++;
        }
        
        for(int i=h.length-1; i>=0; i--){
            
            count = count + h[i];
            if(count >= i){
                return i;
            }
        }
        
        System.out.println(Arrays.toString(h));
        return count;
        
    }
}
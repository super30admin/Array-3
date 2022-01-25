// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * we will take array h whose index is possible h-index
 * Then we itarate over citations and update h[citations[i]]++
 * Then we iterate from last to 0 index in h array
 * Here we calculate h[i] = h[i] + h[i+1].
 * If this value >= i, then we got h-index
 * This is because, researcher has i papers with citations i and more and remaining has less then i
*/

class Solution {
    public int hIndex(int[] c) {
        if(c == null || c.length == 0)return 0;
        
        int[] h = new int[c.length+1];
        
        for(int i = 0; i < c.length;i++){
            if(c[i] >= h.length){
                h[h.length-1]++;
            }else{
                h[c[i]]++;
            }
        }
        
        for(int i = h.length-1; i >= 0;i--){
            if(i+1 < h.length){
                h[i] = h[i] + h[i+1];
            }
            if(h[i] >= i)return i;
        }
        
        return 0;
    }
}
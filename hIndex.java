/**

LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(logN)

The idea is to use Binary Search to find n-mid citations at each level of binary search to return the hIndex.


**/
class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        
        if(citations == null || citations.length < 1)
            return 0; 
        
        return createBST(citations);
    }
    
     public int createBST(int[] citations){
        int l = 0;
        int r = citations.length - 1;
        
        int val  = 0;
        int diff = 0;
        
        while(l <= r){
            int mid = l + (r - l)/2;
            val  = citations[mid];
            diff = citations.length - mid;
            
            if(val == diff)
                return val;
            
            if(val < diff)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return citations.length - l;
        
    }
    
    
}

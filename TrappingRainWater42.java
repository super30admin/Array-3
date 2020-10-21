class Solution {
    // Approach1: - O(n), O(1)
            // LeftMax, RightMax, L , R pointers 
    
    // Approach2: - TC: 3n => O(n), SC: 3n => O(n)
            // total area - given area => remaining is water
            // Left Array -- Max from left, 
            // Right Array -- Max from right,
            // res = Math.min(left, right) - height(i);
    
    
    // Approach2
//     public int trap(int[] height) {
//         if(height == null || height.length == 0 ){
//             return 0;
//         }

//         int len = height.length;

//         int[] left = new int[len];
//         left[0] = height[0];
        
//         int[] right = new int[len];
//         right[len-1] = height[len - 1];
        
//         for(int i = 1; i < len; i++){
//             left[i] = Math.max(left[i-1], height[i]);
//         }
        
//         for(int i = len-2; i >= 0; i--){
//             right[i] = Math.max(right[i+1], height[i]);
//         }
        
//         int total = 0;
//         for(int i = 0; i < len; i++){
//             total += Math.min(left[i], right[i]) - height[i];
//         }
        
//         return total;
//     }
    
    
    // Approach1:
    // Time Complexity:     O(n)
    // Space Complexity:    O(1)
    public int trap(int[] height) {
        if(height == null){
            return 0;
        }
                       
    // 1. LM < RM Implies Taller bar exists on the right side
            // 1-a. currValue > leftMax => update LeftMax
            // 1-b. Else implies => water pocket ==> add to total
    // 2. Else implies Taller bar exists on the left side
            // 2-a. currValue > rightMax => update RightMax
            // 2-b. Else implies => water pocket ==> add to total
        
        int L = 0, R = height.length-1, LM = 0, RM = 0, total = 0;
        
        while(L <= R){
            // 1
            if(LM < RM){    
                // 1-a
                if(LM < height[L])      
                    LM = height[L];
                else
                    // 1-b
                    total += LM - height[L];
                L++;    
            } else {    
            // 2
                // 2-a
                if(RM < height[R]){      
                    RM = height[R];
                } else
                    // 2-b
                    total += RM - height[R];
                R--;
            }
        }
        return total;
    }
}
class Solution:
    def trap(self, height: List[int]) -> int:
      
        if not height:
            return 0
        total = lmax = rmax = 0
        left_max, right_max =  [0]* len(height), [0]* len(height)
      
        for i in range(len(height)):
            lmax, rmax = max(lmax, height[i]), max(rmax, height[~i])
            left_max[i], right_max[len(height)-1-i] = lmax, rmax
     
        
        for i in range(1,len(height)):
            min_val = min(left_max[i], right_max[i])
           
            if min_val >0 and height[i]< min_val: 
                
                total+= min_val - height[i]
        return total
		
        
#TC: O(N) 
#SC: O(1)
      
class Solution {
public:
    int trap(vector<int>& height) {
    int n= height.size();   
        if(n == 0)
        {
            return 0;
        }
    int left[n]; 
    int right[n]; 
    int water = 0; 
  
    left[0] = height[0]; 
    for (int i = 1; i < n; i++) 
       left[i] = max(left[i-1], height[i]); 
  
    // Fill right array 
    right[n-1] = height[n-1]; 
    for (int i = n-2; i >= 0; i--) 
       right[i] = max(right[i+1], height[i]); 
  
  
    for (int i = 0; i < n; i++) 
       water += min(left[i],right[i]) - height[i]; 
  
    return water; 
    }
};

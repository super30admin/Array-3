//Approach- Optimized
//1. take 2 vriables representing left and right wall. 
//2. we need right wall, and left wall variable to check, if we are storing water on left side, we should make sure
//that we have right wall bigger than leftwall to store the water. 
//so my first check is - if(leftwall <= right wall) -- yes, then we process left side. 
//to process left side, we have left pointer (start at 0) and for right( start at n-1) - right pointer. 
//we check if leftwall is greater then left pointer, that mean we have valley at left pointer and can store water , 
//and also, right wall is protecting it to flow away from!
//same thing will be repeated when rwall is less than leftwall. - and we'll check if right pointer has valley to store water 
//tc- only one pass - O(n)
//sc - O(1)


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int n = height.length;
        int  l =0, r =n-1, lw =0, rw =0;
        int area =0;
        while(l <= r)
        {
            if(height[lw] <= height[rw])
            {
                //process the left side
                if(height[lw] <= height[l])
                {
                    lw =l;
                    l++;
                }
                else
                {
                    area += (height[lw] -height[l]); 
                }
            }
            else
            {
                //process the right side
                if(height[rw] <= height[r])
                {
                    rw =r;
                    r--;
                }
                else
                {
                    area+= (height[rw] -height[r]);
                }
                
            }
        }
        return area;
    }
}


//B-F approach
/*
 * 1. we will run a for loop and for every index we will run two other nest for loop to find the leftmax wall and
 * rightmax wall for that index to hold water. 
 * 2. area = area + Math.min(leftwall, rightwall) - height[i];
 * 3. for every index, we will reset lwall and right wall to get new answer. 
 tc - O(n^2), sc -O(1)
 */


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int n = height.length;
        int left =0, right =0;
        int area =0;

        for(int i=0; i<n; i++)
        {
            left =0; right =0;
            //look for left wall
            for(int j =i; j>=0; j--)
            {
                left = Math.max(left, height[j]);
            }
            //look for right wall
            for(int k = i; k<n; k++ )
            {
                right = math.max(right, height[k]);
            }

            area = area+ Math.min(left, right) - height[i];
        }
        return area;
    }
}
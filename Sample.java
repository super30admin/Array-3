//****119.189.ROTATE ARRAY****
//Time complexity:o(n);
//Space complexity:o(1);
//Leetcode runnable: Y;
//Any doubts:N;

class Solution {
    public void rotate(int[] nums, int k) {
       
        k=k%nums.length;
       
       
        //Rotate the whole array very first time
        int l=0;
        int r=nums.length-1;
       
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
       
        //Now as the array is rotated, Rotate its first and second part
        l=0;
        r=k-1;
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
       
       
        //Now as the first part of array is rotated, Rotate its second part;
        l=k;
        r=nums.length-1;
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
           
       
    }
}


//*****118.42.TRAPPING RAIN WATER****
//Time complexity:o(n);
//Space complexity:o(1);
//Leetcode runnable: Y;
//Any doubts: N;

class Solution {
    public int trap(int[] height) {
        //null case
        if(height==null || height.length==0)
        {
            return 0;
        }
        //Declaring variables
        int currtrap=0;
        int result=0;
        
        int slow=0;
        int fast=1;
        //Forward pass
        while(fast<height.length)
        {
            if(height[fast]<height[slow])
            {
                currtrap+=height[slow]-height[fast];
            }
            else
            {
                result+=currtrap;
                currtrap=0;
                slow=fast;
            }
            fast++;
        }
        
        int peak=slow;
        slow=height.length-1;
        fast=slow-1;
        currtrap=0;
        
        //Backward pass
        while(fast>=peak)
        {
           if(height[fast]<height[slow])
           {
               currtrap+=height[slow]-height[fast];
           }
            else
            {
                result+=currtrap;
                currtrap=0;
                slow=fast;
            }
            fast--;
        }
     return result;   
    }
}



class Solution {
    public int trap(int[] height) {
        //null case
        if(height==null || height.length==0)
        {
            return 0;
        }
        //Declaring variables
        int currtrap=0;
        int result=0;
        
        int slow=0;
        int fast=1;
        //Forward pass
        while(fast<height.length)
        {
            if(height[fast]<height[slow])
            {
                currtrap+=height[slow]-height[fast];
            }
            else
            {
                result+=currtrap;
                currtrap=0;
                slow=fast;
            }
            fast++;
        }
        
        int peak=slow;
        slow=height.length-1;
        fast=slow-1;
        currtrap=0;
        
        //Backward pass
        while(fast>=peak)
        {
           if(height[fast]<height[slow])
           {
               currtrap+=height[slow]-height[fast];
           }
            else
            {
                result+=currtrap;
                currtrap=0;
                slow=fast;
            }
            fast--;
        }
     return result;   
    }
}

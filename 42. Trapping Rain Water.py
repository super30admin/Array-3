#######42. Trapping Rain Water####################################################################################
// Time Complexity : O(n)
// Space Complexity : O(1) -> no extra space 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We found the max in whole array now consider this max we traversed form left to right till me reach max during this process we found water trapped as the the length of left minimum the moment a cement > left min is encountered the leftmin is update and we keep traversing toward right till we reach max. The same step we do form right to max and keeping rightmin in check


class Solution:
    def trap(self, height: List[int]) -> int:
        maxidx=0
        minleft=0
        minright=0
        sum=0
        for i in range(0,len(height)):
            if height[i]>height[maxidx]:
                maxidx=i
        for i in range(0,maxidx):
            if height[i]>minleft:
                minleft=height[i]
            else:
                sum+=minleft-height[i]
        for i in range(len(height)-1,maxidx,-1):
            if height[i]>minright:
                minright=height[i]
            else:
                sum+=minright-height[i]
        return sum

        
        
        

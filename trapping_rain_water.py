"""
// Time Complexity : O(n) n is length of shorter array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        """
        Variables used in the computation - 
        L, R (pointers to array in height(front and back))
        Lwall -> pointer that keep track of maximum height from the left wall with respect to the given heights
        Rwall -> pointer that keep track of maximum height from the right wall with respect to the given heights
        
        Intuition
        The main idea is that we essentially have to subtract the height from maximum possible height from the right or the left with the current height, the maximum height is updated when current height is greater than previous maximum height
        So essentially, we only operate over Left side or Right side at a time, but reference of the other side is always considered intuitively while computing the amount
        (eg 0,0,0,2 will give 0 , however if we have 0,0,0,0,2,1,0,1,1 -> then left amount will be taken into consideration, since we know there are elements on the right(to trap the water between two walls))
        """
        
        L,R = 0,len(height)-1
        Lwall,Rwall = 0,0
        amount = 0
        
        while L <= R: # L=R is also required because we can't really know if we have processed the element(taken into amt consideration already from right or left, since L and R are leading pointers over Lwall and Rwall)
            
            #process the elements from the left wall till the Rwall(if need be)
            if Lwall < Rwall:
                #store the maximum height of left wall
                if Lwall < height[L]:
                    Lwall = height[L]
                else:
                    #add to the amount difference of water from max left wall height and current element
                    amount+= Lwall - height[L]
                L+=1
            else:
                #store the maximum height of right wall
                if Rwall < height[R]:
                    Rwall = height[R]
                else:
                    #add to the amount difference of water from max right wall height and current element
                    amount+= Rwall - height[R]
                R-=1
        return amount
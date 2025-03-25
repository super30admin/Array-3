# Problem 1 : Trapping Rain Water
# Time Complexity : 
'''
Approach 1 - O(n) where n is the length of the height array
Approach 2 - O(n) where n is the length of the height array
'''
# Space Complexity : 
'''
Approach 1 - O(1)
Approach 2 - O(n) where n is the length of the height array
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
# Find Max and then search in left and right side of the maximum value
class Solution:
    def trap(self, height: List[int]) -> int:
        # get the length of the height array
        length = len(height)
        # define maxIndex to - 1 and maxValue to 0. These variables are used to store the maximum value in the array and index of that value
        maxIndex = -1
        maxValue = 0
        # loop through the array to find the maximum value and its index in the height array
        for i in range(length):
            if height[i] > maxValue:
                maxValue = height[i]
                maxIndex = i

        # find the water trap from left to max index
        # define index to 0, leftWindow to 0 and result to 0
        index = 0
        leftWindow = 0
        result = 0
        # loop from 0 to maxIndex
        while index < maxIndex:
            # if the leftWindow value is greater than the value at index position of height
            if leftWindow > height[index]:
                # calculate the result as sum of result and (difference between leftWindow and the value at index position in height array)
                result += leftWindow - height[index]
            else:
                # else set the leftWindow to the value at index position of height array
                leftWindow = height[index]
            # increment the index
            index += 1
        # set the index to (length-1)th position of the array
        index = length - 1
        # set the rightWindow to 0
        rightWindow = 0
        # loop from the end of the array to the maxInde ie right part of the maxIndex
        while index > maxIndex:
             # if the rightWindow value is greater than the value at index position of height
            if rightWindow > height[index]:
                # calculate the result as sum of result and (difference between rightWindow and the value at index position in height array)
                result += rightWindow - height[index]
            else:
                # else set the rightWindow to the value at index position of height array
                rightWindow = height[index]
            # decrement the index value
            index -= 1
        # return the result
        return result

# Using stack approach
from typing import List
class Solution:
    def trap(self, height: List[int]) -> int:
        # get the length of the height array
        length = len(height)
        # define result to 0
        result = 0
        # define stack for storing the index of the array
        stack = []
        # psuh -1 to stack
        stack.append(-1)
        # loop through the array
        for i in range(length):
            # while the top element is not -1 and the height at ith position is greater than the value at index which is at top of stack
            while stack[-1] != -1 and height[i] > height[stack[-1]]:
                # pop the top index from the stack
                popIndex = stack.pop()
                # if the second value of stack is -1 then break
                if stack[-1] == -1: break
                # set the rightWindow to the value of ith position in height array
                rightWindow = height[i]
                # set the leftWindow to the value of index which is at top of the stack
                leftWindow = height[stack[-1]]
                # calculate width as (i- value of top element of stack - 1)
                width = i - stack[-1] - 1
                # caculate the result as sum of result and (difference between minimum of rightWindow and leftWindow and value at popIndex of height) * width
                result += (min(rightWindow, leftWindow) - height[popIndex]) * width
            # push the ith value to stack
            stack.append(i)
        # finally return the result
        return result
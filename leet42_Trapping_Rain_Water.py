# Solution

# // Time Complexity : Approach1 O(N) - Need to check
#                      Approach2 O(N)
#                      Approach3 O(N)
# // Space Complexity : O(1) all approaches
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Approach1 - My own brute force approach is using two pointer approach with some edge cases
# Approach2 - Find the Max first, now come from left by updating the left wall, so that leftwall will be
# max quantity of water and actual will be leftwall subtract current wall height. Keep udpating the leftwall
# if we get higher wall before reaching the maximum. Once left half is done, perform the same from right
# side, considering right wall and travel till max height.
# Approach3 - Same as approach2 but achieving it in one pass, using four pointers, two for left wall and left pointer
# two for right and right pointer
# Approach4 - Monotonic stack, to be implemented 
# https://www.youtube.com/watch?v=ZEjyrZgNdJQ

# Approach 3
def trap(height):
    n = len(height)
    totalSum = 0
    leftWall = 0
    leftPoint = 1
    rightWall = n-1
    rightPoint = n-2

    while rightPoint>=leftPoint:
        if height[leftWall] < height[rightWall]:
            diff = height[leftWall] - height[leftPoint]

            if diff > 0:
                totalSum += diff
            
            if height[leftWall] <= height[leftPoint]:
                leftWall = leftPoint
            
            leftPoint += 1
        else:
            diff = height[rightWall] - height[rightPoint]
            if diff > 0:
                totalSum += diff
            
            if height[rightWall] <= height[rightPoint]:
                rightWall = rightPoint
            
            rightPoint -= 1
    
    return totalSum

# Approach2
# def trap(height):
#     totalSum = 0
#     n = len(height)

#     tempMax = 0
#     tempMaxI = 0

#     for i in range(n):
#         if height[i] > tempMax:
#             tempMax = height[i]
#             tempMaxI = i
    
#     i = 1
#     leftWall = height[0]
#     while i<tempMaxI:
#         diff = leftWall - height[i]
#         if diff > 0:
#             totalSum += diff
        
#         if leftWall < height[i]:
#             leftWall = height[i]
        
#         i += 1
    
#     i = n-2
#     rightWall = height[n-1]
#     while i>tempMaxI:
#         diff = rightWall - height[i]
#         if diff>0:
#             totalSum += diff
        
#         if rightWall<height[i]:
#             rightWall = height[i]
        
#         i -= 1
                    
#     return totalSum

# Approach1
# def returnSum(i,height,totalSum,tempCapacityi,tempj):
#     tempi = i+1
#     tempCapacity = height[tempCapacityi]

#     while tempi<tempj:
#         diff = tempCapacity - height[tempi]
#         if diff > 0:
#             totalSum += diff
#         tempi += 1
    
#     return totalSum

# def trap(height):
#     totalSum = 0
#     i = 0
#     n = len(height)

#     while i<n:
#         if height[i] == 0 or (i+1<n and height[i] < height[i+1]):
#             i += 1
#             continue
                    
#         j = i+2

#         tempMax = 0
#         tempI = 0
#         while j<n and height[i]>height[j]:
#             if height[j] > tempMax:
#                 tempMax = height[j]
#                 tempI = j
            
#             j += 1
        
#         if j < n and height[i] <= height[j]:
#             totalSum = returnSum(i,height,totalSum,i,j)
#             i = j
#         elif tempMax != 0:
#             totalSum = returnSum(i,height,totalSum,tempI,tempI)
#             i = tempI
#         else:
#             break
            
#     return totalSum

if __name__ == "__main__":
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    print(trap(height))
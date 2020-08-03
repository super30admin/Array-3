# Time Complexity : O()
# Space Complexity :O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# 1) Method 1 usign sort 
# Time = O(nlogn) | Space = O(1)
# class Solution:
#     def hIndex(self, citations):
#         if len(citations) == 0:
#             return 0 
#         citations.sort() # O(nlogn) times
#         n = len(citations)
#         for i in range(len(citations)):
#             diff = n - i 
#             if citations[i] >= diff:
#                 return n - i 
#         return 0 

# 2) Method 2 using Bucket sort:
#       Bucket sort add the elements larger than the size of the length of an array to the extra bucket. 
#       So all the larger elements will go to one single bucket.
# Time = O(n) | space = O(n)
class Solution:
    def hIndex(self, citations):
        if len(citations) == 0 :
            return 0 
        temp = [0 for _ in range(len(citations)+1)]
        
        n = len(citations)
        for i in range(len(citations)):
            if citations[i] > n:
                temp[n] += 1 
            else:
                temp[citations[i]] += 1 
        
        result = 0
        for i in range(len(temp)-1, -1, -1):
            result += temp[i]
            if result >= i:
                return i
        
        return -1
if __name__ == "__main__":
    s = Solution()
    print(s.hIndex([3,0,6,1,5]))
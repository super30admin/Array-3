# Solution

# // Time Complexity : O(N)
# // Space Complexity : O(N) - Array
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Approach is using buckets to hold number of papers with citations, find more in below link
# https://www.youtube.com/watch?v=ZEjyrZgNdJQ

def hIndex(citations):
    n = len(citations)

    arr = [0]*(n+1)

    for elem in citations:
        if elem >= n:
            arr[n] += 1
        else:
            arr[elem] += 1
    
    sum = 0
    for i in range(n,-1,-1):
        sum += arr[i]
        if sum >= i:
            return i

if __name__ == "__main__":
    citations = [3,0,6,1,5]
    # citations = [1,3,1]
    print(hIndex(citations))
class Solution:
    
    """
    Description
    
    Time Complexity: 
    - O(n log n) for Brute force (using a sorted array)
    - O(n) for optimized
    Space Complexity: 
    - O(1) for Brute Force
    - O(n) for bucket sort (Optimized)
    
    Approach: Using bucket sort (Special case)
    - realize maximum h-index cannot be larger than length of the given array, higher numbers ain't sorted
    - create bucket array with zeros with size length + 1
      + use indices of the bucket array to fill number of citations for values lower than size with 1
      + Add 1 to last index if the value is larger than size of the bucket array
    - iterate from end of the bucket array and return when the array index <= running sum
    """
    
    def hIndex(self, citations: List[int]) -> int:
        
        if citations == None or len(citations) == 0: return 0
        
        N = len(citations)
        bucket_array = [0]*(N + 1)
        for val in citations:
            if val < N:
                bucket_array[val] += 1
            else:
                bucket_array[N] += 1

        rSum = 0
        for i in range(N):
            rSum += bucket_array[N - i]
            if rSum >= N - i: return N - i
        
        return 0
                
    
    """ # BRUTE FORCE
    def hIndex(self, citations: List[int]) -> int:

        if citations == None or len(citations) == 0: return 0
        
        citations = sorted(citations)
        N = len(citations)
        for i in range(N):
            if citations[i] >= N - i: 
                return N - i
             
        return 0
    """

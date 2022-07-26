"""
M1 - sort and look for H index as we did previously. Wherever the value crosses the index, we have the position of H index

WHEREVER CITATIONS[i]> N-i--> we return N-i
TC = O(nlogn)

M2 -
Bucket Sort : We are only concerned about a few elements in a particular range. I this case we are only looking for 
elements < len(array)
i.e. order of larger elements doesnt matter

For an array of length n, we create a buckets array for indices 0 to n and we use the (n)th bucket for all the elements >=n
Anything >= n, will be put in the last bucket
Then we count the number of papers > that particular citation(i) till we find the index where it matches

"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        buckets = [0]*(n+1)
        
        for i in range(len(citations)):
            if citations[i]>=len(citations):
                buckets[n]+=1
            else:
                buckets[citations[i]]+=1
        count = 0        
        for i in range(len(buckets)-1,-1,-1):
            count+= buckets[i]
            if count>=i:
                return i
            
            
            
            
            
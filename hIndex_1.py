'''
Time Complexity: 0(n)
Space Complexity: 0(n+1) -- bucketSort
Run on leetCode: Yes
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        # create a bucket-list
        bucketList = [0]*(len(citations)+1)
        
        # update the bucketList accordingly
        for c in citations:
            if c < len(bucketList)-1:
                bucketList[c] = bucketList[c]+1
            else:
                bucketList[-1] =  bucketList[-1] +1
        
        # iterate the bucketList from behind and return the hIndex where sum == index
        # stop the iteration when sum > index
        
        print("BucketList is:\t",bucketList)
        print("Length of bucketList:\t",len(bucketList))
        
        calSum = 0
        for i in range(len(bucketList)-1,-1,-1):
            
            calSum += bucketList[i]
            print(f"i is {i} and calSum is {calSum}")
            
            if calSum == i:
                # I have my hIndex
                return i
            
            elif calSum > i:
                # My hIndex position ahead
                return i
            
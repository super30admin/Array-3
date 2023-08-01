#Time complexity is: O(n)
#Space complexity is: O(n)
#No issues faced while coding
#CPde ran successfully on leetcode
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        #We will take length of the citations array
        n=len(citations)
        #We will create a bucket of length n+1
        buckets=[0 for i in range(n+1)]
        #We will be iterating through citations array
        for i in range(n):
            #If the value at index i is greater than or equal to n, we will add 1 to the nth index
            if(citations[i]>=n):
                buckets[n]+=1
            #Else we will add 1 to the respective index
            else:
                buckets[citations[i]]+=1
        sum=0
        #We will iterate through buckets array
        for i in range(n,-1,-1):
            #We will be adding value in buckets[i] to the sum
            sum+=buckets[i]
            #If sum value is greater than or equal to i, we will return i
            if(sum>=i):
                return i
        return 9999
        
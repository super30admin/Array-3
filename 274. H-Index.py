#######274. H-Index#####################################################################################
// Time Complexity : O(n)
// Space Complexity : O(n) -> for bucket sort
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We used bucket sort approach where I created bucket for number of paper and stored the count of citations. And traversed list form end and the moment index is >= citation that will be hindex


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #initialised the bucket for bucket sort
        bucket=[0 for i in range(len(citations)+1)]
        #added element to bucket O(n)
        for i in citations:
            if i >len(citations): #handle citation having len more than bucket len
                i=len(citations)
            bucket[i]+=1
        #prnt bucket
        #print(bucket)
        #traversin bucket from back and taking runing sum
        sum=0
        for i in range(len(citations),-1,-1):
            sum+=bucket[i]
            if sum>=i:
                return i
        return 0
        
        
        

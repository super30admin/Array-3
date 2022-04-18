// Brute force 
// Time Complexity  : O(n*n) 
// Space Complexity : O(k)  maximum number of h index's possible
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this    : No

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        n=len(citations)
        result=[]
      
        for h in range(n+1,-1,-1):
            
            c1,c2=0,0
            
            for j in citations:
                
                if j >= h:
                    c1=c1+1
                elif j<=h:
                    c2=c2+1
                    
            if c1>= h and c2 <= n-h:
                result.append(h)
                       
        return max(result)
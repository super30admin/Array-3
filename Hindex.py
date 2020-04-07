# -*- coding: utf-8 -*-
"""
Created on Tue Apr  7 00:53:31 2020

@author: aggar
"""

#Problem 2 H index
# TC - O(n) 
# SC - O(n)
# Yes, this solution worked. First make a bucket of size 1 greater than size of given input. Now travers ethe input and update the update.
#take running sum and whrn index <= runiing sum that indes is our answer
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        bucket = [0]*(len(citations)+1)
        for i in citations:
            if i > len(citations):
                i= len(citations)
            bucket[i] += 1
        rsum = 0
        index = len(bucket)-1
        while True:
            rsum += bucket[index]
            if index <= rsum:
                break
            index -= 1
        return index
        
          
            
            
        
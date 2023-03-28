#All TC on leetcode passed


class Solution:
    def hIndex(self, citations: List[int]) -> int:

         #We use bucket sort. The possible values of citations are 0 to n+1. We create an array of 0 to n+1 and store the no. of papers with citation equal to i. Then we traverse this new possible citation array in reverse and check if at any point the no. of papers is greater than or equal to i(citation val) then thats the H-index
        #Time complexity - O(n) - 
        #Space complexity - O(1)
        n = len(citations)
        possibleCitationVals = [0]*(n+1)

        for i in range(n):
            if citations[i]>=n:
                possibleCitationVals[n]+=1
            else:
                possibleCitationVals[citations[i]]+=1
        
        sumVal = 0
        for i in range(n, -1, -1):
            sumVal += possibleCitationVals[i]
            if sumVal>=i:
                return i
        return -1



#---------------------------------------OR------------------------------------------


         #Here we firstly sort the array and then for every ith entry we check if (n-i) is lesser than or equal to cur citation. If yes then we return (n-i) as h index.
        #Here (n-i) denotes no. of paper with citation = citation[i]
        #Time complexity - O(nlogn) - due to sorting
        #Space complexity - O(1)
        citations.sort()
        n = len(citations)
        for i in range(n):
            if n-i<=citations[i]:
                return n-i
        
        return 0  #for [0] case we shd return 0 
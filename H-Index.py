// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
For this problem we have to create another array which contains the frequency of the numbers present in the array.Then we run a running sum from the end to the start.If the index of the new array is less than or equal to the running sum value then we return that index.

# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if citations==None or len(citations)==0:
            return 0
            #create a new list with a bigger length (i.e len(citations)+1)
        list1=[0 for i in range(len(citations)+1)]
        n=len(list1)-1
        # print(list1)
        for i in range(len(citations)):
            # print(i)
            #If the citation value is greater than the length of the input array then include it in the last element array
            if citations[i]>=len(citations):
                list1[n]=list1[n]+1
            else:
                list1[citations[i]]=list1[citations[i]]+1
        total=0
        for i in range(len(list1)-1,-1,-1):
            #calculating running sum on the new array
            total=total+list1[i]
            if i<=total:
                return i
        
class Solution:
    def trap(self, height: List[int]) -> int:

        # #2 pointer - TC O(2n) and SC O(1)

        #Find max in array, then move from left till this max index and then right till this max index.
        # Idea is in the left part, we are using the max as our right wall for all calulations, so just see if 
        #1. if left wall is bigger than heieght[l] add difference to res
        #2. else update my lw to curr
        #Idea is in the right part, we are using the max as our left wall for all calulations, so just see if 
        #1. if right wall is bigger than heieght[r] add difference to res
        #2. else update my rw to curr

        # n=len(height)
        # maxh=0
        # maxindex=-1
        # for i in range(n): #then get max in array to get rightmax
        #     if height[i]>maxh:
        #         maxh=height[i]
        #         maxindex=i 
        # l=0
        # lw=0
        # res=0
        # while l<maxindex: #from left go till rightmax
        #     if lw>height[l]: #if left wall is bigger than heieght[l] add difference to res
        #         res+=lw-height[l]
        #     else: #else update my lw
        #         lw=height[l]
        #     l+=1
        # r=n-1
        # rw=0
        # while r>maxindex: #start from right and go till rightmax
        #     if rw>height[r]:  #if right wall is bigger than heieght[r] add difference to res
        #         res+=rw-height[r]
        #     else:  #else update my lw
        #         rw=height[r]
        #     r-=1
        # return res

        #Improved 2pointer - O(n) for TC and O(1) SC

        #Now, idea here, is we don't need a max wall. 
        #Lets, use rw and lw as our walls for all calculation. 
        #If lw<=rw then process left,
        #here, check if lw is bigger than curr, if yes, add the difference to res
        #else update lw to curr

        #If lw>rw then process right,
        #here, check if rw is bigger than curr, if yes, add the difference to res
        #else update rw to curr
        l=0
        lw=0
        n=len(height)
        r=n-1
        rw=0
        res=0

        while l<=r:
            if lw<=rw:
                #right is bigger so process left
                if lw>height[l]:
                    res+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                #left is bigger so process right
                if rw>height[r]:
                    res+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return res






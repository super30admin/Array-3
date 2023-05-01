class Solution:
    # Find max left and max right of each entry and current height - the min of both of them gives the water that will be trapped in that building
    #TC-O(N),SC-O(N)
    def trap(self, height: List[int]) -> int:
        # left =[0]
        # right = [0]
        # for i in range(1,len(height)):
        #     left.append(max(left[-1],height[i-1]))
        # for j in range(len(height)-2,-1,-1):
        #     right.append(max(right[-1],height[j+1]))
        # right.reverse()
        # su = []
        # for i in range(len(height)):
        #     m = min(left[i],right[i])
        #     if m > height[i]:
        #         su.append(m-height[i])
        # return sum(su)
        # find max of the heights, for all left to it, it acts as right barrier and for all right to it max acts as left barrier, 

        #TC-O(n),SC-O(1)
        # n=len(height)
        # #find max
        # maxi=0
        # maxn = height[0]
        # for i in range(n):
        #     if height[i]>maxn:
        #         maxn=height[i]
        #         maxi=i
        # left = 0
        # curr = 0
        # trap=0
        # # for all on left of maxi, water trapped will be its max on the left side - its height 
        # while(curr<maxi):
        #     if(height[curr]<height[left]):
        #         trap+=height[left]-height[curr]
        #     else:
        #         left=curr
        #     curr+=1
        # curr=n-1
        # left=n-1
        # while(curr>=maxi):
        #     if(height[left]>height[curr]):
        #         trap+=height[left]-height[curr]
        #     else:
        #         left=curr
        #     curr-=1
        # return trap

        #instead of finding max, with assurance of greater height n the other side, we can trap water n lower side, to trap water we need to find max on its side, so we keep two pointers and find trap when we find lw>l since lw is the max on the left side
        # take four pointers lw,l,rw,r
        #lw acts as left in prev sol, l is == curr 
        #similarly rw==left, r==curr
        #process the side whose wall is lower because there is an assurance that since max is on other side, water can be trapped on the lower side,if wall is less that curr, then move wall to curr
        #TC-O(n),SC-O(1)
        n=len(height)
        lw=0
        l=0
        rw=n-1
        r=n-1
        trap=0
        while(l<=r):
            if(height[lw]<height[rw]):
                # process left since assurance is on the right
                if(height[lw]<height[l]):
                    # cant trap water
                    lw=l
                    
                else:
                    trap+=height[lw]-height[l]
                l+=1
            else:
                if(height[rw]<height[r]):
                    # cant trap water
                    rw=r
                    
                else:
                    trap+=height[rw]-height[r]
                r-=1
        return trap



        





        
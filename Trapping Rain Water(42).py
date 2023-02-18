class Solution:
    # T.C. = O(N)
    # S.C. = O(1)
    # Here we use a 2-pointer approach
    # we move the left and right pointers when we have a similar higher building on the other side
    # and we store water once we are standing on a building that is smaller than the highest building
    # on the same side
    def trap(self, height: List[int]) -> int:
        if((height is None) or (len(height)<3)):
            return 0

        lmax = 0 #highest building on left
        rmax = 0 #highest building on left
        left = 0
        right = len(height)-1
        res = 0

        while left<right:
            # if the height of left building is smaller or == the one on the right end
            if height[left]<=height[right]:
                # if the current building is higher than the highest on left, we can't store
                # any water there, so we update the max height
                if height[left]>=lmax:
                    lmax = height[left]
                # if the current building is smaller than the highest on left, we can store water there
                # since we have have already checked for the existence of a higher building on both sides
                else:
                    res += lmax - height[left]
                left+=1
            else:
                if height[right]>=rmax:
                    rmax = height[right]
                else:
                    res += rmax - height[right]
                right-=1
        return res


        # T.C. = O(N) 2N actually
        # S.C. = O(N) 2N actually
        # Here at every point we first preprocess every node
        # that is we use 2 arrays to store the max values on the left and max values on the right
        # the answer is the minimum of the left and right height + the current height

        # if((height is None) or (len(height)<3)):
        #     return 0
        # size = len(height)
        # maxl = [0 for _ in range(size)]
        # maxl[0] = height[0]
        # maxr = [0 for _ in range(size)]
        # maxr[size-1] = height[size-1]

        # for i in range(1,size):
        #     maxl[i] = max(maxl[i-1],height[i])
        #     maxr[size-i-1] = max(maxr[size-i],height[size-i-1])

        # print(maxl)
        # print(maxr)

        # ans = 0

        # for x in range(size):
        #     ans += min(maxl[x],maxr[x]) - height[x]

        # return ans

class Solution:
    def trap(self, height: List[int]) -> int:
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        l = deque([0])
        max1=0
        for i in range(0,len(height)):
            if(height[i]>max1):
                max1 = height[i]
            l.append(max1)
        
        
        r = deque([0])
        max1=0
        for i in range(len(height)-1,-1,-1):
            if(height[i]>max1):
                max1 = height[i]
            r.appendleft(max1)
        l.popleft()
        r.popleft()
        
        c=0
        for i in range(0,len(height)):
            if(l[i]>0 and r[i]>0):
                if(height[i]<min(l[i],r[i])):
                    c += min(l[i],r[i]) - height[i]
        return c

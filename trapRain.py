class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)<3:
            return 0
        st=[]
        water=0
        st.append(0)

        for idx in range(1, len(height)):
                while st and height[st[-1]]<height[idx]:
                    popped=st.pop()
                    if st:
                        water+=(min(height[st[-1]], height[idx])-height[popped])*(idx-st[-1]-1)
                    else:
                        break
            
                st.append(idx)
        
        return water


                

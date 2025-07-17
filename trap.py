# TimeComplexity:O(n)
# SpaceComplexity:constant
# Approach:
# Bruteforce: for each point go left and right max then add water O(n^2,1)
# l,r: have l,r array where l[i] says max val untill i when moved form 0 , same with r but from end O(n,n)
# MaxPointer: instead of 2 arrays, have single max pointer which ats as wall every time take left wall if cuuval >lw (you need 2 walls right wall is fixed untill max, change left wall),O(N)
# 4 pointers: Instead of 2 traversals , have two left and right pointers and 2 walls based on lw and rw move lefrt and right pointers .so update wall height if currval is greater than lw,O(N)
# MonoStack: Use monotonic stack for this add untill top is smaller than currval ,once you encounter a small val top acts as wall O(n,n)









###############################
# use mono stack
##############################



class Solution:
    def trap(self, height: List[int]) -> int:
        st = []
        water = 0

        for i in range(len(height)):
            while st and height[i] > height[st[-1]]:
                pop = st.pop()

                if not st:
                    break  # No left boundary

                # Calculate distance between left and right boundary
                w = i - st[-1] - 1
                h = min(height[i], height[st[-1]]) - height[pop]
                water += w * h

            st.append(i)

        return water
#############################
# have 2 pointers and 2 walls
############################

class Solution:
    def trap(self, height: List[int]) -> int:
        # have left and ight pointer fix pointer which is max then move another pointer
        l,r=0,len(height)-1
        lw,rw=0,0
        water=0
#maintain 4 variables lw,l,rw,r
        while(l<=r and r< len(height)):
            if lw<rw:
                if height[l]<lw:
                    water+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if height[r]<rw:
                    water+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return water

            

        

##############################
# Have one single max + l to m , r  to m
#############################
class Solution:
    def trap(self, height: List[int]) -> int:
        #find max in an array them from let to max and them end to max
        #maintain left wall and right wall
        curr_max,maxidx=height[0],0
        for i in range(1,len(height)):
            if curr_max<height[i]:
                curr_max=height[i]
                maxidx=i
        water=0
        lw=height[0]
        for i in range(1,maxidx):
            if height[i]<lw:
                water += lw-height[i]
            else:
                lw=height[i]

        #going from end to maxidx
        rw= height[len(height)-1]
        for i in range(len(height)-2,maxidx,-1):
            if height[i]<rw:
                water+= rw- height[i]
            else:
                rw=height[i]
        return water

        

###############################
#Maintian both left max and right max
###############################


class Solution:
    def trap(self, height: List[int]) -> int:
        #maintain left and right max array
        l,r=[],[]
        #left max
        curr_max=height[0]
        l.append(curr_max)
        for i in range(1,len(height)):
            if height[i]>curr_max:
                curr_max=height[i]
            l.append(curr_max)

        height2=height[::-1]
        curr_max=height2[0]
        r.append(curr_max)
        for i in range(1,len(height2)):
            if height2[i]>curr_max:
                curr_max=height2[i]
            r.append(curr_max)
        water=0
        r=r[::-1]
        print(l)
        print(r)
        print(height[1:])
        for i in range(1,len(height)-1):
            water+= min(l[i],r[i])-height[i]
        return water

        

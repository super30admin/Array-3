#Time complexity: O(n) (one pass!!)
#Space complexity O(1)
'''
For an array of length n,starting from an index i, we can easily prove that the cycle for 
the values (i+k)%n (we move to the right k elements each time) is of length n/gcd(n,k)
(before it comes back to the starting index). So if we choose well gcd(n,k) starting indices such
that the cycle don't overlap, we would have traversed n elements (n/gcd(n,k) per cycles, gcd(n,k) cycles).
Now we can prove by contradiction that for any i,j such that i!=j and 0<=i,j<gcd(n,k) , the cycles 
are all mutually exclusives. So if we go through the cycles for each i between 0 and gcd(n,k), we would've
traversed the whole array only one time.

Now given that information, since the indices (i+k)%n are exactly where we want to place our elements in
the rotated array, we can go through the cycles, replacing the elements while keeping in memory the present
element (so we can replace the next one). If we reach the end of a cycle, we just iterate to the next index
since we know that for each elements between 0<i,j<gcd(n,k), the cycles are mutually exclusive.

'''
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        swaped,start_index,k=0,0,k%len(nums)
        while swaped<len(nums):
            i=start_index
            prev=nums[i]
            while True:
                i=(i+k)%len(nums)
                temp=nums[i]
                nums[i]=prev
                prev=temp
                swaped+=1
                if i==start_index: break
            start_index+=1

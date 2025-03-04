class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] hindex = new int[n+1];

        for (int i=0;i<n;i++) {
            if (citations[i] > (hindex.length-1)) {
                hindex[n]++;
            } else {
                hindex[citations[i]]++;
            }
        }
        int sum=0;
        for (int i=hindex.length-1; i>=0;i--) {
            sum = hindex[i] + sum;
            if(sum>=i) {
                return i;
            }
        }
        return 83831;
    }
}
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lw = 0;
        int rw=0;
        int l =0;
        int r = n-1;
        int total =0;

        while (l<=r) {
            if (lw<=rw) {
                if (height[l] < lw) {
                    total = total + (lw-height[l]);
                }else {
                    lw=height[l];
                }
                l++;
            } else {
                if (height[r]<rw) {
                    total = total + (rw-height[r]);
                } else {
                    rw=height[r];
                }
                r--;
            }
        }
        return total;
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l<r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums , int l, int r) {
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r] = temp;
    }
}

//Problem 1 Trap Rain Water
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// every puddle has a left wall > height of puddle and right wall> height of puddle. only then the puddle will trap water. iteratively check for left and right walls and change their value when we found a bigger wall as compared to current one.
class Solution {
    //O(2n) O(1)
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        int n=height.length;
        // int max=0, maxIdx=-1;
        // for(int i=0;i<n;i++){
        //     if(height[i]>max){
        //         max=height[i];
        //         maxIdx=i;
        //     }
        // }
        // int res=0;
        // int left=0, leftwheight=0, right=n-1, rightWall=0;

        // while(left<maxIdx){
        //     if(leftwheight>height[left]){
        //         res += leftwheight-height[left];
        //     }else{
        //         leftwheight=height[left];
        //     }
        //     left++;
        // }

        // while(right>maxIdx){
        //     if(rightWall>height[right]){
        //         res += rightWall-height[right];
        //     }else{
        //         rightWall=height[right];
        //     }
        //     right--;
        // }

        // return res;


        //one pass solution O(n) O(1)
        int res=0;
        int left=0, leftwall=0, right=n-1, rightwall=0;

        while(left<=right){
            if(leftwall<=rightwall){
                //if left wall is greater, process rightside
                if(leftwall>height[left]){
                    res += leftwall-height[left];
                }else{
                    leftwall=height[left];
                }
                left++;
            }else{
                if(rightwall>height[right]){
                    res += rightwall-height[right];
                }else{
                    rightwall=height[right];
                }
                right--;
            }
        }
        return res;

    }
}

//Problem 2 H Index 2
// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//check where n-h is <= h i.e where difference is less than equal to citations[i] also when pointers cross each other, means we have surely found our h index
class Solution {
    //O(logn) O(1)
    public int hIndex(int[] citations) {
        int n=citations.length;

        //linear Solution
        // for(int i=0;i<n;i++){
        //     int dif=n-i;

        //     if(dif<=citations[i])
        //         return dif;
        // }
        // return 0;

        //binary search 
        int low=0, r=n-1;
        while(low<= r){
            int mid=low+(r-low)/2;
            int diff=n-mid;
            if(citations[mid]== diff){
                return diff;
            }else if(citations[mid]>diff)
                r=mid-1;
            else
                low=mid+1;
        }
        return n-low;
    }
}

//Problem 2 Rotate array by k places
// Time Complexity :O(2n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// there are multiple ways of doing it. 
//first reverse all 1 to n-k elements then reverse remaining k elements. now reverse the whole array. we will find an array rotated by k places to right.
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0) return;
        
        int n=nums.length;
        k=k%n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0,n-1);
    }
    private void reverse(int[] arr, int l, int r){
        while(l<r){
            swap(arr, l, r);
            l++;
            r--;
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
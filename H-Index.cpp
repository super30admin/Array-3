// Time Complexity : O(log(n) for traversing throught the array with binary search apparoach.
// Space Complexity : O(1) we are not creating any space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        
        sort(citations.begin(), citations.end());
         int left = 0;
        int size = citations.size();
        int right = size -1;
        
        // we will do binary search on the citations.
        // once we hit out mid == citations that means we have atleast h papers with h citations.
        
        // otherwise we travel left or right side of mid depending on citation> test_index
        while ( left <= right){
            int mid = left + (right - left )/2;
            
            if(citations[mid] == (size - mid)){
                return size - mid;
            } else if( citations[mid] < (size-mid)){
                left = mid +1;
            } else{
                right = mid -1;
            }
        }
        
        return size - left;
    }
};
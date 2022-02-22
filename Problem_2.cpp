/**
 * Time Complexity:
 * O(2n) where n is the size of the given array.
 * 
 */

/**
 * Space Complexity:
 * O(m) where n is the size of the bucket sort array
 * 
 */

/**
 * Approach:
 * This problem is similar to the other h-index problem. The 
 * only difference is that here the given array is not sorted.
 * We can sort the array and then solve the problem in similar 
 * manner. But that will result in time complexity of O(nlogn)
 * 
 * To acheive O(n) we observed that if the citations at some
 * index is greater that the size of the given array, it does
 * not need to include in the sorting. We can simply create a
 * counting sort or bucket sort because we are sorting
 * within a given range.
 * 
 * Now, after that we just start from the end of the array
 * and see where the sum value becomes equal to or greater
 * than the index. This was done in another h index problem too.
 * 
 */

// The code ran perfectly on leetcode

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> bucket(n+1,0);
        for(int i = 0; i<n; i++){
            if(citations[i] < n){
                bucket[citations[i]]++; 
            } else {
                bucket[n]++;
            }
        }
        
        int sum  = 0;
        for(int i =n ; i>= 0; i--){
            sum +=bucket[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
};
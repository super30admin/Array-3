// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this by sorting the array
// Then we iterate through the sorted array 
// we calculate the diff at each index as n-i
// the point where ith element is greater than diff 
// we return it as result

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int diff = n - i;
            if (citations[i] >= diff) {
                return diff;
            }
        }
        return 0;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this by using counting sort
// We create new result array
// Then we iterate over this result array from back
// all the while adding it to the sum
// if at any point sum is greater than i we return i as the result

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) {
                result[n]++;
            } else {
                result[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum = sum + result[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
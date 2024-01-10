//  Time Complexity: O(n)
//  Space Complexity: O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        for(int i=0; i< n; i++){
            if(citations[i] >= n- i){
                return n - i;
            }
        }
        return 0;
    }
}

//  Time Complexity: O(log(n))
//  Space Complexity: O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(citations[mid] ==  n - mid) return n-mid;
            else if(citations[mid] > n - mid) high = mid -1;
            else low = mid + 1;
        }
        return n - low;
    }
}
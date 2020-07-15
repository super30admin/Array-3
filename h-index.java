//APPROACH 1: brute force
//time complexity O(nlog n) because we sort the array first
//space complexity O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= n-i) return n-i;
        }
        return 0;
    }
}

//APPRAOCH 2: Using bucket approach i.e. we will create a buckets
//array and store all the papers with citations greater than the
//size of the array in the last index of the buckets array.
//time complexity O(2n)
//space complexity O(n+1) since the array we created has one more element

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i = 0; i < citations.length; i++){
            buckets[Math.min(citations[i], n)]++;
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += buckets[i];
            if(sum >= i) return i;
        }
        return Integer.MIN_VALUE;
    }
}

//bruteforce
//time o(nlogn)
//space o(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        //sort the array
        Arrays.sort(citations);
        for(int i=0; i<n; i++) {
            if(citations[i] >= n-i) {
                return n-i;
            }
        }
        return 0;
    }
}

//time o(n)
//space o(n)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] arr = new int[n+1];
        
        for(int i=0; i<n; i++) {
            if(citations[i] >= n) {
                arr[n]++;
                continue;
            }
            arr[citations[i]]++;
        }
        int sum = 0;
        for(int i=n; i>=0; i--) {
            sum = sum + arr[i];
            if(sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
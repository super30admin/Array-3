class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        // using sorting which takes nlog TC
        // int n = citations.length;
        // Arrays.sort(citations);
        // for(int i = 0; i < n; i++) {
        //     if(citations[i] >= (n - i)) {
        //         return n - i;
        //     }
        // }
        // return 0;

        // using bucket sort
        int n = citations.length;
        int[] result = new int[n + 1];
        for(int i = 0; i < n; i++) {
            int index = citations[i];
            if(index > n) {
                result[n]++;
            } else {
                result[index]++;
            }
        }
        int sum = 0;
        for(int i = n; i >= 0; i--) {
            sum = sum + result[i];
            if(sum >= i) {
                return i;
            }
        }
        return 0;
    }
}

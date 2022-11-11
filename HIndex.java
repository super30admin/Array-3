//Time complexity : O(n)
//Space complexity : O(n)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int n = citations.length;
        int[] bucket = new int[n+1];

        for (int i=0; i < n; i++) {
            if (citations[i
                    ] <n) {
                bucket[citations[i]]++;
            } else {
                bucket[n]++;
            }
        }

        int rSum=0;
        for (int i=n; i >=0; i--) {
            rSum += bucket[i];
            if(rSum >=i) {
                return i;
            }
        }

        return 0;
    }
}

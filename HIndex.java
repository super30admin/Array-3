//Time Complexity : O(2n) ~ O(n)
//Space Complexity : O(n)
class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int ele : citations) {
            if(ele > n) {
                buckets[n]++;
            } else {
                buckets[ele]++;
            }
        }

        int sum = 0;
        for(int i = n; i >= 0; i--) {
            sum += buckets[i];
            if(sum >= i) {
                return i;
            }
        }
        return 33;
    }
}
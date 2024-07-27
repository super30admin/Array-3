//time - O(n), space - O(n) - bucket sort approach
class HIndex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] result = new int[n+1];

        for(int i = 0; i < n; i++) {
            int index = citations[i];
            if(index < n) {
                result[index]++;
            } else {
                result[n-1]++;
            }
        }

        int sum = 0;
        for(int i=n; i>=0; i--) {
            sum += result[i];
            if(sum >= i) {
                return i;
            }
        }

        return 0;
    }
}

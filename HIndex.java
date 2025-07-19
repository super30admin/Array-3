class Solution {
    public int hIndex(int[] citations) {
        int[] arr = new int[citations.length+1];

        for(int c : citations){
            if(c>citations.length) arr[citations.length]++;
            else arr[c] ++;
        }
        int total =0;
        for(int i=citations.length ;i>=0; i--){
            total+=arr[i];

            if(total>=i) return i;

        }

        return 0;

    }

    public int hIndex_bruteForce(int[] citations) {
x
        int citation = citations.length;
        int result = 0;
        while (citation > 0) {
            int hIdx = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= citation) {
                    hIdx++;
                }
            }

            if (hIdx >= citation) {
                result = citation;
                break;
            }
            citation--;
        }

        return result;

    }
}
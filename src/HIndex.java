// 0 1 3 5 6 
// 5 4 3 2 1 [5 papers have atleast 0 citations, 4 papers have atleast 1 citation and likewise]
// TC: O(nlogn)
// SC: O(1)
class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int i=n;i>=1;i--) {
            if(i <= citations[n-i])
                return i;
        }
        return 0;
    }
}

// TC: O(n)
// SC: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] countArr = new int[n+1];
        for(int citation : citations) {
            if(citation >= n) countArr[n] += 1;
            else countArr[citation] += 1;
        }

        int total = 0;
        for(int i=n;i>=0;i--) {
            total+= countArr[i];
            if(total >= i) return i;
        }
        return 0;
    }
}
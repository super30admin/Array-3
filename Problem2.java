
// Brute Force Solution
// Time Complexity - O(nlogn+n) where n is the length of the citations array. nlogn for sorting the array and n for traversing through the sorted array to find the h-index
// Space Complexity  - O(1)
// This solution worked on LeetCode

// Brute Force
class Solution {
    public int hIndex(int[] citations) {
         if(citations == null || citations.length ==0)  return 0;
        Arrays.sort(citations);
        int citation =0;
        int index = citations.length-1;
        while( index >=0 && citations[index] > citation){
            index--;
            citation++;
        }
        return citation;
    }
}

// Optimized Solution
// Time Complexity - O(n)
// Space Complexity - O(n)
// This solution worked on LeetCode

// This is O(n) time Complexity so better time than the brute force solution. In this solution we are using a topological array to store the number of times the index value element has ooccurred in the citations array which is the number of papers that has the citation equal to or greater than the index. If the number is greater than the index store the count at the last index position. This is the purpose the topological array size is n+1 so the last index can be used for such elements. The sum variable will then be used to maintain the count of publications. The topological array will be traversed from the last index and sum will be calculated. If the sum becomes greater than or equal to the index that will give the h-index as index which is the most 'index' number of papers with atleast 'index' number of citations.

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0)  return 0;
        int n = citations.length;
        int[] num = new int[n+1];
        for(int i=0;i< n;i++){
            num[Math.min(n,citations[i])]++;
        }
        int sum =0;
        for(int index = n; index >=0;index--){
            sum += num[index];
            if(sum >= index)    return index;
        }
        return -1;
    }
}

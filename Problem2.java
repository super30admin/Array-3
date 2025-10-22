/*
274. H-Index
Ran on leetcode: Yes
TC: O(n)
SC: O(n)
Bucket sort according to the number of papers, each index represent the number of citiations and its value is the number of papers with that many citations, we start from last index of the buckets and collect the sum if sum of papers is greater than or equal to citation return h index
*/

class Solution {
    public int hIndex(int[] citations) {
        
        int noOfPapers = citations.length;
        int[] papers = new int[noOfPapers + 1];

        for(int citation: citations){ // frequncy bucket for all the papers, index is citation and value is the number of papers
            if(citation > noOfPapers){
                papers[noOfPapers]++;
            } else {
                papers[citation]++;
            }
        }
        int sum = 0;
        for(int i = noOfPapers; i >= 0; i--){ // Start from last index and when number of papers >= citation return h index
            sum += papers[i];
            if(sum >= i){
                return i;
            }
        }

        return 0;
    }
}
/*
* Approach1: Sort the array and apply the concept of H-index2 here
Approach 2: 
    - As we know the max val of h index is going to be length of n, so we can use that to get a solution in linear time
    - first pass: So idea is to use bucket sort and add the number of papers that has citations = that index
    - second pass: go through the bucket array and you can compare number of papers >= number of citations
- TC: O(n) -> its actually 2n -> one for iterating the citations array and another one to iterate through the buckets array but 2 doesnt matter so its O(n)
- SC: O(n) -> extra space used to do bucket sort
 */
class Solution {
    public int hIndex(int[] citations) {
        //bucket array to store the freq of papers where index will act like citations and element will act like papers
        int[] bucket = new int[citations.length + 1];
        int papers = 0;
        //go through citations array to get the citation for each paper
        for(int i = 0; i < citations.length; i++){
            // if the citation for a particular paper falls within the range of bucket, we increment the citation index by 1 else anything greater than the bucket size, the number of citations doesnt so we increment the value of papers in the max citation possible 
            if(citations[i] < bucket.length)
                bucket[citations[i]] += 1;
            else
                bucket[citations.length] += 1;
        }

        // iterate through the bucket array, check when the equality for number of papers >= number of citations and return citations else return 0
        for(int citation = bucket.length - 1; citation >= 0; citation--){
            papers += bucket[citation]; 
            if(papers >= citation)
                return citation;
        }
        return 0;
    }
}
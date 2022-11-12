// ## Problem2 H-Index (https://leetcode.com/problems/h-index/)

// Sort array
// TC: O(n log n) 
// SC:O(1)

// Counting sort - Based on the fact that h index is between 0 and n (both including)
// TC: O(n) 
// SC:O(n)

// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function (citations) {
    if (citations === null || citations.length === 0)
        return 0;

    // // Sort array
    // // TC: O(n log n) SC:O(1)
    // citations.sort((a,b)=>a-b);
    // let n = citations.length;
    // for(let i=0; i<n; i++){
    //     let diff = n-i;
    //     if(citations[i] >= diff)
    //         return diff;
    // }

    // Counting sort - Based on the fact that h index is between 0 and n (both including)
    // TC: O(n) SC:O(n)
    let n = citations.length;
    let occurence = new Array(n + 1);
    occurence.fill(0);
    for (let i = 0; i < n; i++) {
        // If citations are more than n, add 1 to citation[n]
        if (citations[i] > n) {
            occurence[n]++;
        } else {
            // Else increment the index
            occurence[citations[i]]++;
        }
    }
    let rsum = 0;
    for (let i = n; i >= 0; i--) {
        // Calculate rsum from right
        rsum += occurence[i];
        // If number of papers(rsum) is more or equal to i, i is the hindex
        if (rsum >= i)
            return i;
    }
    return 0;
};

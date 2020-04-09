// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {
    if (!citations || !citations.length) return 0;
    
    const buckets = new Array(citations.length + 1).fill(0);
    for (const citation of citations) {
        if (citation > buckets.length - 1) {
            buckets[buckets.length - 1]++;
        } else buckets[citation]++;
    }

    let rSum = 0;
    for (let i = buckets.length - 1; i >= 0; i--) {
        rSum += buckets[i];
        if (i <= rSum) return i;
    }
};

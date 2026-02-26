/**
We bucket how many papers have exactly i citations (and group all ≥ n together), since h-index can never exceed total number of papers.
Then we iterate from highest citation count downwards, accumulating how many papers have "at least 'i' citations".
The first 'i' where the accumulated count ≥ 'i' is the h-index, because that means at least 'i' papers have '≥ i' citations.
T.C: O(n)
S.C: O(n)
 */
var hIndex = function (citations) {
    let n = citations.length;

    // create buckets
    let bucketsArr = new Array(n + 1).fill(0);

    // iterate over citations and fill the buckets as per their frequency
    for (let i = 0; i < n; i++) {
        const currFreq = citations[i];
        if (currFreq >= n) {
            bucketsArr[n]++;
        } else {
            bucketsArr[currFreq]++
        }
    }

    let count = 0;
    for (let i = n; i >= 0; i--) {
        count += bucketsArr[i];
        if (count >= i) return i;
    }

};
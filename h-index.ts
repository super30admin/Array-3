// Time complexity - O(nlog(n)), n number of citations
// Space complexity - O(1)
function hIndex(citations: number[]): number {
	let result = 0;
	citations.sort((a, b) => a - b);
	let n = citations.length;
	let l = 0;
	let r = n - 1;

	while (l <= r) {
		const mid = Math.floor((l + r) / 2);

		// possible h-index: number of papers from mid to n-1 (n - mid)
		const diff = n - mid;

		// if we found exact number of citations, return the h-index
		if (citations[mid] === diff) return diff;

		// citations at mid is higher than possible h-index
		// to find a more possible citations count, search on the left side
		if (citations[mid] > diff) {
			r = mid - 1;
		} else {
			// citations at mid is lower than possible h-index
			// to find a possible citations count, search on the right side
			l = mid + 1;
		}
	}

	// after the loop is complete, "l" points to the first index where citations[l] >= n - l.
	return n - l;
}

// Time complexity - O(n), n number of citations
// Space complexity - O(n + 1)

// function hIndex(citations: number[]): number {
// 	const n = citations.length;
// 	const bucket = new Array(n + 1).fill(0);
// 	for (let citation of citations) {
// 		if (citation > n) {
// 			bucket[n]++;
// 		} else {
// 			bucket[citation]++;
// 		}
// 	}
// 	let sum = 0;
// 	for (let i = n; i >= 0; i--) {
// 		sum += bucket[i];

// 		if (sum >= i) return i;
// 	}
// 	return -1;
// }

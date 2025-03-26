// (2n)
function hIndexI(citations: number[]): number {
  let buckets: number[] = Array.from({ length: citations.length + 1 });
  buckets.fill(0);
  for (const citation of citations) {
    if (citation >= citations.length) {
      buckets[citations.length]++;
    } else buckets[citation]++;
  }

  console.log(buckets);

  let sum = 0;
  for (let i = citations.length; i >= 0; i--) {
    sum += buckets[i];
    if (sum >= i) return i;
  }
  return -1;
}

// log n
function hIndexII(citations: number[]): number {
  let arr: number[] = Array.from({ length: citations.length });

  let left = 0;
  let right = citations.length - 1;
  console.log("Low: " + left + " Right: " + right);
  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2);
    let diff = citations.length - mid;
    if (diff == citations[mid]) {
      return diff;
    } else if (diff > citations[mid]) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
    console.log("Low: " + left + " Right: " + right);
  }
  return citations.length - left;
}

describe("274. H-Index", () => {
  it("Happy Path - 01", () => {
    expect(hIndexI([1, 2, 4, 5, 6])).toStrictEqual(3);
  });
});

function findUnsortedSubarray(nums: number[]): number {
  if (nums.length <= 1) return 0;
  let n = nums.length;
  let left = 0;
  let right = n - 2;

  let min = Number.MAX_SAFE_INTEGER;
  let max = Number.MIN_SAFE_INTEGER;

  for (let i = 0; i < n; i++) {
    if (i > 0 && nums[i] < nums[i - 1]) {
      left = i;
      min = Math.min(min, nums[i]);
    }
    if (i + 1 < n && nums[i] > nums[i + 1]) {
      right = i;
      max = Math.max(max, nums[i]);
    }
  }

  console.log("Left: " + left + " Right:" + right);

  if (min == Number.MAX_SAFE_INTEGER && max == Number.MIN_SAFE_INTEGER)
    return 0;

  for (let i = 0; i < left; i++) {
    if (nums[i] > min) {
      left = i;
      break;
    }
  }

  for (let i = n - 1; i >= 0; i--) {
    if (nums[i] < max) {
      right = i;
      break;
    }
  }
  return right - left + 1;
}

describe("581. Shortest Unsorted Continuous Subarray", () => {
  it("Happy Path", () => {
    expect(findUnsortedSubarray([2, 6, 4, 8, 10, 9, 15])).toStrictEqual(5);
  });

  it("Sorted array", () => {
    expect(findUnsortedSubarray([1, 2, 3, 4])).toStrictEqual(0);
  });

  it("Reverse Array", () => {
    expect(findUnsortedSubarray([2, 1])).toStrictEqual(2);
  });

  it("Single object", () => {
    expect(findUnsortedSubarray([1])).toStrictEqual(0);
  });

  it("Array with duplicates", () => {
    expect(findUnsortedSubarray([1, 3, 2, 2, 2])).toStrictEqual(4);
  });
});
